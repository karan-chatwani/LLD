import java.util.HashMap;
import java.util.Map;

public class File {
    boolean isFile = false;
    Map<String, File> files;
    String content;

    public File() {
        isFile = false;
        files = new HashMap<>();
        content = "";
    }
}

