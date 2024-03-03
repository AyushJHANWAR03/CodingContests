package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;

public interface Iplaylistservice {
    public Playlist create(String playlistid, String playlistname, List<String> songid);
    void deleteplaylist(String userid, String playlistid);
    public Playlist modify(String userid, String playlistid, List<String> songid);   
}
