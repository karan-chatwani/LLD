import java.util.List;

public class Artist {
    private String artistName;
    private List<Music> musicList;

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
