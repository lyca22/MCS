package model;

public class Date{
	
	private int day;
	private int month;
	private int year;
	
	/**
	* Constructor method for the Date class. <br>
	* Pre: <br>
	* Post: Creates an instance of Date. <br>
	*/
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	* Returns the attribute day. <br>
	* Pre: Date has been initialized. <br>
	* Post: Returns the attribute day. <br>
	* @return day
	*/
	public int getDay(){
		return day;
	}
	
	/**
	* Returns the attribute month. <br>
	* Pre: Date has been initialized. <br>
	* Post: Returns the attribute month. <br>
	* @return month
	*/
	public int getMonth(){
		return month;
	}
	
	/**
	* Returns the attribute year. <br>
	* Pre: Date has been initialized. <br>
	* Post: Returns the attribute year. <br>
	* @return year
	*/
	public int getYear(){
		return year;
	}
	
	/**
	* Returns the stored date. <br>
	* Pre: Date has been initialized. <br>
	* Post: Returns the stored date. <br>
	* @return msg The stored date. It returns a String.
	*/
	public String getInfo(){
		String msg = day + "/" + month + "/" + year;
		return msg;
	}
	
}