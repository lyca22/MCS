package model;

public class PlaylistCollection{
	
	private final static int MAX_PLAYLISTS = 20;
	
	private Playlist[] collection;
	
	/**
	* Constructor method for the PlaylistCollection class. <br>
	* Pre: <br>
	* Post: Creates an instance of PlaylistCollection. <br>
	*/
	public PlaylistCollection(){
		collection = new Playlist[MAX_PLAYLISTS];
	}
	
	/**
	* Returns the attribute collection. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Returns the attribute collection. <br>
	* @return collection
	*/
	public Playlist[] getCollection(){
		return collection;
	}
	
	/**
	* Creates a PRIVATE playlist and stores it in collection. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Creates a private playlist and stores it in collection. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String createPlaylist(String name, MCS mcs, String nickname){
		
		String msg = "No se pudo crear la playlist.";
		Playlist newPlaylist = new PrivatePlaylist(name, mcs, nickname);
		boolean space = false;
		
		for(int i = 0; i < MAX_PLAYLISTS && !space; i++){
			if(collection[i] == null){
				space = true;
				collection[i] = newPlaylist;
				msg = "Se creo la playlist de forma exitosa.";
			}
		}
		
		return msg;
		
	}
	
	/**
	* Creates a RESTRICTED playlist and stores it in collection. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Creates a restricted playlist and stores it in collection. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String createPlaylist(String name, int maxUsers, MCS mcs, String nickname){
		
		String msg = "No se pudo crear la playlist.";
		Playlist newPlaylist = new RestrictedPlaylist(name, maxUsers, mcs, nickname);
		boolean space = false;
		
		for(int i = 0; i < MAX_PLAYLISTS && !space; i++){
			if(collection[i] == null){
				space = true;
				collection[i] = newPlaylist;
				msg = "Se creo la playlist de forma exitosa.";
			}
		}
		
		return msg;
		
	}
	
	/**
	* Creates a PUBLIC playlist and stores it in collection. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Creates a public playlist and stores it in collection. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String createPlaylist(String name, MCS mcs, String nickname, int score){
		
		String msg = "No se pudo crear la playlist.";
		Playlist newPlaylist = new PublicPlaylist(name, mcs, nickname, score);
		boolean space = false;
		
		for(int i = 0; i < MAX_PLAYLISTS && !space; i++){
			if(collection[i] == null){
				space = true;
				collection[i] = newPlaylist;
				msg = "Se creo la playlist de forma exitosa.";
			}
		}
		
		return msg;
		
	}
	
	/**
	* Gets all the playlist's information. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Returns the playlist's information. <br>
	* @return msg The playlist's information. It returns a String.
	*/
	public String showPlaylists(){
		
		String msg = "No hay informacion que mostrar.";
		boolean end = false;
		
		for(int i = 0; i < MAX_PLAYLISTS && !end; i++){
			if((collection[i] != null) && i == 0){
				msg = "\nPlaylist " + (i+1) + ":\n" + collection[i].getInfo();
			}else if(collection[i] != null){
				msg += "\nPlaylist " + (i+1) + ":\n" + collection[i].getInfo();
			}else{
				end = true;
			}
		}
		
		return msg;
		
	}
	
	/**
	* Searchs a specific playlist in collection using the playlist's name. <br>
	* Pre: PlaylistCollection has been initialized. <br>
	* Post: Returns that playlist's instance. <br>
	* @return song Returns the playlist's instance.
	*/
	public Playlist searchPlaylist(String name){
		
		Playlist pl = null;
		boolean found = false;
		
		for(int i = 0; i < MAX_PLAYLISTS && !found; i++){
			if(collection[i] != null){
				if(collection[i].getName().equalsIgnoreCase(name)){
					found = true;
					pl = collection[i];
				}
			}else{
				found = true;
			}
		}
		
		return pl;
		
	}
	
}