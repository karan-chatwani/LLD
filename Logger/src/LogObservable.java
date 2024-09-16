import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogObservable {
    private Map<LogType, List<LogObserver>> logTypeListMap;

    public LogObservable() {
        this.logTypeListMap = new HashMap<>();
    }

    public void addObserver(LogType logType, LogObserver logObserver) {
        List<LogObserver> logObservers = logTypeListMap.getOrDefault(logType, new ArrayList<>());
        logObservers.add(logObserver);
        logTypeListMap.put(logType, logObservers);
    }

    public void removeObserver(LogType logType, LogObserver logObserver) {
        logTypeListMap.get(logType).remove(logObserver);
    }

    public void notifyObserver(LogType logType, String message) {
        System.out.println(logTypeListMap.get(logType));
        for (LogObserver logObserver : logTypeListMap.get(logType)) {
            logObserver.log(message);
        }
    }
}
