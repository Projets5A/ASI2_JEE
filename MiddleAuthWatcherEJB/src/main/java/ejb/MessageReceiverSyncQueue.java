package ejb;

import common.UserModel;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

public class MessageReceiverSyncQueue implements MessageReceiverSyncQueueLocal {


    @Inject
    JMSContext context;


    @Resource(mappedName = "java:/projetqueue")
    Queue queue;

    public void receiveMessage(String message) {
        context.createConsumer(queue);
    }
    public void receiveMessage(UserModel user) {
        try {
            ObjectMessage message = context.createObjectMessage();
            message.setObject(user);
            context.createConsumer(queue);
            System.out.print("receiver queue ok");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}