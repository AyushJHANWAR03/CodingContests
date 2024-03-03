package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Playlist;

public class Playlistrepositories implements IPlaylistrepositories{
    private final Map<String,Playlist> playlistmap;
    private Integer autoincrement = 0;

    public Playlistrepositories(){
        playlistmap = new HashMap<>();
    }
    public Playlistrepositories(Map<String, Playlist> playlistmap) {
        this.playlistmap = playlistmap;
        this.autoincrement = playlistmap.size();
    }


    @Override
    public Playlist save(Playlist entity) {
        // TODO Auto-generated method stub
        if(entity.getId() == null){
            autoincrement++;
            Playlist p = new Playlist(Integer.toString(autoincrement), entity.getPlaylistid(),entity.getPlaylistname(),entity.getSongid());
            playlistmap.put(p.getId(),p);
            return p;
        }
        playlistmap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        return playlistmap.values().stream()
        .collect(Collectors.toList());
    }

    @Override
    public  Optional<Playlist> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(playlistmap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return playlistmap.containsKey(id);
    }

    @Override
    public void delete(Playlist entity) {

        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        playlistmap.remove(id);
        // TODO Auto-generated method stub       
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
   
}
