import java.util.List;

public class Directory implements FileSystem {
    private String directoryName;
    private List<FileSystem> fileSystem;

    public Directory(List<FileSystem> fileSystem, String directoryName) {
        this.fileSystem = fileSystem;
        this.directoryName = directoryName;
    }

    @Override
    public void ls() {
        System.out.println(directoryName);
        for (FileSystem fileSystem1 : fileSystem) {
            fileSystem1.ls();
        }
    }
}
