import models.Interval;
import models.MeetingRoom;
import models.MeetingRoomSelectionStrategy;
import models.MeetingScheduler;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MeetingRoom meetingRoom1 = new MeetingRoom("1", 2);
        MeetingRoom meetingRoom2 = new MeetingRoom("2", 1);
        List<MeetingRoom> meetingRoomList = new ArrayList<>();
        meetingRoomList.add(meetingRoom1);
        meetingRoomList.add(meetingRoom2);
        MeetingRoomSelectionStrategy meetingRoomSelectionStrategy = new LeastCapacitySelectionStrategy();
        MeetingScheduler meetingScheduler = new MeetingScheduler(meetingRoomList, meetingRoomSelectionStrategy);
        User user1 = new User();
        User user2 = new User();
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        Interval interval = new Interval(2, 3);
        System.out.println(meetingScheduler.scheduleMeeting(interval,1,userList));
        System.out.println(meetingScheduler.scheduleMeeting(interval,1,userList));

        Interval interval1=new Interval(5,7);
        System.out.println(meetingScheduler.scheduleMeeting(interval1,2,userList));

        Interval interval2=new Interval(3,6);
        System.out.println(meetingScheduler.scheduleMeeting(interval2,1,userList));

        System.out.println("Hello world!");
    }
}
//calender event