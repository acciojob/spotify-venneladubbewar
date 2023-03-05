package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;
    public HashMap<Album, List<Song>> albumSongMap;
    public HashMap<Playlist, List<Song>> playlistSongMap;
    public HashMap<Playlist, List<User>> playlistListenerMap;
    public HashMap<User, Playlist> creatorPlaylistMap;
    public HashMap<User, List<Playlist>> userPlaylistMap;
    public HashMap<Song, List<User>> songLikeMap;

    public List<User> users;
    public List<Song> songs;
    public List<Playlist> playlists;
    public List<Album> albums;
    public List<Artist> artists;

    public SpotifyRepository(){
        //To avoid hitting apis multiple times, initialize all the hashmaps here with some dummy data
        artistAlbumMap = new HashMap<>();
        albumSongMap = new HashMap<>();
        playlistSongMap = new HashMap<>();
        playlistListenerMap = new HashMap<>();
        creatorPlaylistMap = new HashMap<>();
        userPlaylistMap = new HashMap<>();
        songLikeMap = new HashMap<>();

        users = new ArrayList<>();
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();
    }

    public User createUser(String name, String mobile) {
        User u = new User(name,mobile);
        users.add(u);
        return u;
    }

    public Artist createArtist(String name) {
        Artist a = new Artist(name);
        artists.add(a);
        artistAlbumMap.put(a,albums);
        return a;
    }

    public Album createAlbum(String title, String artistName) {

        if(!artists.contains(artistName)) {
            Artist ar = new Artist(artistName);
            artists.add(ar);
        }

        Album a = new Album(title);
        albums.add(a);
        albumSongMap.put(a,songs);
        return a;

    }

    public Song createSong(String title, String albumName, int length) throws Exception{
        if(!albums.contains(albumName)) {
            throw new Exception("Album does not exist");
        }

        Song s = new Song(title,length);
        songs.add(s);
      //  playlists.add();
     //   playlistSongMap.put(title,playlists);
         return s;
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
       // if(users.contains(mobile)) {
            Playlist p = new Playlist(title);
//            Song s = new Song(title, length);
//            songs.add(s);
//            Album a = new Album(title);
//            albumSongMap.put(a,songs);
//            playlists.add(p);
//            playlistSongMap.put(p,songs);
//     //   }
//        else {
//            throw new Exception("User does not exist");
//        }
        return p;

    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {
        Playlist p = new Playlist(title);
        return p;
    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {
      //  Playlist p = new Playlist(title);
     //   return p;
    }

    public Song likeSong(String mobile, String songTitle) throws Exception {
    //    Playlist p = new Playlist(title);
    //    return p;
    }

    public String mostPopularArtist() {
        return "";
    }

    public String mostPopularSong() {
        return "";
    }
}
