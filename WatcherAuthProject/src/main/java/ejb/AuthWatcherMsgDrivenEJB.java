package ejb;

import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import common.Role;
import common.UserModel;
import model.DataContainer;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(
                        propertyName = "destination",
                        propertyValue = "java:/projettopic")
        })

public class AuthWatcherMsgDrivenEJB implements MessageListener {

    @Inject
    private DataContainer dataContainer;

    @EJB MessageSenderQueueLocal sender;

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                System.out.println("Topic: I received a TextMessage at "+ new Date());
                TextMessage msg = (TextMessage) message;
                System.out.println("Message is : " + msg.getText());

            } else if (message instanceof ObjectMessage) {
                System.out.println("Topic: I received an ObjectMessage at "
                        + new Date());
                ObjectMessage msg = (ObjectMessage) message;

                if( msg.getObject() instanceof UserModel){
                    UserModel user=(UserModel)msg.getObject();

                    System.out.println("User Details: ");
                    System.out.println("login:"+user.getUsername());
                    System.out.println("pwd:"+user.getPwd());

                    Role currentTestRole=dataContainer.checkUser(user);
                    if( Role.NONE==currentTestRole){
                        sender.sendMessage(user);
                    }else{
                        user.setRole(currentTestRole);
                        sender.sendMessage(user);
                    }
                }
            } else {
                System.out.println("Not valid message for this Queue MDB");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

