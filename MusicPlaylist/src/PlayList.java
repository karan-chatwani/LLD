import java.util.List;

public class PlayList {
    private List<Music> musicList;
    private Toogle toogle;
    private int curIndex;

    public PlayList(List<Music> musicList) {
        this.musicList = musicList;
        toogle = Toogle.OFF;
        curIndex = 0;
    }

    public boolean repeat() {
        if (Toogle.REPEAT == toogle) {
            return false;
        }
        toogle = Toogle.REPEAT;
        return true;
    }

    public boolean repeatList() {
        if (Toogle.REPEAT_LIST == toogle) {
            return false;
        }
        toogle = Toogle.REPEAT_LIST;
        return true;
    }

    public Music next() {
        if (Toogle.REPEAT == toogle) {
            return musicList.get(curIndex);
        }
        if (curIndex == musicList.size() - 1) {
            if (Toogle.REPEAT_LIST == toogle) {
                curIndex = 0;
                return musicList.get(curIndex);
            } else {
                return null;
            }
        }
        curIndex++;
        return musicList.get(curIndex);
    }

}
