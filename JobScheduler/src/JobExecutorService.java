import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class JobExecutorService implements Runnable {
    private PriorityQueue<Job> jobPriorityQueue;
    private Lock queueLock;
    private Condition entryAdded;
    private Executor jobExecutor;

    public JobExecutorService(PriorityQueue<Job> jobPriorityQueue, Lock queueLock, Condition entryAdded, int threadCount) {
        this.jobPriorityQueue = jobPriorityQueue;
        this.queueLock = queueLock;
        this.entryAdded = entryAdded;
        this.jobExecutor = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public void run() {
        while (true) {
            queueLock.lock();
            try {
                if (!jobPriorityQueue.isEmpty()) {
                    Job job = jobPriorityQueue.peek();
                    if (job.getStartTime().before(new Date())) {
                        jobPriorityQueue.remove();
                        jobExecutor.execute(job);
                    }
                    try {
                        entryAdded.await(job.getStartTime().getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {

                    }
                } else {
                    try {
                        entryAdded.await(); //no jobs in queue, so wait for signal when some thread pushes in queue
                    } catch (InterruptedException e) {

                    }
                }
            } finally {
                queueLock.unlock();
            }

        }
    }
}
