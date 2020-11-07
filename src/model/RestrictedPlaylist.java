package model;

public class RestrictedPlaylist extends Playlist{
	
	private int maxUsers;
	private User[] userList;
	
	/**
	* Constructor method for the RestrictedPlaylist class. <br>
	* Pre: <br>
	* Post: Creates an instance of RestrictedPlaylist. <br>
	*/
	public RestrictedPlaylist(String name, int maxUsers, MCS mcs, String nickname){
		super(name);
		this.maxUsers = maxUsers;
		userList = new User[maxUsers];
		userList[0] = mcs.searchUser(nickname);
	}
	
	/**
	* Returns the attribute maxUsers. <br>
	* Pre: RestrictedPlaylist has been initialized. <br>
	* Post: Returns the attribute maxUsers. <br>
	* @return maxUsers
	*/
	public int getMaxUsers(){
		return maxUsers;
	}
	
	/**
	* Returns the attribute userList. <br>
	* Pre: RestrictedPlaylist has been initialized. <br>
	* Post: Returns the attribute userList. <br>
	* @return userList
	*/
	public User[] getUserList(){
		return userList;
	}
	
	/**
	* Adds an user, storing it in the userList. <br>
	* Pre: RestrictedPlaylist has been initialized. <br>
	* Post: Adds an user, storing it in the userList. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String addUser(MCS mcs, String nickname){
		String msg = "No se pudo agregar el usuario.";
		User us = mcs.searchUser(nickname);
		boolean space = false;
		
		for(int i = 0; i < maxUsers && !space; i++){
			if(userList[i] == null){
				space = true;
				userList[i] = us;
				msg = "Se agrego al usuario de forma exitosa.";
			}
		}
		
		return msg;
	}
	
}