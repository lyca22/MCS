package model;

public class MCS{
	
	private final static int MAX_USERS = 10;
	
	private SongPool songPool;
	private User[] userList;
	private PlaylistCollection playlistCollection;
	
	/**
	* Constructor method for MCS. <br>
	* Pre: <br>
	* Post: Creates an instace of the MCS class. <br>
	*/
	public MCS(){
		
		this.songPool = new SongPool();
		userList = new User[MAX_USERS];
		this.playlistCollection = new PlaylistCollection();
		
	}
	
	/**
	* Returns the attribute songPool. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Returns the attribute songPool. <br>
	* @return songPool
	*/
	public SongPool getSongPool(){
		return songPool;
	}
	
	/**
	* Returns the attribute userList. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Returns the attribute userList. <br>
	* @return userList
	*/
	public User[] getUserList(){
		return userList;
	}
	
	/**
	* Returns the attribute playlistCollection. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Returns the attribute playlistCollection. <br>
	* @return playlistCollection
	*/
	public PlaylistCollection getPlaylistCollection(){
		return playlistCollection;
	}
	
	/**
	* Creates an user and stores it in userList. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Creates an user and stores it in userList. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String createUser(String nickname, String password, int age){
		
		String msg = "No se pudo crear el usuario.";
		User newUser = new User(nickname, password, age);
		boolean space = false;
		
		for(int i = 0; i < MAX_USERS && !space; i++){
			if(userList[i] == null){
				space = true;
				userList[i] = newUser;
				msg = "Se creo el usuario de forma exitosa.";
			}
		}
		
		return msg;
		
	}
	
	/**
	* Shows all the registered users and their data. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Returns a String with all users and their data. <br>
	* @return msg All the user's daya. Returns a String.
	*/
	public String showUsers(){
		
		String msg = "No hay informacion que mostrar.";
		boolean end = false;
		
		for(int i = 0; i < MAX_USERS && !end; i++){
			if((userList[i] != null) && i == 0){
				msg = "\nUser " + (i+1) + ":\n" + userList[i].getInfo();
			}else if(userList[i] != null){
				msg += "\nUser " + (i+1) + ":\n" + userList[i].getInfo();
			}else{
				end = true;
			}
		}
		
		return msg;
		
	}
	
	/**
	* Searchs a specific user in userList using their nickname. <br>
	* Pre: MCS has been initialized. <br>
	* Post: Returns that user's instance. <br>
	* @return us Returns the user's instance.
	*/
	public User searchUser(String nickname){
		
		User us = null;
		boolean found = false;
		
		for(int i = 0; i < MAX_USERS && !found; i++){
			if(userList[i] != null){
				if(userList[i].getNickname().equalsIgnoreCase(nickname)){
					found = true;
					us = userList[i];
				}
			}else{
				found = true;
			}
		}
		
		return us;
		
	}
	
}