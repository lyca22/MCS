package model;

public class PrivatePlaylist extends Playlist{
	
	private User user;
	
	/**
	* Constructor method for the PrivatePlaylist class. <br>
	* Pre: <br>
	* Post: Creates an instance of PrivatePlaylist. <br>
	*/
	public PrivatePlaylist(String name, MCS mcs, String nickname){
		super(name);
		user = mcs.searchUser(nickname);
	}
	
	/**
	* Returns the attribute user. <br>
	* Pre: PrivatePlaylist has been initialized. <br>
	* Post: Returns the attribute user. <br>
	* @return user
	*/
	public User getUser(){
		return user;
	}
	
	/**
	* Informs the user that you can't add an user. <br>
	* Pre: Playlist has been initialized. <br>
	* Post: Informs the user that you can't add an user. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String addUser(MCS mcs, String nickname){
		String msg = "No se pudo agregar el usuario.";
		return msg;
	}
	
}