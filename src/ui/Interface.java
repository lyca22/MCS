package ui;
import java.util.Scanner;
import model.*;

public interface Interface{
	
	public void createUser(MCS mcs, Scanner sc);
	
	public void showUsers(MCS mcs, Scanner sc);
	
	public void createSong(MCS mcs, Scanner sc);
	
	public void showSongs(MCS mcs, Scanner sc);
	
	public void createPlaylist(MCS mcs, Scanner sc);
	
	public void addSong(MCS mcs, Scanner sc);
	
	public void addUser(MCS mcs, Scanner sc);
	
	public void assignScore(MCS mcs, Scanner sc);
	
	public void showPlaylists(MCS mcs, Scanner sc);
	
}