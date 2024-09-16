import java.util.concurrent.TimeUnit;

public interface IJobScheduler {
    void scheduleOneTimeJob(Runnable task, int delay, TimeUnit unit);

    void scheduleReccuringJob(Runnable task, int delay, int recurringDelay, TimeUnit unit);

    void scheduleReccuringJobWithAdditinalDelay(Runnable task, int delay, int recurringDelay, TimeUnit unit);

}
