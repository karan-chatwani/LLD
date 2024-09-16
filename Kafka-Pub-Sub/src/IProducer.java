public interface IProducer {
    void publishToTopic(Message message,String topicName);
}
