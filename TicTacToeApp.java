package tictactoe;

import java.util.*;

public class TicTacToeApp {
	// local variables
	Scanner in;
	private char[][] loc;
	private String gameState;
	private int numOfPlays;
	private final int n = 3;
	char player;
	
	// constructor
	public TicTacToeApp() {
		in = new Scanner(System.in);
		loc = new char[n][n];
		System.out.println("Welcome to Tic Tac Toe!");
		boolean play = true;
		while (play) {
			gameState = "continue";
			numOfPlays = 0;
			initializeBoard();
			player = 'x';
			while (gameState.equals("continue")) {
				playTurn();
				printGrid();
				checkState();
				player = (player == 'x') ? 'o' : 'x';
			}
			play = playAgain();
		}
		in.close();
	}
	
	private void playTurn() {
		System.out.println("Player " + player + " turn.");
		boolean badInput = true;
		int x = -1, y = -1;
		while (badInput) {
			// read in x and y coordinates
			System.out.println("Enter in 0-based x integer coordinates.");
			validateInteger();
			x = in.nextInt();
			System.out.println("Enter in 0-based y integer coordinates.");
			validateInteger();
			y = in.nextInt();
		
			// check if coordinates valid
			if (x < 0 || x >= n || y < 0 || y >= n) {
				System.out.println("Invalid location input.");
			}
			else if (loc[x][y] != ' ') {
				System.out.println("This location is already taken. Enter a location that is open.");
			}
			else badInput = false;
		}
		// valid input
		loc[x][y] = player;
		numOfPlays++;
	}
	
	private void validateInteger() {
		while (!in.hasNextInt()) {
			String input = in.next();
			System.out.println(input + " is not a valid integer.");
		}
	}
	
	private void checkState() {
		// check if the player wins the game
		// check 3 rows, 3 columns, & 2 diagonals
		if ((player == loc[0][0] && loc[0][0] == loc[0][1] && loc[0][1] == loc[0][2]) ||
			(player == loc[1][0] && loc[1][0] == loc[1][1] && loc[1][1] == loc[1][2]) ||
			(player == loc[2][0] && loc[2][0] == loc[2][1] && loc[2][1] == loc[2][2]) ||
			(player == loc[0][0] && loc[0][0] == loc[1][0] && loc[1][0] == loc[2][0]) ||
			(player == loc[0][1] && loc[0][1] == loc[1][1] && loc[1][1] == loc[2][1]) ||
			(player == loc[0][2] && loc[0][2] == loc[1][2] && loc[1][2] == loc[2][2]) ||
			(player == loc[0][0] && loc[0][0] == loc[1][1] && loc[1][1] == loc[2][2]) ||
			(player == loc[0][2] && loc[0][2] == loc[1][1] && loc[1][1] == loc[2][0])) {
			gameState = "\n****************************\n" + 
			            "  Player " + player + 
			            " won!\n****************************\n";
			System.out.println(gameState);
		}
		// check if there is a tie
		else if (numOfPlays == n*n) {
			gameState = "It's a tie!";
			System.out.println(gameState);
		}
	}
	
	private void initializeBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				loc[i][j] = ' ';
			}
		}
	}
	
	private void printGrid() {
		for (int i = 0; i < n; i++) {
			String line = "";
			for (int j = 0; j < n; j++) {
				line += loc[i][j];
				if (j != n-1) line += " | ";
			}
			System.out.println(line);
			System.out.println("---------");
		}
	}
	
	private boolean playAgain() {
		System.out.println("Want to play again?");
		String response = "";
		do {
			response = in.nextLine();
			if (response.toLowerCase().equals("n")) {
				System.out.println("Exiting game.");
				return false;
			}
			else if (response.toLowerCase().equals("y")) {
				System.out.println("Starting a new game.");
				return true;
			}
			System.out.println("Enter 'Y' for yes or 'N' for no:");
		} while (!response.toLowerCase().equals("y") || !response.toLowerCase().equals("n"));
		return false;
	}

	public static void main(String[] args) {
		new TicTacToeApp();
	}

}
