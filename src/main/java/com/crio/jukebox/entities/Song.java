package com.crio.jukebox.entities;

import java.util.List;

public class Song extends BaseEntity{
    private final String songName;
    
    private final String genre;
    
    private final String album;
    
  
    private final String mainartist;
    
    private final List<String> otherartist;

    public Song(Song song){
        this(song.id,song.songName,song.genre,song.album,song.mainartist,song.otherartist);
    }
    public Song(String songName, String genre, String album, String mainartist, List<String> otherartist){
        this.songName =songName;
        this.genre = genre;
        this.album = album;
        this.mainartist = mainartist;
        this.otherartist = otherartist;       
    }

    public Song(String id,String songName, String genre, String album, String mainartist, List<String> otherartist){
        this(songName,genre,album,mainartist,otherartist);
        this.id = id;
    }
    public String getAlbum() {
        return album;
    }
    public String getMainartist() {
        return mainartist;
    }
    public String getGenre() {
        return genre;
    }
    public List<String> getOtherartist() {
        return otherartist;
    }
    public String getSongName() {
        return songName;
    }
    @Override
    public String toString(){
        return id + songName + album + mainartist + otherartist;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((album == null) ? 0 : album.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((mainartist == null) ? 0 : mainartist.hashCode());
        result = prime * result + ((otherartist == null) ? 0 : otherartist.hashCode());
        result = prime * result + ((songName == null) ? 0 : songName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (album == null) {
            if (other.album != null)
                return false;
        } else if (!album.equals(other.album))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (mainartist == null) {
            if (other.mainartist != null)
                return false;
        } else if (!mainartist.equals(other.mainartist))
            return false;
        if (otherartist == null) {
            if (other.otherartist != null)
                return false;
        } else if (!otherartist.equals(other.otherartist))
            return false;
        if (songName == null) {
            if (other.songName != null)
                return false;
        } else if (!songName.equals(other.songName))
            return false;
        return true;
    }
    
}
