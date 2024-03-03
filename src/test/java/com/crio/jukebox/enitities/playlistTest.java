package com.crio.jukebox.enitities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import org.junit.jupiter.api.Test;

public class playlistTest {
    @Test
    public void testGetters() {
        String playlistId = "123";
        String playlistName = "Test Playlist";
        List<String> songIds = Arrays.asList("song1", "song2", "song3");
        Playlist playlist = new Playlist(playlistId, playlistName, songIds);
        assertEquals(playlistId, playlist.getPlaylistid());
        assertEquals(playlistName, playlist.getPlaylistname());
        assertEquals(songIds, playlist.getSongid());
    }

    @Test
    public void testToString() {
        Playlist playlist = new Playlist("1", "123", "Test Playlist", Arrays.asList("song1", "song2"));
        String result = playlist.toString();
        assertEquals("1123Test Playlist[song1, song2]", result);
    }

    @Test
    public void testCopyConstructor() {
        Playlist originalPlaylist = new Playlist("1", "123", "Test Playlist", Arrays.asList("song1", "song2"));
        Playlist copiedPlaylist = new Playlist(originalPlaylist);
        assertEquals(originalPlaylist.getPlaylistid(), copiedPlaylist.getPlaylistid());
        assertEquals(originalPlaylist.getPlaylistname(), copiedPlaylist.getPlaylistname());
        assertEquals(originalPlaylist.getSongid(), copiedPlaylist.getSongid());
    }
}
