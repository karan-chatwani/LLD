import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FileSystem {
    File file;
    public FileSystem() {
        file=new File();
    }

    public List<String> ls(String path) {
        File temp=file;
        List<String> files=new ArrayList<>();
        if(!path.equals("/")){
            String[] paths=path.split("/");
            for(int i=1;i<paths.length;i++){
                temp=temp.files.get(paths[i]);
            }
            if(temp.isFile){
                files.add(paths[paths.length-1]);
                return files;
            }
        }
        for(String name: temp.files.keySet())
            files.add(name);
        Collections.sort(files);
        return files;
    }

    public void mkdir(String path) {
        File temp=file;
        if(!path.equals("/")){
            String[] paths=path.split("/");
            for(int i=1;i<paths.length;i++){
                if(!temp.files.containsKey(paths[i])){
                    temp.files.put(paths[i],new File());
                }
                temp=temp.files.get(paths[i]);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        File temp=file;
        if(!filePath.equals("/")){
            String[] paths=filePath.split("/");
            for(int i=1;i<paths.length-1;i++){
                temp=temp.files.get(paths[i]);
            }
            if(temp.files.containsKey(paths[paths.length-1])){
                temp=temp.files.get(paths[paths.length-1]);
            }
            else{
                temp.files.put(paths[paths.length-1],new File());
                temp=temp.files.get(paths[paths.length-1]);
                temp.isFile=true;
            }
            temp.content+=content;
        }
    }

    public String readContentFromFile(String filePath) {
        File temp=file;
        String content="";
        if(!filePath.equals("/")){
            String[] paths=filePath.split("/");
            for(int i=1;i<paths.length;i++){
                temp=temp.files.get(paths[i]);
            }
            content+=temp.content;
        }
        return content;
    }
}