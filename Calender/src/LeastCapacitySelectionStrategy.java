import models.Interval;
import models.MeetingRoom;
import models.MeetingRoomSelectionStrategy;

import java.util.List;

public class LeastCapacitySelectionStrategy implements MeetingRoomSelectionStrategy {
    @Override
    public MeetingRoom getMeetingRoom(List<MeetingRoom> availableMeetingRooms, int capacity, Interval interval) {
        MeetingRoom meetingRoom = availableMeetingRooms.get(0);
        for (int i = 1; i < availableMeetingRooms.size(); i++) {
            if (availableMeetingRooms.get(i).getCapacity() < meetingRoom.getCapacity()) {
                meetingRoom = availableMeetingRooms.get(i);
            }
        }
        return meetingRoom;
    }
}
