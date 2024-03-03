package com.crio.jukebox.services;

import java.util.ArrayList;
import java.util.List;
import com.crio.codingame.repositories.IUserRepository;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exception.PlayListNotFoundException;
import com.crio.jukebox.repositories.IPlaylistrepositories;
import com.crio.jukebox.repositories.ISongrepositories;

public class Playlistservice implements Iplaylistservice {
    private  final IPlaylistrepositories playlistrepository;
    private final ISongrepositories songrepository;

    public Playlistservice(IPlaylistrepositories playlistrepository, ISongrepositories songrepository){
        this.playlistrepository = playlistrepository;
        this.songrepository = songrepository;
    }

    @Override
    public Playlist create(String playlistid, String playlistname, List<String> songid) {
        // TODO Auto-generated method stub
        for (String songids : songid) {
            if(!songrepository.existsById(songids)){
                throw new PlayListNotFoundException("The song is not available");
            }
        }
        Playlist playlist = new Playlist(playlistid, playlistname, new ArrayList<>(songid));
        playlistrepository.save(playlist);
        return playlist;
    }

    @Override
    public void deleteplaylist(String userid, String playlistid) {
        // TODO Auto-generated method stub
        if(!playlistrepository.existsById(playlistid)){
            throw new PlayListNotFoundException("Playlist not available");
        }
        playlistrepository.deleteById(playlistid);
    }

    @Override
    public Playlist modify(String userid, String playlistid, List<String> songid) {
        // TODO Auto-generated method stub
        if (!playlistrepository.existsById(playlistid)) {
            throw new PlayListNotFoundException("Playlist not found");
        }
        for (String songids : songid) {
            if(!songrepository.existsById(songids)){
                throw new PlayListNotFoundException("The song is not available");
            }
        }
        Playlist playlist = playlistrepository.findById(playlistid).orElseThrow(() -> new PlayListNotFoundException("Playlist not found"));
        playlist.getSongid().clear();
        playlist.getSongid().addAll(songid);
        return playlist;
    }
}
