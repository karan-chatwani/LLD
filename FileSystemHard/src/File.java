public class File extends Entity {
    private String fileName;
    private String content;

    public File(String fileName, String content) {
        super(fileName);
        this.fileName = fileName;
        this.content = content;
    }

    public void addContent(String content) {
        this.content += content;
    }
}
