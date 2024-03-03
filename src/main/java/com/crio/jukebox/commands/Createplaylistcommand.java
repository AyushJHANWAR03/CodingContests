package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.Iplaylistservice;

public class Createplaylistcommand implements Icommand {
    private final Iplaylistservice playlistservice;

    public Createplaylistcommand(Iplaylistservice playlistservice) {
        this.playlistservice = playlistservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String playlistid = tokens.get(1);
        String playlistname = tokens.get(2);
        List<String> songid = tokens.subList(3, tokens.size());

        Playlist result = playlistservice.create(playlistid, playlistname, songid);
        System.out.println(result);
    }
    
}
