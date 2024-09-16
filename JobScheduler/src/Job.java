import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Job implements Runnable, Comparable<Job> {
    private String jobId;
    private Runnable task;
    private TaskType taskType;
    private Date startTime;
    private int rechedulePeriod;
    private TimeUnit unit;

    public Date getStartTime() {
        return this.startTime;
    }

    public Job(Runnable task, TaskType taskType, Date startTime, int rechedulePeriod, TimeUnit unit) {
        this.jobId = UUID.randomUUID().toString();
        this.task = task;
        this.taskType = taskType;
        this.startTime = startTime;
        this.rechedulePeriod = rechedulePeriod;
        this.unit = unit;
    }


    @Override
    public void run() {
        if (TaskType.RECCURING.equals(this.taskType)) {
            JobScheduleServiceImpl.getInstance().scheduleReccuringJob(this.task, rechedulePeriod, rechedulePeriod, unit);
        }
        System.out.println("Running task with jobId " + this.jobId);
        task.run();
        if (TaskType.RECURRING_WITH_DELAY.equals(this.taskType)) {
            JobScheduleServiceImpl.getInstance().scheduleReccuringJob(this.task, rechedulePeriod, rechedulePeriod, unit);
        }
    }

    @Override
    public int compareTo(Job job) {
        return (int) (this.startTime.getTime() - job.startTime.getTime());
    }
}
