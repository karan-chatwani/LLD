import java.util.Optional;

public interface ITopic {
    void enqueueMessage(Message message);
    Optional<Message> readMessageIfPresent(int offset);
}
