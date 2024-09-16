public class QueueServiceImpl implements IQservice {
    private IQueueMediator queueMediator;

    public QueueServiceImpl(IQueueMediator queueMediator) {
        this.queueMediator = queueMediator;
    }

    @Override
    public void createTopic(String name) {
        System.out.println("Creating topic "+name);
        queueMediator.addTopic(name);
    }

    @Override
    public IProducer createProducer(String name) {
        return new ProducerImpl(name, queueMediator);
    }

    @Override
    public IConsumer createConsumer(String name) {
        return new ConsumerImpl(name, queueMediator);
    }
}
