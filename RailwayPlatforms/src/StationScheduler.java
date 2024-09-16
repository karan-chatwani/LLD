import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationScheduler {
    private List<Platform> platformList;
    private Map<Integer, Platform> platformMap;
    private int totalPlatforms;
    private PlatformSelectionStrategy platformSelectionStrategy;

    public StationScheduler(int totalPlatforms, PlatformSelectionStrategy platformSelectionStrategy) {
        this.totalPlatforms = totalPlatforms;
        platformList = new ArrayList<>(totalPlatforms);
        platformMap = new HashMap<>();
        for (int i = 1; i <= totalPlatforms; i++) {
            Platform platform = new Platform(i);
            platformList.add(platform);
            platformMap.put(i, platform);
        }
        this.platformSelectionStrategy = platformSelectionStrategy;
    }

    public Platform scheduleTrain(String trainName, int arrivalTime, int duration) {
        Schedule schedule = new Schedule(trainName, arrivalTime, arrivalTime + duration);
        List<Platform> platformsAvailable = new ArrayList<>();
        for (Platform platform : platformList) {
            if (platform.isScheduleAvailable(schedule)) {
                platformsAvailable.add(platform);
            }
        }
        if (platformsAvailable.isEmpty()) return null;
        return platformSelectionStrategy.getPlatform(platformList);
    }

//    public String getTrainAtPlatform(int platformNo, int time) {
//        Platform platform = platformMap.get(platformNo);
//
//    }
}
