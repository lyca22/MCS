package model;

public class PublicPlaylist extends Playlist{
	
	private final static int MAX_USERS = 10;
	
	private User[] userList;
	private double score;
	
	/**
	* Constructor method for the PublicPlaylist class. <br>
	* Pre: <br>
	* Post: Creates an instance of PublicPlaylist. <br>
	*/
	public PublicPlaylist(String name, MCS mcs, String nickname, int score){
		super(name);
		userList = new User[MAX_USERS];
		userList[0] = mcs.searchUser(nickname);
		this.score = score;
	}
	
	/**
	* Returns the attribute userList. <br>
	* Pre: PublicPlaylist has been initialized. <br>
	* Post: Returns the attribute userList. <br>
	* @return userList
	*/
	public User[] getUserList(){
		return userList;
	}
	
	/**
	* Returns the attribute score. <br>
	* Pre: PublicPlaylist has been initialized. <br>
	* Post: Returns the attribute score. <br>
	* @return score
	*/
	public double getScore(){
		return score;
	}
	
	/**
	* Adds an user, storing it in the userList. <br>
	* Pre: PublicPlaylist has been initialized. <br>
	* Post: Adds an user, storing it in the userList. <br>
	* @return msg A message for the user. Returns a String.
	*/
	public String addUser(MCS mcs, String nickname){
		String msg = "No se pudo agregar el usuario.";
		User us = mcs.searchUser(nickname);
		boolean space = false;
		
		for(int i = 0; i < MAX_USERS && !space; i++){
			if(userList[i] == null){
				space = true;
				userList[i] = us;
				msg = "Se agrego al usuario de forma exitosa.";
			}
		}
		
		return msg;
	}
	/**
	* Assigns a score to the public playlist. <br>
	* Pre: PublicPlaylist has been initialized. <br>
	* Post: Assigns a score to the public playlist. <br>
	* @return msg A message for the user which says the score. Returns a String.
	*/
	public String assignScore(int score){
		String msg = "Se ha agregado su calificacion.";
		if(this.score == 0){
			this.score = score;
		}else{
			this.score += score;
			this.score = (this.score/2);
		}
		return msg;
	}
	
}