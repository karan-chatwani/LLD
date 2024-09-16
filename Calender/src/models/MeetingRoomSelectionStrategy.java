package models;

import java.util.List;

public interface MeetingRoomSelectionStrategy {
    MeetingRoom getMeetingRoom(List<MeetingRoom> availableMeetingRooms,int capacity,Interval interval);
}
