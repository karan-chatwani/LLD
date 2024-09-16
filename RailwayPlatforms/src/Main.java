public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


//Implement a railway station scheduler.
// The railway station has N platforms, and trains need a platform.
// Trains will spend a fixed duration of time at their respective platform before leaving.
// For this problem, we will be considering a 1-hour window.
// Implement: Initialize(totalPlatforms) -> initialze station with totalPlatforms
// ScheduleTrain(name, arrivalTime, duration)
// -> This books a platform for a train can arrive at a particular time, and returns it. If no platform is available, this will return -1.
// If multiple platforms available, return minimum platform number.
// GetWaitingTime(arrivalTime, duration) -> This will return the amount of time a train will have to wait for an appropriate platform to free up.
// FindTrain(trainName) -> Returns the time and platform a train will be at the station
// GetTrainAtPlatform(platformNo, time) -> This returns the train at a certain platform at a certain time.
// Extension: Expand the train struct to include their destination and arrival time there as well.
// Now, implement FindEarliestTrainTo(destination) which returns the earliest train that goes to a particular destination.