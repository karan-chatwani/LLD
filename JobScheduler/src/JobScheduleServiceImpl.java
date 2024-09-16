import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JobScheduleServiceImpl implements IJobScheduler {
    private PriorityQueue<Job> jobPriorityQueue;
    private Lock queueLock;
    private Condition entryAdded;
    private static JobScheduleServiceImpl INSTANCE = new JobScheduleServiceImpl(Runtime.getRuntime().availableProcessors() - 1);

    private JobScheduleServiceImpl(int threadCount) {
        jobPriorityQueue = new PriorityQueue<>();
        queueLock = new ReentrantLock();
        entryAdded = queueLock.newCondition();
        Thread executor = new Thread(new JobExecutorService(jobPriorityQueue, queueLock, entryAdded, threadCount));
        executor.start();
    }

    public static JobScheduleServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void scheduleOneTimeJob(Runnable task, int delay, TimeUnit unit) {
        Date startDate = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(delay));
        Job job = new Job(task, TaskType.ONE_TIME, startDate, -1, unit);
        addJobToQueue(job);
    }

    @Override
    public void scheduleReccuringJob(Runnable task, int delay, int recurringDelay, TimeUnit unit) {
//        Date startDate = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(delay));
        Date startDate = new Date(System.currentTimeMillis() + unit.toMillis(delay));
        Job job = new Job(task, TaskType.RECCURING, startDate, recurringDelay, unit);
        addJobToQueue(job);
    }

    @Override
    public void scheduleReccuringJobWithAdditinalDelay(Runnable task, int delay, int recurringDelay, TimeUnit unit) {
        Date startDate = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(delay));
        Job job = new Job(task, TaskType.RECURRING_WITH_DELAY, startDate, recurringDelay, unit);
        addJobToQueue(job);
    }

    private void addJobToQueue(Job job) {
        queueLock.lock();
        try {
            jobPriorityQueue.add(job);
            entryAdded.signal();
        } finally {
            queueLock.unlock();

        }
    }
}
