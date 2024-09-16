public class Schedule implements Comparable<Schedule> {
    private String trainName;
    private int start;
    private int end;

    public Schedule(String trainName, int start, int end) {
        this.trainName = trainName;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Schedule o) {
        return this.start - o.start;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
