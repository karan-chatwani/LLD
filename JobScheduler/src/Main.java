import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        JobScheduleServiceImpl jobScheduleService = JobScheduleServiceImpl.getInstance();
        Runnable task1 = () ->
                System.out.println("Running task1 at time " + new Date(System.currentTimeMillis()));

        jobScheduleService.scheduleReccuringJob(task1, 10, 10, TimeUnit.SECONDS);
        System.out.println("Hello world!");
    }
}