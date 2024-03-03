package com.crio.jukebox.services;

import com.crio.jukebox.entities.Playlist;

public interface IPlayService {
    Playlist playplaylist(String userid, String playlistid);
    public void playsong(String userid, String command);
}
