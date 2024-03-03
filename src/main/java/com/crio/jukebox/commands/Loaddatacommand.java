package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.services.Iuserservice;

public class Loaddatacommand implements Icommand{
    private final Iuserservice userservice;

    public Loaddatacommand(Iuserservice userservice) {
        this.userservice = userservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String username = tokens.get(1);

        User result = userservice.createuser(username);
        System.out.println(result);
    }

    
}
