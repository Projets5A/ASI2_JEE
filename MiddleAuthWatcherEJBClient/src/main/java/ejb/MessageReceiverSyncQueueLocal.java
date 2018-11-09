package ejb;

import common.UserModel;

public interface MessageReceiverSyncQueueLocal {

    void receiveMessage(UserModel user);
}
