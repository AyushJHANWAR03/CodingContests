package com.crio.jukebox.entities;

import java.util.List;

public class Playlist extends BaseEntity{
    private final String playlistid;
    
    private final String playlistname;
    
    private final List<String> songid;  

    public Playlist(Playlist playlist){
        this(playlist.id ,playlist.playlistid, playlist.playlistname, playlist.songid);
    }

    public Playlist(String playlistid, String playlistname, List<String> songid){
        this.playlistid = playlistid;
        this.playlistname = playlistname;
        this.songid = songid;
       
    }
    public Playlist(String id, String playlistid, String playlistname, List<String> songid){
        this(playlistid,playlistname,songid);
        this.id = id;       
        
    }
   
    public String getPlaylistid() {
        return playlistid;
    }
    public String getPlaylistname() {
        return playlistname;
    }
    public List<String> getSongid() {
        return songid;
    }
   
    @Override
    public String toString(){
        return id + playlistid + playlistname + songid;
    }
    
}
