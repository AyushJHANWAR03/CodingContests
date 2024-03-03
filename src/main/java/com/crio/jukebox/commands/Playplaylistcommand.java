package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.IPlayService;

public class Playplaylistcommand implements Icommand{
    private final IPlayService playservice;
  
    public Playplaylistcommand(IPlayService playservice) {
        this.playservice = playservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userid = tokens.get(1);
        String playlistid = tokens.get(2);
        
        // Assuming playservice.playplaylist returns a Playlist
        Playlist playlist = playservice.playplaylist(userid, playlistid);   
        
        System.out.println(playlist);  
    }

}