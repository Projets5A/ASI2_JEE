package rest;


import common.UserModel;
import ejb.MessageReceiverSyncLocal;
import ejb.MessageSenderLocal;
import ejb.jsontestinterface;
import javax.inject.Inject;


public class WatcherAuthMessage implements WatcherAuthInterface{

    private static final long serialVersionUID = 1L;

    @Inject
    MessageSenderLocal sender;

    @Inject
    MessageReceiverSyncLocal receiver;

    @Inject
    jsontestinterface testinterface;





    @Override
    public String message(UserModel user) {

        //Afficher

        sender.sendMessage(user);
        System.out.println("coucou je suis bsahtek saraidaryan");
        return testinterface.test(user);
    }

}