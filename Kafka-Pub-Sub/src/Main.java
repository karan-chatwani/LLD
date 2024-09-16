public class Main {
    public static void main(String[] args) {
        //publisher, message, consumer, queue, topics,mediattor
        IQueueMediator queueMediator = new QueueMediatorImpl();
        IQservice qservice = new QueueServiceImpl(queueMediator);

        qservice.createTopic("topic1");
        qservice.createTopic("topic2");
        qservice.createTopic("topic3");

        IProducer producer1 = qservice.createProducer("prducer1");
        IProducer producer2 = qservice.createProducer("prducer2");
        IProducer producer3 = qservice.createProducer("prducer3");

        IConsumer consumer1 = qservice.createConsumer("consumer1");
        IConsumer consumer2 = qservice.createConsumer("consumer2");
        IConsumer consumer3 = qservice.createConsumer("consumer3");

        consumer1.subscribeToTopic("topic1");
        consumer2.subscribeToTopic("topic2");
        consumer3.subscribeToTopic("topic1");

        Message message1 = new Message("karan");
        Message message2 = new Message("puneet");

        producer1.publishToTopic(message1, "topic1");
        producer2.publishToTopic(message2, "topic2");
        producer1.publishToTopic(message2, "topic1");


    }
}