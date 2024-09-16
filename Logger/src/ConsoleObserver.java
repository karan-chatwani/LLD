public class ConsoleObserver implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Printing message on console " + message);
    }
}
