package ejb;

import common.UserModel;

import javax.ejb.Local;

@Local
public interface MessageReceiverSyncLocal {

    UserModel receiveMessage();

}
