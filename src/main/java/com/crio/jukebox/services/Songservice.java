package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongrepositories;

public class Songservice implements Isongservice {
    private final ISongrepositories songrepositories;
    public Songservice(ISongrepositories songrepositories) {
        this.songrepositories = songrepositories;
    }

    @Override
    public void loaddatafromcsv(String csvfilepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvfilepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                String songName = columns[1];
                String genre = columns[2];
                String album = columns[3];
                String mainartist = columns[4];
                             
                List<String> otherartist = new ArrayList<>(List.of(columns[5].split(",")));
                Song song = new Song(id, songName, genre, album, mainartist, otherartist);
                songrepositories.save(song);
            }

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

}
