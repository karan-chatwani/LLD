import java.util.Optional;

public interface IQueueMediator {
    void addTopic(String topicName);

    void publishToTopic(Message message, String topicName);

    Optional<Message> readMessageIfPresent(String topicName, int offset);

}
