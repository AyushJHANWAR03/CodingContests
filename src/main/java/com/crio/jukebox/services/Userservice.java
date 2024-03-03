package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IUserrepositories;

public class Userservice implements Iuserservice{
    public final IUserrepositories userrepositories;
    public Userservice(IUserrepositories userrepositories) {
        this.userrepositories = userrepositories;
    }
    @Override
    public User createuser(String username) {
        // TODO Auto-generated method stub
        User newUser = new User(username,List.of());
        userrepositories.save(newUser);
        return newUser;
    }
    
}
