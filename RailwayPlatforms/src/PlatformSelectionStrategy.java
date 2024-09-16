import java.util.List;

public interface PlatformSelectionStrategy {
    Platform getPlatform(List<Platform> platformList);
}
