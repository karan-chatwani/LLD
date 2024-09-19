import models.Calender;
import models.Interval;
import models.MeetingRoom;
import models.MeetingRoomSelectionStrategy;

import java.util.List;

public class LeastSpillageMeetingRoom implements MeetingRoomSelectionStrategy {
    @Override
    public MeetingRoom getMeetingRoom(List<MeetingRoom> availableMeetingRooms, int capacity, Interval interval) {
        MeetingRoom selectedMeetingRoom = availableMeetingRooms.get(0);
        for (int i = 1; i < availableMeetingRooms.size(); i++) {
            int maxTimeAvailable = getMaxtimeAvailable(availableMeetingRooms.get(i).getCalender(), interval);
            if (getMaxtimeAvailable(selectedMeetingRoom.getCalender(), interval) > maxTimeAvailable) {
                selectedMeetingRoom = availableMeetingRooms.get(i);
            }
        }
        return selectedMeetingRoom;
    }

    public int getMaxtimeAvailable(Calender calender, Interval interval) {
        return calender.getNextMeetingStartTime(interval);
    }
}
