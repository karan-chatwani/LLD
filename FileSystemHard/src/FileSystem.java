import java.util.List;

class FileSystem {
    private Directory directory;

    public FileSystem() {
        directory = new Directory("root");
    }

    public List<String> ls(String path) {
        Directory cur = directory;
        String[] token = path.split("/");
        for (String file : token) {
            for (Entity entity : cur.getEntityList()) {
                if(entity instanceof File)
                if (entity.getName().equals(token)) {
//                    cur = entity;
                }
            }
        }
        return null;
    }

    public void mkdir(String path) {

    }

    public void addContentToFile(String filePath, String content) {

    }

    public String readContentFromFile(String filePath) {
  return null;
    }
}