import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QueueMediatorImpl implements IQueueMediator {
    private Map<String, ITopic> topicMap;

    public QueueMediatorImpl() {
        topicMap = new HashMap<>();
    }

    @Override
    public void addTopic(String topicName) {
        System.out.println("Added topic " + topicName);
        topicMap.put(topicName, new TopicImpl());
    }

    @Override
    public void publishToTopic(Message message, String topicName) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        topicMap.get(topicName).enqueueMessage(message);
    }

    @Override
    public Optional<Message> readMessageIfPresent(String topicName, int offset) {
        return topicMap.get(topicName).readMessageIfPresent(offset);
    }
}
