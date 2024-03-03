package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayService;

public class Playsongcommand implements Icommand{
    private final IPlayService playservice;
    
    public Playsongcommand(IPlayService playservice) {
        this.playservice = playservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userid = tokens.get(1);
        String command = tokens.get(2);
        playservice.playsong(userid, command);
    }

    
}
