
package ejb;

import common.UserModel;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
@LocalBean
public class MessageReceiverSync implements MessageReceiverSyncLocal {

    @Inject
    JMSContext context;

    @Resource(mappedName = "java:/projetqueue")
    Queue queue;

        public UserModel receiveMessage() {
            UserModel message = new UserModel();
            JMSConsumer consumer = context.createConsumer(queue);
            message = (UserModel) consumer.receive(1000);
            return message;
        }
}