package com.crio.jukebox.services;

import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exception.PlayListNotFoundException;
import com.crio.jukebox.repositories.IPlaylistrepositories;

public class Playservice implements IPlayService{
    private final IPlaylistrepositories playlistrepository;
    
    public Playservice(IPlaylistrepositories playlistrepository){
        this.playlistrepository = playlistrepository;
     
    }
    @Override
    public Playlist playplaylist(String userid, String playlistid) {
        // TODO Auto-generated method stub
        Playlist playlist = playlistrepository.findById(playlistid).orElseThrow(() -> new PlayListNotFoundException("Playlist not found"));
        if(playlist.getSongid().isEmpty()){
            throw new PlayListNotFoundException("Playlist is empty");
        }
        else{
            playlist.getSongid().get(0);
        }       
        return playlist;        
    }

    @Override
    public void playsong(String userid, String command) {
        // TODO Auto-generated method stub 
        if("NEXT".equals(command)){

        }
        else if("BACK".equals(command)){
            
        }
        else{
            String songid = command;
        }       
    }
}
