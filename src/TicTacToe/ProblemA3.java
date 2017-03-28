package TicTacToe;
import java.util.Scanner;

public class ProblemA3 {

	public static void printBoard(char board[][]) {
		System.out.println("   Column ");
		System.out.println("____1_2_3_");
		for (int i = 0, o = 1; i < 3; i++, o++) {
			char[] row = { 'R', 'o', 'w' };
			System.out.print(row[i] + " ");
			System.out.print(o);
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static void resetBoard(char board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
	}

	public static void placeMark(char[][] board, int i, int j, char playerMark) {
		Scanner scan = new Scanner(System.in);
		if (i >= 0 && i < 3) {
			if (j >= 0 && j < 3) {
				if (board[i][j] == '_') {
					board[i][j] = playerMark;
				} else if (board[i][j] != '_') {
					System.out.println("ERROR!! you can't place mark in same locaion.");
					System.out.print(" '" + playerMark + "' " + " place mark at column : ");
					j = scan.nextInt() - 1;
					if (j < 0 || j >= 3) {
						while (j < 0 || j >= 3) {
							System.out.println("ERROR!! you can't place mark out of bound table.");
							System.out.print(" '" + playerMark + "' " + " place mark at column : ");
							j = scan.nextInt() - 1;
						}
					}
					System.out.print("  row : ");
					i = scan.nextInt() - 1;
					if (i < 0 || i >= 3) {
						while (i < 0 || i >= 3) {
							System.out.println("ERROR!! you can't place mark out of bound table.");
							System.out.print("  row : ");
							i = scan.nextInt() - 1;
						}
					}
					placeMark(board, i, j, playerMark);
				}
			}
		}
	}

	public static void placeMarkBot(char[][] board, int ib, int jb, char playerMark) {
		if (ib >= 0 && ib < 3) {
			if (jb >= 0 && jb < 3) {
				if (board[ib][jb] == '_') {
					board[ib][jb] = playerMark;
				} else if (board[ib][jb] != '_') {
					ib = (int) (3 * Math.random());
					jb = (int) (3 * Math.random());
					placeMarkBot(board, ib, jb, playerMark);
				}
			}
		}
	}

	public static boolean checkRowWin(char board[][]) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != '_' && board[i][1] == board[i][0] && board[i][2] == board[i][1]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColumnWin(char board[][]) {
		for (int j = 0; j < 3; j++) {
			if (board[0][j] != '_' && board[1][j] == board[0][j] && board[2][j] == board[1][j]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkDiagonalWin(char board[][]) {
		if (board[0][0] != '_' && board[1][1] == board[0][0] && board[2][2] == board[1][1]) {
			return true;
		} else if (board[2][0] != '_' && board[1][1] == board[2][0] && board[0][2] == board[1][1]) {
			return true;
		}
		return false;
	}

	public static boolean boardFull(char board[][]) {
		boolean boardFull = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '_') {
					boardFull = false;
				}
			}
		}
		return boardFull;
	}

	public static void pvpGame(int mode) {
		Scanner scan = new Scanner(System.in);
		char[][] board = new char[3][3];
		int turn = 1;
		String[] player = new String[2];
		int[] playerTurn = new int[2];
		System.out.print("Player1 Name : ");
		player[0] = scan.next();
		System.out.print("Player2 Name : ");
		player[1] = scan.next();
		int randomMark = (int) (2 * Math.random());
		if (randomMark == 1) {
			playerTurn[0] = turn;
			System.out.println("Player1 " + player[0] + " is 'X' and your turn first.");
		} else {
			playerTurn[1] = turn;
			System.out.println("Player2 " + player[1] + " is 'X' and your turn first.");
		}
		resetBoard(board);
		char playerMark = 'X';
		do {
			printBoard(board);
			System.out.print(" '" + playerMark + "' " + " place mark at column : ");
			int j = scan.nextInt() - 1;
			if (j < 0 || j >= 3) {
				while (j < 0 || j >= 3) {
					System.out.println("ERROR!! you can't place mark out of bound table.");
					System.out.print(" '" + playerMark + "' " + " place mark at row : ");
					j = scan.nextInt() - 1;
				}
			}
			System.out.print("  row : ");
			int i = scan.nextInt() - 1;
			if (i < 0 || i >= 3) {
				while (i < 0 || i >= 3) {
					System.out.println("ERROR!! you can't place mark out of bound table.");
					System.out.print("  row : ");
					i = scan.nextInt() - 1;
				}
			}
			placeMark(board, i, j, playerMark);
			System.out.println();
			System.out.println();
			if (checkDiagonalWin(board) == true || checkColumnWin(board) == true || checkRowWin(board) == true) {
				System.out.println();
				System.out.println();
				printBoard(board);
				if (playerMark == 'X' || playerMark != 'O') {
					System.out.println(" 'X' is Winner!!");
				} else {
					System.out.println(" 'O' is Winner!!");
				}

				break;
			} else if (boardFull(board)) {
				printBoard(board);
				System.out.println(" !!Draw!!");
				break;
			}
			turn++;
			if (turn % 2 == 0) { // change player turn
				playerMark = 'O';
			} else {
				playerMark = 'X';
			}
		} while (boardFull(board) != true || checkDiagonalWin(board) != true || checkColumnWin(board) != true
				|| checkRowWin(board) != true);
	}

	public static void pvcGame(int mode) {
		Scanner scan = new Scanner(System.in);
		char[][] board = new char[3][3];
		int turn = 1;
		String[] player = new String[2];
		int[] playerTurn = new int[2];
		System.out.print("Player Name : ");
		player[0] = scan.next();
		player[1] = "Computer";
		int randomMark = (int) (2 * Math.random());
		if (randomMark == 1) {
			playerTurn[0] = turn;
			System.out.println("Player " + player[0] + " is 'X' and your turn first.");
		} else {
			playerTurn[1] = turn;
			System.out.println(player[1] + " is 'X' and get turn first.");
		}
		resetBoard(board);
		char playerMark = 'X';
		if (playerTurn[1] == turn) {
			do {
				printBoard(board);
				System.out.println(" '" + playerMark + "' " + " place mark");
				int ib = (int) (3 * Math.random());
				int jb = (int) (3 * Math.random());
				placeMarkBot(board, ib, jb, playerMark);
				if (checkDiagonalWin(board) == true || checkColumnWin(board) == true || checkRowWin(board) == true) {
					System.out.println();
					System.out.println();
					printBoard(board);
					if (playerMark == 'X' || playerMark != 'O') {
						System.out.println(" 'X' is Winner!!");
					} else {
						System.out.println(" 'O' is Winner!!");
					}

					break;
				} else if (boardFull(board)) {
					System.out.println();
					System.out.println();
					printBoard(board);
					System.out.println(" !!Draw!!");
					break;
				}
				turn++;
				if (turn % 2 == 0) { // change player turn
					playerMark = 'O';
				} else {
					playerMark = 'X';
				}
				System.out.println();
				System.out.println();
				printBoard(board);
				System.out.print(" '" + playerMark + "' " + " place mark at column : ");
				int j = scan.nextInt() - 1;
				if (j < 0 || j >= 3) {
					while (j < 0 || j >= 3) {
						System.out.println("ERROR!! you can't place mark out of bound table.");
						System.out.print(" '" + playerMark + "' " + " place mark at column : ");
						j = scan.nextInt() - 1;
					}
				}
				System.out.print("  row : ");
				int i = scan.nextInt() - 1;
				if (i < 0 || i >= 3) {
					while (i < 0 || i >= 3) {
						System.out.println("ERROR!! you can't place mark out of bound table.");
						System.out.print("  row : ");
						i = scan.nextInt() - 1;
					}
				}
				placeMark(board, i, j, playerMark);
				System.out.println();
				System.out.println();
				if (checkDiagonalWin(board) == true || checkColumnWin(board) == true || checkRowWin(board) == true) {
					System.out.println();
					System.out.println();
					printBoard(board);
					if (playerMark == 'X' || playerMark != 'O') {
						System.out.println(" 'X' is Winner!!");
					} else {
						System.out.println(" 'O' is Winner!!");
					}

					break;
				} else if (boardFull(board)) {
					System.out.println();
					System.out.println();
					printBoard(board);
					System.out.println(" !!Draw!!");
					break;
				}

				turn++;
				if (turn % 2 == 0) { // change player turn
					playerMark = 'O';
				} else {
					playerMark = 'X';
				}
			} while (boardFull(board) != true || checkDiagonalWin(board) != true || checkColumnWin(board) != true
					|| checkRowWin(board) != true);
		}
		if (playerTurn[0] == turn) {
			do {
				printBoard(board);
				System.out.print(" '" + playerMark + "' " + " place mark at column : ");
				int j = scan.nextInt() - 1;
				if (j < 0 || j >= 3) {
					while (j < 0 || j >= 3) {
						System.out.println("ERROR!! you can't place mark out of bound table.");
						System.out.print(" '" + playerMark + "' " + " place mark at column : ");
						j = scan.nextInt() - 1;
					}
				}
				System.out.print("  row : ");
				int i = scan.nextInt() - 1;
				if (i < 0 || i >= 3) {
					while (i < 0 || i >= 3) {
						System.out.println("ERROR!! you can't place mark out of bound table.");
						System.out.print("  row : ");
						i = scan.nextInt() - 1;
					}
				}
				placeMark(board, i, j, playerMark);
				if (checkDiagonalWin(board) == true || checkColumnWin(board) == true || checkRowWin(board) == true) {
					System.out.println();
					System.out.println();
					printBoard(board);
					if (playerMark == 'X' || playerMark != 'O') {
						System.out.println(" 'X' is Winner!!");
					} else {
						System.out.println(" 'O' is Winner!!");
					}

					break;
				} else if (boardFull(board)) {
					System.out.println();
					System.out.println();
					printBoard(board);
					System.out.println(" !!Draw!!");
					break;
				}
				turn++;
				if (turn % 2 == 0) { // change player turn
					playerMark = 'O';
				} else {
					playerMark = 'X';
				}
				System.out.println();
				System.out.println();
				printBoard(board);
				System.out.println(" '" + playerMark + "' " + " place mark");
				int ib = (int) (3 * Math.random());
				int jb = (int) (3 * Math.random());
				placeMarkBot(board, ib, jb, playerMark);
				System.out.println();
				System.out.println();
				if (checkDiagonalWin(board) == true || checkColumnWin(board) == true || checkRowWin(board) == true) {
					System.out.println();
					System.out.println();
					printBoard(board);
					if (playerMark == 'X' || playerMark != 'O') {
						System.out.println(" 'X' is Winner!!");
					} else {
						System.out.println(" 'O' is Winner!!");
					}

					break;
				} else if (boardFull(board)) {
					System.out.println();
					System.out.println();
					printBoard(board);
					System.out.println(" !!Draw!!");
					break;
				}
				turn++;
				if (turn % 2 == 0) { // change player turn
					playerMark = 'O';
				} else {
					playerMark = 'X';
				}
			} while (boardFull(board) != true || checkDiagonalWin(board) != true || checkColumnWin(board) != true
					|| checkRowWin(board) != true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("[Tic!!......'Tac'.....!!>Toe<!!]");
		System.out.println("1.)Player vs. Player.");
		System.out.println("2.)Player vs. Computer.");
		System.out.println("3.)Exit game.");
		int mode = scan.nextInt();
		if (mode == 1 && mode != 3) {
			pvpGame(mode);
		} else if (mode == 2 && mode != 3) {
			pvcGame(mode);
		}

	}

}