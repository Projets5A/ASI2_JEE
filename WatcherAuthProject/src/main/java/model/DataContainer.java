package model;

import common.Role;
import common.UserModel;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class DataContainer {

    @PostConstruct
    public void init() {
        System.out.println("Init !!");
        // add user in DB
    }


    public Role checkUser(UserModel user){

        return user.getRole();
    }
}
