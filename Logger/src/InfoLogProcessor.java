public class InfoLogProcessor extends LogProcessor {
    protected InfoLogProcessor(LogProcessor nextLogProcessor, LogObservable logObservable) {
        super(nextLogProcessor, logObservable);
    }

    @Override
    public void log(LogType logType, String message) {
        if (logType.equals(LogType.INFO)) {
            logObservable.notifyObserver(LogType.INFO, message);
        } else {
            super.log(logType, message);
        }
    }
}
