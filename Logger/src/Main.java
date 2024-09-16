public class Main {
    public static void main(String[] args) {
        FileObserver fileObserver = new FileObserver();
        LogObservable logObservable = new LogObservable();
        logObservable.addObserver(LogType.DEBUG, fileObserver);
        logObservable.addObserver(LogType.INFO, fileObserver);
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(null, logObservable), logObservable);
        logProcessor.log(LogType.INFO, "check");
        System.out.println("Hello world!");
    }
}