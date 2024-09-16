package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Calender {
    List<Meeting> meetings;
    TreeMap<Integer, Integer> calender;

    public Calender() {
        calender=new TreeMap<>();
        meetings = new ArrayList<>();
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        calender.put(meeting.getInterval().getStartTime(), meeting.getInterval().getEndTime());
    }

    public boolean isSlotAvailable(int start, int end) {
        Map.Entry<Integer, Integer> lowerSlot = calender.floorEntry(start);
        Map.Entry<Integer, Integer> higherSlot = calender.ceilingEntry(start);
        return (lowerSlot==null || lowerSlot.getValue() <= start) && (higherSlot==null || end <= higherSlot.getKey());
    }
}
