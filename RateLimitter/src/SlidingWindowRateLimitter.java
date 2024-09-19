import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimitter implements IRateLimitter {
    private Map<String, Queue<Long>> userTimeStampRequests;
    private final int maxRequestsAllowed;
    private final int windowSizeInMillis;

    public SlidingWindowRateLimitter(int maxRequestsAllowed, int windowSizeInMillis) {
        userTimeStampRequests = new ConcurrentHashMap<>();
        this.maxRequestsAllowed = maxRequestsAllowed;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis();
        userTimeStampRequests.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> userQueue = userTimeStampRequests.get(userId);
        while (!userQueue.isEmpty() && userQueue.peek() < (currentTime - windowSizeInMillis)) {
            userQueue.poll();
        }
        if (userQueue.size() < maxRequestsAllowed) {
            userQueue.add(currentTime);
            return true;
        }
        return false;
    }
}
