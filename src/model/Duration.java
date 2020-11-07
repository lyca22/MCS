package model;

public class Duration{
	
	private int hours;
	private int minutes;
	private int seconds;
	
	/**
	* Constructor method for the Duration class. <br>
	* Pre: <br>
	* Post: Creates an instance of Duration. <br>
	*/
	public Duration(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	/**
	* Returns the attribute hours. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Returns the attribute hours. <br>
	* @return hours
	*/
	public int getHours(){
		return hours;
	}
	
	/**
	* Returns the attribute minutes. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Returns the attribute minutes. <br>
	* @return minutes
	*/
	public int getMinutes(){
		return minutes;
	}
	
	/**
	* Returns the attribute seconds. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Returns the attribute seconds. <br>
	* @return seconds
	*/
	public int getSeconds(){
		return seconds;
	}
	
	/**
	* Sets the attribute hours with the given parameter. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Sets the attribute hours with the given parameter. <br>
	*/
	public void setHours(int hours){
		this.hours = hours;
	}
	
	/**
	* Sets the attribute minutes with the given parameter. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Sets the attribute minutes with the given parameter. <br>
	*/
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	/**
	* Sets the attribute seconds with the given parameter. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Sets the attribute seconds with the given parameter. <br>
	*/
	public void setSeconds(int seconds){
		this.seconds = seconds;
	}
	
	/**
	* Returns the stored duration. <br>
	* Pre: Duration has been initialized. <br>
	* Post: Returns the stored duration. <br>
	* @return msg The stored duration. It returns a String.
	*/
	public String getInfo(){
		String msg = hours + " horas, " + minutes + " minutos, " + seconds + " segundos.";
		return msg;
	}
	
}