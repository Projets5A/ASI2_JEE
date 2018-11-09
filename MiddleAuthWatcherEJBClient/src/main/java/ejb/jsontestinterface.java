package ejb;

import common.UserModel;

import javax.ejb.Local;

@Local
public interface jsontestinterface {

    String test(UserModel user);
}
