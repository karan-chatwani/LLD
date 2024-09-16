public class FileObserver implements LogObserver{

    @Override
    public void log(String message) {
        System.out.println("Printing message to file "+message);
    }
}
