public interface IQservice {
    void createTopic(String name);

    IProducer createProducer(String name);

    IConsumer createConsumer(String name);

}
