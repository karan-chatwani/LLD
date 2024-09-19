package models;

import java.util.List;
import java.util.UUID;

public class MeetingRoom {
    private String meetingRoomId;
    private int capacity;
    private Calender calender;

    public MeetingRoom(String meetingRoomId, int capacity) {
        this.meetingRoomId = meetingRoomId;
        this.capacity = capacity;
        calender = new Calender();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getMeetingRoomId() {
        return this.meetingRoomId;
    }

    public boolean isAvailable(Interval interval, int capacity) {
        if (this.capacity < capacity) return false;
        return calender.isSlotAvailable(interval.getStartTime(), interval.getEndTime());
    }
    public synchronized void bookRoom(Interval interval, List<User> userList) {
        if (!isAvailable(interval, userList.size())) {
            throw new RuntimeException("Not available now");
        }
        Meeting meeting = new Meeting();
        meeting.setRoomId(meetingRoomId);
        meeting.setMeetingId(UUID.randomUUID().toString());
        meeting.setInterval(interval);
        meeting.setUserList(userList);
        calender.addMeeting(meeting);
    }
}
