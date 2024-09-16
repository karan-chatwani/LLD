package models;

import java.util.List;

public class Meeting {
    private String meetingId;
    private Interval interval;
    private List<User> userList;
    private String roomId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


}
