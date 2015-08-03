import java.io.IOException;
import java.util.Scanner;

public class minesweeperMain {
	public static void displayswitch() {

		System.out.println("Choose your Game Type");
		System.out
				.println("Press 1 for playing Minesweeper game with 08 rows, 08 columns and 10 mines");
		System.out
				.println("Press 2 for playing Minesweeper game with 16 rows, 16 columns and 40 mines");
		System.out
				.println("Press 3 for playing Minesweeper game with 30 rows, 16 columns and 99 mines");
		System.out
				.println("Press 4 for playing Minesweeper game Customized rows, columns and mines");

	}

	public static void displayHeader() {
		System.out
				.println("\t------------------------------------------------- \t\t");
		System.out
				.println("\tWelcome to the Minesweeper Command Prompt Version \t\t");
		System.out
				.println("\t------------------------------------------------- \t\t");
	}

	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(System.in);

		char wantoplay = 'y';
		while (wantoplay == 'y' || wantoplay == 'Y') {
			displayHeader();
			displayswitch();
			minesweeperGame g = null;

			int choice = s.nextInt();
			switch (choice) {
			case 1:
				g = new minesweeperGame(8, 8, 10);
				break;
			case 2:
				g = new minesweeperGame(16, 16, 40);

				break;
			case 3:
				g = new minesweeperGame(30, 16, 99);

				break;
			case 4:
				g = new minesweeperGame(s.nextInt(), s.nextInt(), s.nextInt());
				break;

			}

			g.displayGame();
			System.out.printf("The chances are %d",g.chances);
			System.out.println();
			int rvalue=g.open();
			while (rvalue != -1 || g.chances>1) {
				if(rvalue==-1)
				g.chances--;
				g.displayGame();
				rvalue=g.open();
			}
			g.destroy();

		}
		System.out.println("DO YOU WANT TO PLAY AGAIN??? :) \t Y or N ?");
		wantoplay = (char) System.in.read();
		
	}
}

