package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.*;

public class Menu {

	public static final int EXIT_OPTION = 4;
	public Game game ;

	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public Menu() {

	}

	public void startMenu() throws IOException {
		String getMenu = getMenu();
		int option;
		do {
			System.out.println(getMenu);
			option = readOption();
			executeOperation(option);
		} while (option != EXIT_OPTION);
	}

	private String getMenu() {
		String m;
		m = "===============\n";
		m += "     Menu\n";
		m += "===============\n";
		m += "1. Create game\n";
		m += "2. show points\n";
		m += "3. Exit";
		return m;
	}

	private int readOption() throws IOException {
		int option;
		option = Integer.parseInt(br.readLine());
		return option;
	}

	private void executeOperation(int option) throws IOException {

		switch (option) {
		case 1:
			game();
			break;

		case 2:
			
			break;

		case 3:
			exitProgram();
			break;
		}
	}

	private void game() throws IOException {
		System.out.println("enter the nick name, n, m , k separated with a space");
		String line = br.readLine();
		String[]parts=line.split(" ");
		String nickName = parts[0];
		int n = Integer.parseInt(parts[1]);
		int m = Integer.parseInt(parts[2]);
		int k = Integer.parseInt(parts[3]);
		game = new Game(n, m, k);
		System.out.println(nickName);
		game.createMatrix();
		System.out.println(game);
		game.addMirror();
		System.out.println(game);
		System.out.println("now the idea of ​​the game is that you try to guess where the mirrors of the matrix are");
		System.out.println("to perform the shot you must indicate the position from where you want to shoot rows starting from the letter A and columns with numbers starting from 1");
		System.out.println("If you want to shoot through any of the corners of the matrix, you must indicate whether it will be vertical (v) or horizontal (h)");
		
		String shot = br.readLine();
	}
	
	private void exitProgram() throws IOException {
		br.close();
		bw.close();
	}
}
