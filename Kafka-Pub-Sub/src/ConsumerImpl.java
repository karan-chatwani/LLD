import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ConsumerImpl implements IConsumer {
    private String name;
    private List<String> subscribedTopics;
    private IQueueMediator iQueueMediator;
    private Map<String, Integer> topicToOffsetMap;

    public ConsumerImpl(String name, IQueueMediator iQueueMediator) {
        this.iQueueMediator = iQueueMediator;
        this.name = name;
        subscribedTopics = new ArrayList<>();
        topicToOffsetMap = new HashMap<>();
        init();
    }

    private void init() {
        Thread consumerThread = new Thread(this::consumerRunner);
        consumerThread.start();
    }

    @Override
    public void subscribeToTopic(String topicName) {
        subscribedTopics.add(topicName);
        topicToOffsetMap.put(topicName, 0);
    }

    private void consumerRunner()  {
        while (true) {
            for (String topic : subscribedTopics) {
                int offset = topicToOffsetMap.get(topic);
                Optional<Message> message=iQueueMediator.readMessageIfPresent(topic, offset);
                if(message.isPresent()){
                    consume(message.get(),topic,offset);
                    offset++;
                }
                topicToOffsetMap.put(topic,offset);
            }
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                //handle
            }
        }

    }
    private void consume(Message message,String topicName,int offset){
        System.out.println("ConsumerThread consumming message "+ Thread.currentThread().getName()+ " "+ message.getMessage()+" "+topicName+" "+offset);
    }
}
