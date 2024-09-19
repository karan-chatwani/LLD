package models;

public class Interval {
    private int startTime;
    private int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }


    public int getEndTime() {
        return endTime;
    }

}
