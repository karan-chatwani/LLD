public interface EvictionPolicy <Key>{
    void keyAccessded(Key key);
    Key evict();
}
