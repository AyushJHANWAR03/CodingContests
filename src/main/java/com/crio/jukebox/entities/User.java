package com.crio.jukebox.entities;

import java.util.List;

public class User extends BaseEntity{
    private final String username;
    private final List<Playlist> playlistid;
        
    public User(User user){
        this(user.id, user.username, user.playlistid);
    }
    public User(String id, String username, List<Playlist> playlistid){
        this(username, playlistid);
        this.id = id;
    }

    public User(String Username, List<Playlist> playlistid){
        this.username = Username;
        this.playlistid = playlistid;
    }
   
    public String getUsername() {
        return username;
    }

    public List<Playlist> getPlaylistid() {
        return playlistid;
    }
    
    @Override
    public String toString() {
        return  playlistid  + username;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((playlistid == null) ? 0 : playlistid.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        User other = (User) obj;
        if (playlistid == null) {
            if (other.playlistid != null)
                return false;
        } else if (!playlistid.equals(other.playlistid))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
    
}
