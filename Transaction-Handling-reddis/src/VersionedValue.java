public class VersionedValue {
    private String value;
    private long version;

    public VersionedValue(String value, long version) {
        this.version = version;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public long getVersion() {
        return version;
    }
}
