package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.Iplaylistservice;

public class Modifyplaylistcommand implements Icommand{

    private final Iplaylistservice playlistservice;

    public Modifyplaylistcommand(Iplaylistservice playlistservice) {
        this.playlistservice = playlistservice;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userid = tokens.get(1);
        String playlistid = tokens.get(2);
        List<String> songid = tokens.subList(3, tokens.size());

        Playlist modifyplaylist = playlistservice.modify(userid, playlistid, songid);
        System.out.println(modifyplaylist);
    }

    
}
