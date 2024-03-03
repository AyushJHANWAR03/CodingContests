package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.services.Iuserservice;

public class Createusercommand implements Icommand {

    private final Iuserservice userservice;
    public Createusercommand(Iuserservice userservice) {
        this.userservice = userservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String name =  tokens.get(1);
        User result = userservice.createuser(name);
        System.out.println(result);
    }
    
}
