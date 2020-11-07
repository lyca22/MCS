package model;

public class User{
	
	private String nickname;
	private String password;
	private int age;
	private CategoryENUM category;
	private int publishedSongs;
	
	/**
	* Constructor method for the User class. <br>
	* Pre: <br>
	* Post: Creates an instance of User. <br>
	*/
	public User(String nickname, String password, int age){
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		category = CategoryENUM.Newbie;
		publishedSongs = 0;
	}
	
	/**
	* Returns the attribute nickname. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the attribute nickname. <br>
	* @return nickname
	*/
	public String getNickname(){
		return nickname;
	}
	
	/**
	* Returns the attribute password. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the attribute password. <br>
	* @return password
	*/
	public String getPassword(){
		return password;
	}
	
	/**
	* Returns the attribute age. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the attribute age. <br>
	* @return age
	*/
	public int getAge(){
		return age;
	}
	
	/**
	* Returns the attribute category. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the attribute category. <br>
	* @return category
	*/
	public CategoryENUM getCategory(){
		return category;
	}
	
	/**
	* Returns the attribute publishedSongs. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the attribute publishedSongs. <br>
	* @return publishedSongs
	*/
	public int getPublishedSongs(){
		return publishedSongs;
	}
	
	/**
	* Gets all the user's information. <br>
	* Pre: User has been initialized. <br>
	* Post: Returns the user's information. <br>
	* @return msg The user's information. It returns a String.
	*/
	public String getInfo(){
		String msg = "\nNombre de usuario: " + nickname;
		msg += "\nEdad: " + age;
		msg += "\nCategoria: " + category + "\n";
		return msg;
	}
	
	/**
	* Adds one unit to the song counter. <br>
	* Pre: User has been initialized. <br>
	* Post: Adds one unit to the song counter. <br>
	*/
	public void countSong(){
		publishedSongs++;
	}
	
	/**
	* Updates the user's category depending on the song counter. <br>
	* Pre: User has been initialized. <br>
	* Post: Updates the user's category depending on the song counter. <br>
	*/
	public void updateCategory(){
		if(publishedSongs >= 30){
			category = CategoryENUM.StarContributor;
		}else if(publishedSongs >= 10){
			category = CategoryENUM.MildContributor;
		}else if(publishedSongs >= 3){
			category = CategoryENUM.LittleContributor;
		}
	}
	
}