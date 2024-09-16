import java.util.ArrayList;
import java.util.List;

public class Directory extends Entity {
    private List<Entity> entityList;
    private String directoryName;

    public Directory(String directoryName) {
        super(directoryName);
        this.directoryName = directoryName;
        entityList = new ArrayList<>();
    }

    public List<Entity> getEntityList() {
        return entityList;
    }
}
