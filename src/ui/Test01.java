package ui;
import model.*;

public class Test01{
	public static void main(String[] args){
		
		MCS mcs = new MCS();
		mcs.createUser("Lyca", "genericpass", 18);
		mcs.createUser("Acyl", "notapassword", 20);
		
		mcs.getSongPool().createSong("Broken Horse", "Freelance Whales", 29, 12, 2009, 4, 40, GenresENUM.ROCK, mcs.searchUser("Lyca"));
		for(int i = 0; i < 30; i++){
			mcs.getSongPool().createSong("Whatever this song is", "Whatever this author is", 01, 01, 2020, 4, 0, GenresENUM.SALSA, mcs.searchUser("Lyca"));
		}
		System.out.println(mcs.getSongPool().showSongs());
		
		System.out.println(mcs.showUsers());
		
		System.out.println(mcs.getPlaylistCollection().createPlaylist("Musica para estudiar", mcs, "Lyca"));
		System.out.println(mcs.getPlaylistCollection().createPlaylist("Musica para no estudiar", 5, mcs, "Acyl"));
		System.out.println(mcs.getPlaylistCollection().createPlaylist("Es decir, pa' bailar", mcs, "Lyca", 0));
		System.out.println(mcs.getPlaylistCollection().searchPlaylist("Musica para estudiar").addSong("Broken Horse", mcs.getSongPool()));
		System.out.println(mcs.getPlaylistCollection().searchPlaylist("Musica para estudiar").addSong("Whatever this song is", mcs.getSongPool()));
		System.out.println(mcs.getPlaylistCollection().searchPlaylist("Musica para no estudiar").addSong("Broken Horse", mcs.getSongPool()));
		System.out.println(mcs.getPlaylistCollection().searchPlaylist("Es decir, pa' bailar").addSong("Whatever this song is", mcs.getSongPool()));
		System.out.println(mcs.getPlaylistCollection().showPlaylists());
	}
}