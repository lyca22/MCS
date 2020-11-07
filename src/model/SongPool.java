package model;

public class SongPool{
	
	private final static int MAX_SONGS = 30;
	
	private Song[] pool;
	
	/**
	* Constructor method for the SongPool class. <br>
	* Pre: <br>
	* Post: Creates an instance of SongPool. <br>
	*/
	public SongPool(){
		pool = new Song[MAX_SONGS];
	}
	
	/**
	* Returns the attribute pool. <br>
	* Pre: SongPool has been initialized. <br>
	* Post: Returns the attribute pool. <br>
	* @return pool
	*/
	public Song[] getPool(){
		return pool;
	}
	
	/**
	* Creates a song and stores it in pool. <br>
	* Pre: SongPool has been initialized. <br>
	* Post: Creates a song and stores it in pool. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String createSong(String title, String author, int releasedDay, int releasedMonth, int releasedYear, int minutes, int seconds, GenresENUM genre, User user){
		String msg = "No se pudo crear la cancion.";
		Song newSong = new Song(title, author, releasedDay, releasedMonth, releasedYear, minutes, seconds, genre);
		boolean space = false;
		
		for(int i = 0; i < MAX_SONGS && !space; i++){
			if(pool[i] == null){
				space = true;
				pool[i] = newSong;
				user.countSong();
				user.updateCategory();
				msg = "Se ha creado la cancion de forma exitosa.";
			}
		}
		
		return msg;
		
	}
	
	/**
	* Shows all the stored songs in pool. <br>
	* Pre: SongPool has been initialized. <br>
	* Post: Shows all the stored songs in pool. <br>
	* @return msg All songs and their data. Returns a String.
	*/
	public String showSongs(){
		
		String msg = "No hay informacion que mostrar.";
		boolean end = false;
		
		for(int i = 0; i < MAX_SONGS && !end; i++){
			if((pool[i] != null) && i == 0){
				msg = "\nSong " + (i+1) + ":\n" + pool[i].getInfo();
			}else if(pool[i] != null){
				msg += "\nSong " + (i+1) + ":\n" + pool[i].getInfo();
			}else{
				end = true;
			}
		}
		
		return msg;
		
	}
	
	/**
	* Searchs a specific song in pool using the song's name. <br>
	* Pre: SongPool has been initialized. <br>
	* Post: Returns that song's instance. <br>
	* @return song Returns the song's instance.
	*/
	public Song searchSong(String name){
		
		Song song = null;
		boolean found = false;
		
		for(int i = 0; i < MAX_SONGS && !found; i++){
			if(pool[i] != null){
				if(pool[i].getTitle().equalsIgnoreCase(name)){
					found = true;
					song = pool[i];
				}
			}else{
				found = true;
			}
		}
		return song;
	}
	
}