import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap;
    private Map<String, List<String>> userFriendList;
    private Map<String, List<String>> elasticSearch;

    public UserService() {
        userMap = new HashMap<>();
        userFriendList = new HashMap<>();
        elasticSearch = new HashMap<>();
    }

    public void addUser(String userName, String userId, PrivacySetting privacySetting) {
        User user = new User(userId, privacySetting, userName);
        userMap.put(userId, user);
    }

    public void deleteUser(String userId) {
        userMap.remove(userId);
    }

    public void addFriend(String user1, String user2) {
        List<String> friendList1 = userFriendList.getOrDefault(user1, new ArrayList<>());
        friendList1.add(user2);
        userFriendList.put(user1, friendList1);

        List<String> friendList2 = userFriendList.getOrDefault(user2, new ArrayList<>());
        friendList1.add(user1);
        userFriendList.put(user2, friendList2);
    }

    public void addUserInfo(String userId, String city, String college, String company) {
        UserMeta userMeta = new UserMeta(userId, city, college, company);
        userMap.get(userId).addUserMeta(userMeta);
        putInEs(city, userId);
        putInEs(college, userId);
        putInEs(college, userId);
    }

    private void putInEs(String key, String value) {
        elasticSearch.getOrDefault(key, new ArrayList<>()).add(value);
    }

    public List<String> getMatches(String userId, String searchTerm, int pageSize) {
        List<String> searchResults = new ArrayList<>();
        int i = 0;
        while (i < elasticSearch.get(searchTerm).size() && pageSize > 0) {
            String result = elasticSearch.get(searchTerm).get(i);
            if (allowedForMatching(userId, result)) {
                pageSize--;
                searchResults.add(result);
            }
        }
        return searchResults;
    }

    boolean allowedForMatching(String userId, String resultUseId) {
        User resultUser = userMap.get(resultUseId);
        if (resultUser.getPrivacySetting() == PrivacySetting.PUBLIC) {
            return true;
        }
        if (userFriendList.get(userId).contains(resultUser)) {
            return true;
        }
        return false;
    }
}
