import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TopicImpl implements ITopic {
    private List<Message> queue;
    private ReentrantLock reentrantLock;
    private Condition condition;

    public TopicImpl() {
        queue = new ArrayList<>();
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
    }

    @Override
    public void enqueueMessage(Message message) {
        System.out.println("Message enqueued" + message.getMessage());
        reentrantLock.lock();
        queue.add(message);
        reentrantLock.unlock();

    }

    @Override
    public Optional<Message> readMessageIfPresent(int offset) {
//        System.out.println(queue.size());
        reentrantLock.lock();
        if (offset >= queue.size()) {
            reentrantLock.unlock();
            return Optional.empty();
        }
        Message message = queue.get(offset);
        reentrantLock.unlock();
        System.out.println("read message" + message.getMessage());
        return Optional.of(message);
    }
}
