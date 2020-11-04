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
		m += "    Menu\n";
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
		System.out.println("enter the nick name");
		String nickName = br.readLine();
		System.out.println("enter n size matrix");
		int n = Integer.parseInt(br.readLine());
		System.out.println("enter m size matrix");
		int m = Integer.parseInt(br.readLine());
		System.out.println("enter k mirrors");
		int k = Integer.parseInt(br.readLine());
		game = new Game(n, m, k);
		System.out.println(nickName);
		System.out.println(game);
		game.addMirror();
	}
	private void exitProgram() throws IOException {
		br.close();
		bw.close();
	}
}
