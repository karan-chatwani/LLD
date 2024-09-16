package models;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    private List<MeetingRoom> meetingRoomList;
    private MeetingRoomSelectionStrategy meetingRoomSelectionStrategy;

    public MeetingScheduler(List<MeetingRoom> meetingRoomList, MeetingRoomSelectionStrategy meetingRoomSelectionStrategy) {
        this.meetingRoomSelectionStrategy = meetingRoomSelectionStrategy;
        this.meetingRoomList = meetingRoomList;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomList.add(meetingRoom);
    }

    public void removeMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomList.remove(meetingRoom);
    }

    public String scheduleMeeting(Interval interval, int capacity, List<User> userList) {

        List<MeetingRoom> availableMeetingRoom = getAvailableMeetingRooms(interval, capacity);
        if (availableMeetingRoom.isEmpty()) {
            throw new RuntimeException("No meeting room available");
        }
        MeetingRoom meetingRoomSelected = meetingRoomSelectionStrategy.getMeetingRoom(availableMeetingRoom, capacity, interval);
        meetingRoomSelected.bookRoom(interval, userList);
        return meetingRoomSelected.getMeetingRoomId();
    }

    private List<MeetingRoom> getAvailableMeetingRooms(Interval interval, int capacity) {
        List<MeetingRoom> availableMeeetingRoom = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRoomList) {
            if (meetingRoom.isAvailable(interval, capacity)) {
                availableMeeetingRoom.add(meetingRoom);
            }
        }
        return availableMeeetingRoom;
    }
}
