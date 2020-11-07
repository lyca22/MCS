package ui;
import java.util.Scanner;
import java.util.ArrayList;
import model.*;

public class Menu implements Interface{
	
	public Menu(){
		
	}
	
	/**
	* Creates an user with the given information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Creates an user with the given information. <br>
	*/
	public void createUser(MCS mcs, Scanner sc){
		System.out.println("Ingrese su nombre de usuario:");
		String nickname = sc.nextLine();
		System.out.println("Ingrese su password:");
		String password = sc.nextLine();
		System.out.println("Ingrese su edad:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println(mcs.createUser(nickname, password, age));
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Shows all users with their information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Shows all users with their information. <br>
	*/
	public void showUsers(MCS mcs, Scanner sc){
		System.out.println(mcs.showUsers());
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Creates a song with the given information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Creates a song with the given information. <br>
	*/
	public void createSong(MCS mcs, Scanner sc){
		System.out.println("Ingrese nombre de cancion:");
		String name = sc.nextLine();
		System.out.println("Ingrese autor:");
		String author = sc.nextLine();
		System.out.println("Ingrese dia de lanzamiento:");
		int day = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese mes de lanzamiento:");
		int month = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese year de lanzamiento:");
		int year = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese minutos de duracion:");
		int minutes = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese segundos de duracion:");
		int seconds = sc.nextInt();
		sc.nextLine();
		GenresENUM genre = GenresENUM.ROCK;
		System.out.println("Ingrese genero (ROCK, HIP_HOP, MUSICA_CLASICA, REGGAE, SALSA, METAL):");
		String text = sc.nextLine();
		switch(text){
			case "ROCK":
			genre = GenresENUM.ROCK;
			break;
			case "HIP_HOP":
			genre = GenresENUM.HIP_HOP;
			break;
			case "MUSICA_CLASICA":
			genre = GenresENUM.MUSICA_CLASICA;
			break;
			case "REGGAE":
			genre = GenresENUM.REGGAE;
			break;
			case "SALSA":
			genre = GenresENUM.SALSA;
			break;
			case "METAL":
			genre = GenresENUM.METAL;
			break;
		}
		System.out.println("Ingrese su nombre de usuario:");
		String nickname = sc.nextLine();
		System.out.println(mcs.getSongPool().createSong(name, author, day, month, year, minutes, seconds, genre, mcs.searchUser(nickname)));
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Shows all songs with their information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Shows all songs with their information. <br>
	*/
	public void showSongs(MCS mcs, Scanner sc){
		System.out.println(mcs.getSongPool().showSongs());
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Creates a playlist with the given information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Creates a playlist with the given information. <br>
	*/
	public void createPlaylist(MCS mcs, Scanner sc){
		int maxUsers = 0;
		System.out.println("Ingrese nombre de playlist:");
		String name = sc.nextLine();
		System.out.println("Ingrese nickname:");
		String nickname = sc.nextLine();
		System.out.println("Ingrese tipo de playlist:\n1.Playlist publica\n2.Playlist restringida\n3.Playlist privada");
		int type = sc.nextInt();
		sc.nextLine();
		switch(type){
			case 1:
			System.out.println(mcs.getPlaylistCollection().createPlaylist(name, mcs, nickname, 0));
			System.out.println();
			break;
			case 2:
			System.out.println("Ingrese la cantidad de usuarios maximos para la playlist:");
			maxUsers = sc.nextInt();
			sc.nextLine();
			System.out.println(mcs.getPlaylistCollection().createPlaylist(name, maxUsers, mcs, nickname));
			System.out.println();
			break;
			case 3:
			System.out.println(mcs.getPlaylistCollection().createPlaylist(name, mcs, nickname));
			System.out.println();
			break;
		}
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Adds a song to one playlist. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Adds a song to one playlist. <br>
	*/
	public void addSong(MCS mcs, Scanner sc){
		System.out.println("Ingrese nombre de playlist:");
		String name = sc.nextLine();
		System.out.println("Ingrese nombre de cancion:");
		String song = sc.nextLine();
		System.out.println(mcs.getPlaylistCollection().searchPlaylist(name).addSong(song, mcs.getSongPool()));
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Adds an user to one playlist. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Adds an user to one playlist. <br>
	*/
	public void addUser(MCS mcs, Scanner sc){
		System.out.println("Ingrese nombre de playlist:");
		String name = sc.nextLine();
		System.out.println("Ingrese nickname del usuario:");
		String nickname = sc.nextLine();
		System.out.println(mcs.getPlaylistCollection().searchPlaylist(name).addUser(mcs, nickname));
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Assigns a score to a public playlist. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Assigns a score to a public playlist. <br>
	*/
	public void assignScore(MCS mcs, Scanner sc){
		PublicPlaylist publicPL;
		int score = 0;
		System.out.println("Ingrese nombre de playlist:");
		String name = sc.nextLine();
		
		if(mcs.getPlaylistCollection().searchPlaylist(name) instanceof PublicPlaylist){
			System.out.println("Ingrese su calificacion:");
			score = sc.nextInt();
			sc.nextLine();
			publicPL = (PublicPlaylist)mcs.getPlaylistCollection().searchPlaylist(name);
			System.out.println(publicPL.assignScore(score));
			
			System.out.println("La calificacion actual es: " + publicPL.getScore() + "\n");
			
		}else{
			System.out.println("Esta playlist no es publica.");
		}
		
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
	/**
	* Shows all playlists with their information. <br>
	* Pre: MCS has been initialized. A Scanner has been initialized. <br>
	* Post: Shows all playlists with their information. <br>
	*/
	public void showPlaylists(MCS mcs, Scanner sc){
		System.out.println(mcs.getPlaylistCollection().showPlaylists());
		System.out.println("Pulse una tecla para continuar");
		sc.nextLine();
	}
	
}