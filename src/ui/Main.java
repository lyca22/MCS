package ui;
import java.util.Scanner;
import model.*;

public class Main{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		MCS mcs = new MCS();
		Menu m = new Menu();
		boolean end = false;
		while (!end){
		end = Main.showMenu(end, mcs, m, sc);
		}
	}
	
	/**
	* Displays a menu with which the user can interact. <br>
	* Pre: MCS has been initialized. A Menu has been initialized. A Scanner has been initialized. <br>
	* Post: Displays a menu with which the user can interact. <br>
	*/
	public static boolean showMenu(boolean end, MCS mcs, Menu m, Scanner sc){
		System.out.println("\n1.Crear usuario\n2.Mostrar usuarios\n3.Crear cancion\n4.Mostrar canciones\n5.Crear playlist\n6.Agregar cancion a una playlist\n7.Agregar usuario a una playlist\n8.Calificar playlist publica\n9.Mostrar playlists\n10.Salir\n\nIngrese un numero de acuerdo con lo que quiera hacer");
		int option = sc.nextInt();
		sc.nextLine();
		switch(option){
			case 1:
			m.createUser(mcs, sc);
			break;
			case 2:
			m.showUsers(mcs, sc);
			break;
			case 3:
			m.createSong(mcs, sc);
			break;
			case 4:
			m.showSongs(mcs, sc);
			break;
			case 5:
			m.createPlaylist(mcs, sc);
			break;
			case 6:
			m.addSong(mcs, sc);
			break;
			case 7:
			m.addUser(mcs, sc);
			break;
			case 8:
			m.assignScore(mcs, sc);
			break;
			case 9:
			m.showPlaylists(mcs, sc);
			break;
			case 10:
			end = true;
			System.out.println("\nUsted ha salido de la aplicacion.\n");
			break;
		}
		return end;
	}
}