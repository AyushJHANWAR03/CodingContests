package com.crio.jukebox.commands;

import java.util.List;

import com.crio.jukebox.services.Iplaylistservice;

public class Deleteplaylistcommand implements Icommand{
    private final Iplaylistservice playlistservice;

    public Deleteplaylistcommand(Iplaylistservice playlistservice){
        this.playlistservice = playlistservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userid = tokens.get(1);
        String playlistid = tokens.get(2);
        playlistservice.deleteplaylist(userid, playlistid);
    }
    
}
