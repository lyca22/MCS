package model;

public class Song{
	
	private String title;
	private String author;
	private Date releaseDate;
	private Duration duration;
	private GenresENUM genre;
	
	/**
	* Constructor method for the Song class. <br>
	* Pre: <br>
	* Post: Creates an instance of Song. <br>
	*/
	public Song(String title, String author, int releasedDay, int releasedMonth, int releasedYear, int minutes, int seconds, GenresENUM genre){
		this.title = title;
		this.author = author;
		releaseDate = new Date(releasedDay, releasedMonth, releasedYear);
		duration = new Duration(0, minutes, seconds);
		switch(genre){
			case ROCK:
			this.genre = GenresENUM.ROCK;
			break;
			case HIP_HOP:
			this.genre = GenresENUM.HIP_HOP;
			break;
			case MUSICA_CLASICA:
			this.genre = GenresENUM.MUSICA_CLASICA;
			break;
			case REGGAE:
			this.genre = GenresENUM.REGGAE;
			break;
			case SALSA:
			this.genre = GenresENUM.SALSA;
			break;
			case METAL:
			this.genre = GenresENUM.METAL;
			break;
		}
	}
	
	/**
	* Returns the attribute title. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns the attribute title. <br>
	* @return title
	*/
	public String getTitle(){
		return title;
	}
	
	/**
	* Returns the attribute author. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns the attribute author. <br>
	* @return author
	*/
	public String getAuthor(){
		return author;
	}
	
	/**
	* Returns the attribute releaseDate. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns the attribute releaseDate. <br>
	* @return releaseDate
	*/
	public Date getReleaseDate(){
		return releaseDate;
	}
	
	/**
	* Returns the attribute duration. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns the attribute duration. <br>
	* @return duration
	*/
	public Duration getDuration(){
		return duration;
	}
	
	/**
	* Returns the attribute genre. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns the attribute genre. <br>
	* @return genre
	*/
	public GenresENUM getGenre(){
		return genre;
	}
	
	/**
	* Gets all the song's information. <br>
	* Pre: Song has been initialized. <br>
	* Post: Returns all the song's information. <br>
	* @return msg The song's information. It returns a String.
	*/
	public String getInfo(){
		String msg = "\nTitulo: " + title;
		msg += "\nAutor: " + author;
		msg += "\nFecha de lanzamiento: " + releaseDate.getInfo();
		msg += "\nDuracion: " + duration.getInfo();
		msg += "\nGenero: " + genre + "\n";
		return msg;
	}
	
}