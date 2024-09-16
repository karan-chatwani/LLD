public abstract class LogProcessor {
    private LogProcessor nextLogProcessor;
    protected LogObservable logObservable;

    protected LogProcessor(LogProcessor nextLogProcessor, LogObservable logObservable) {
        this.nextLogProcessor = nextLogProcessor;
        this.logObservable = logObservable;
    }

    public void log(LogType logType, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logType, message);
        }
    }
}
