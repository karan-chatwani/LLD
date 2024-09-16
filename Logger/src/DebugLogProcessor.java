public class DebugLogProcessor extends LogProcessor {
    protected DebugLogProcessor(LogProcessor nextLogProcessor, LogObservable logObservable) {
        super(nextLogProcessor, logObservable);
    }

    @Override
    public void log(LogType logType, String message) {
        if (logType.equals(LogType.DEBUG)) {
            logObservable.notifyObserver(LogType.DEBUG, message);
        } else {
            super.log(logType, message);
        }
    }
}
