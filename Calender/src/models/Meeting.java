package models;

import java.util.List;

public class Meeting {
    private String meetingId;
    private Interval interval;
    private List<User> userList;
    private String roomId;


    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }


    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


}
