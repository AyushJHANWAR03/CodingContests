package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Song;

public class Songrepository implements ISongrepositories{

    private final Map<String,Song> songmap;
    private Integer autoincrement = 0;

    public Songrepository(){
        songmap = new HashMap<>();
    }
    public Songrepository(Map<String, Song> songmap){
        this.songmap = songmap;
        this.autoincrement = songmap.size();
    }

    @Override
    public Song save(Song entity) {
        
        // TODO Auto-generated method stub
        if(entity.getId() == null){
            autoincrement++;
            Song s = new Song(Integer.toString(autoincrement),entity.getSongName(), entity.getGenre(), entity.getAlbum(), entity.getMainartist(), entity.getOtherartist());
            songmap.put(entity.getId(), entity);
            return s;
        }
        songmap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub

        return songmap.values().stream()
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(songmap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return songmap.containsKey(id);
    }

    @Override
    public void delete(Song entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
