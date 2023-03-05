package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;  //
    public HashMap<Album, List<Song>> albumSongMap;    //
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

        users = new ArrayList<>();   //
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();    //
    }

    public User createUser(String name, String mobile) {
        User u = new User(name,mobile);
        users.add(u);
        return u;
    }

    public Artist createArtist(String name) {
        Artist a = new Artist(name);
        artists.add(a);
        artistAlbumMap.put(a,new ArrayList<Album>());
        return a;
    }

    public Album createAlbum(String title, String artistName) {
        Album aa = new Album(title);
        albums.add(aa);
        List<Album> al = new ArrayList<>();
        al.add(aa);

        if(!artists.contains(artistName)) {
            Artist a= new Artist(artistName);
            artists.add(a);
            artistAlbumMap.put(a,al);
        } else artistAlbumMap.get(artistName).add(aa);
        albums.add(aa);
       return aa;



//        albumSongMap.put(a,new ArrayList<Song>());
//        return a;

    }

    public Song createSong(String title, String albumName, int length) throws Exception {
        Song song = new Song(title, length);
        songs.add(song);
        List<Song> al = new ArrayList<>();
        al.add(song);
        int f = 0;
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getTitle() == albumName) {
                albumSongMap.put(albums.get(i), al);
                f++;
            }
        }
        if (f == 0) {
            Album a = new Album(albumName);
            albumSongMap.put(a, al);
            throw new Exception("Album does not exist");
        }
            return song;


    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
       // if(users.contains(mobile)) {
            Playlist p = new Playlist(title);
            List<Song> s = new ArrayList<>();
              for(int i=0; i<songs.size(); i++) {
                if(songs.get(i).getLength()== length) {
               //     Song s = new Song(i);
               //       playlistSongMap.put(p,);
                }
            }
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
        playlists.add(p);
      //  playlistSongMap.put(p,);
        return p;
    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {
      //  Playlist p = new Playlist(title);
        return findPlaylist(mobile,playlistTitle);
    }

    public Song likeSong(String mobile, String songTitle) throws Exception {
     //    Playlist p = new Playlist(title);
    //    return p;
       return likeSong(mobile,songTitle);
    }

    public String mostPopularArtist() {
        int ans = 0;
      //  for(int x : artistAlbumMap) {
       //    ans = Math.max(ans,Playlist.getLikes());
     //   }
        return "";
    }

    public String mostPopularSong() {
        int max =0;
       // for(int i=0; i<songLikeMap.size(); i++)  {
   //     for(String i = songLikeMap) {
   //        max= Math.max(songLikeMap.get(i),max);
   //        return  songLikeMap.get(max);
   //     }

        return "";
    }
}
