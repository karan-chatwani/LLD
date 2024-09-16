import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProducerImpl implements IProducer {
    private String name;
    private IQueueMediator iQueueMediator;
    private Executor executor;

    public ProducerImpl(String name, IQueueMediator iQueueMediator) {
        this.name = name;
        this.iQueueMediator = iQueueMediator;
        this.executor = Executors.newFixedThreadPool(2);
    }

    @Override
    public void publishToTopic(Message message, String topicName) {
        System.out.println("Publishing message to topic " + topicName);
        executor.execute(() -> iQueueMediator.publishToTopic(message, topicName));
    }
}
