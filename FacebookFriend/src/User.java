public class User {
    private String userId;
    private PrivacySetting privacySetting;
    private String userName;
    private UserMeta userMeta;

    public User(String userId, PrivacySetting privacySetting, String userName) {
        this.userId = userId;
        this.privacySetting = privacySetting;
        this.userName = userName;
    }

    public void addUserMeta(UserMeta userMeta) {
        this.userMeta = userMeta;
    }

    public PrivacySetting getPrivacySetting() {
        return this.privacySetting;
    }
}
