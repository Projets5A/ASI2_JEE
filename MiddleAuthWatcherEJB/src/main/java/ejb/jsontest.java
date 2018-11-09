package ejb;

import common.UserModel;

public class jsontest implements jsontestinterface {

    public String test(UserModel user){

        String information = user.getUsername() + user.getEmail();

        return information;

    }
}
