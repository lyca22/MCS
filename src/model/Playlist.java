package model;

public abstract class Playlist{
	
	private final static int MAX_SONGS = 30;
	private final static int GENRES_AMOUNT = 6;
	
	private String name;
	private Duration duration;
	private GenresENUM[] genres;
	private Song[] songs;
	
	/**
	* Constructor method for the Playlist class. <br>
	* Pre: <br>
	* Post: Creates an instance of Playlist. <br>
	*/
	public Playlist(String name){
		this.name = name;
		duration = new Duration(0, 0, 0);
		genres = new GenresENUM[GENRES_AMOUNT];
		songs = new Song[MAX_SONGS];
	}
	
	/**
	* Returns the attribute name. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Returns the attribute name. <br>
	* @return name
	*/
	public String getName(){
		return name;
	}
	
	/**
	* Returns the attribute duration. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Returns the attribute duration. <br>
	* @return duration
	*/
	public Duration getDuration(){
		return duration;
	}
	
	/**
	* Returns the attribute genres. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Returns the attribute genres. <br>
	* @return genres
	*/
	public GenresENUM[] getGenres(){
		return genres;
	}
	
	/**
	* Returns the attribute songs. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Returns the attribute songs. <br>
	* @return songs
	*/
	public Song[] getSongs(){
		return songs;
	}
	
	/**
	* Adds a song, storing it in the playlist. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Adds a song, storing it in the playlist. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String addSong(String name, SongPool sp){
		
		String msg = "No se pudo agregar la cancion a la playlist.";
		boolean end = false;
		
		if(sp.searchSong(name) != null){
			for(int i = 0; i < MAX_SONGS && !end; i++){
				if(songs[i] == null){
					end = true;
					songs[i] = sp.searchSong(name);
					
					boolean update = false;
					for(int j = 0; j < GENRES_AMOUNT && !update; j++){
						if(genres[j] == null){
							update = true;
							genres[j] = songs[i].getGenre();
						}else{
							if(songs[i].getGenre() == genres[i]){
								update = true;
							}
						}
					}
					double finalMinutes = duration.getMinutes() + songs[i].getDuration().getMinutes();
					double finalHours = duration.getHours();
					if(finalMinutes > 60){
						finalHours = finalHours + (finalMinutes/60)-(finalMinutes%60/60);
						finalMinutes = finalMinutes%60;
					}
					
					double finalSeconds = duration.getSeconds() + songs[i].getDuration().getSeconds();
					if(finalSeconds > 60){
						finalMinutes = finalMinutes + (finalSeconds/60)-(finalSeconds%60/60);
						finalSeconds = finalSeconds%60;
					}
					duration.setHours((int)finalHours);
					duration.setMinutes((int)finalMinutes);
					duration.setSeconds((int)finalSeconds);
					msg = "Se agrego la cancion a la playlist.";
				}
			}
		}
		return msg;
	}
	
	/**
	* Shows all the stored songs in the playlist. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Shows all the stored songs in playlist. <br>
	* @return msg All songs. Returns a String.
	*/
	public String showPlaylistSongs(){
		
		String msg = "No hay informacion que mostrar.";
		boolean end = false;
		
		for(int i = 0; i < MAX_SONGS && !end; i++){
			if((songs[i] != null) && i == 0){
				msg = "\n-" + songs[i].getTitle();
			}else if(songs[i] != null){
				msg += "\n-"+ songs[i].getTitle();
			}else{
				end = true;
			}
		}
		
		return msg;
		
	}
	
	/**
	* Shows all the songs' genres in the playlist. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Shows all the songs' genres in the playlist. <br>
	* @return msg All genres. Returns a String.
	*/
	public String showPlaylistGenres(){
		
		String msg = "No hay informacion que mostrar.";
		boolean end = false;
		
		for(int i = 0; i < GENRES_AMOUNT && !end; i++){
			if((genres[i] != null) && i == 0){
				msg = "|" + genres[i] + "|";
			}else if(genres[i] != null){
				msg += "|" + genres[i] + "|";
			}else{
				end = true;
			}
		}
		
		return msg;
		
	}
	
	/**
	* Gets all the playlist's information. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Returns all the playlist's information. <br>
	* @return msg The playlist's information. It returns a String.
	*/
	public String getInfo(){
		String msg = "\nNombre de la playlist: " + name;
		msg += "\nDuracion: " + duration.getInfo();
		msg += "\nGeneros: " + showPlaylistGenres();
		msg += "\nCanciones: " + showPlaylistSongs() + "\n";
		return msg;
	}
	
	public abstract String addUser(MCS mcs, String nickname);
	
}