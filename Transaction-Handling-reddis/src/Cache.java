public interface Cache {
    String get(String key);

    void set(String key, String value);

    void remove(String key);

    void begin();

    boolean commit();

    void rollback();
}
