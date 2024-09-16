import java.util.TreeSet;

public class Platform {
    private int platformNo;
    private TreeSet<Schedule> scheduleTreeSet;

    public Platform(int platformNo) {
        this.platformNo = platformNo;
        scheduleTreeSet = new TreeSet<>();
    }

    public int getPlatformNo() {
        return platformNo;
    }

    public void addSchedule(Schedule schedule) {
        scheduleTreeSet.add(schedule);
    }

    public boolean isScheduleAvailable(Schedule schedule) {
        Schedule lowerSchedule = scheduleTreeSet.floor(schedule);
        Schedule higherSchedule = scheduleTreeSet.higher(schedule);
        return (lowerSchedule == null || lowerSchedule.getEnd() <= schedule.getStart()) && (higherSchedule == null || schedule.getEnd() <= higherSchedule.getStart());
    }
}
//1-7  9-10     4 8
//result ka start > quety kaend