import java.util.List;

public class MinimumPlatformNoSelectionStrategy implements PlatformSelectionStrategy {
    @Override
    public Platform getPlatform(List<Platform> platformList) {
        Platform platform = platformList.get(0);
        for (int i = 1; i < platformList.size(); i++) {
            if (platformList.get(i).getPlatformNo() < platform.getPlatformNo()) {
                platform = platformList.get(i);
            }
        }
        return platform;
    }
}
