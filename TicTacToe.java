package com.lakshman.Projects;

import java.util.Scanner;

public class tic_tac_toe {

	public static void main(String[] args) {

		char board[][] = new char[3][3];
		//printing empty board
		boolean gameOver = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
				System.out.print("_|");
			}
			System.out.println();
		}
		int row, col;
		char player = 'X';
		while (!gameOver) { // if player won the match it  will terminate
			inputOutput(board, player);//input from user 
			gameOver = winOrLoss(board, player);
			if(gameOver)
				System.out.println("Player " + player + " won the match");
			if(player == 'X')
				player = 'Y';
			else {
				player = 'X';
			}
		}
	}
	
	
	//checking who is win Or loss
	private static boolean winOrLoss(char[][] board, char player) {
		// diagonal checking

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			
			return true;
		}

		// checking rows
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}

		// checking columns
		for (int col = 0; col < 3; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		return false;
	}
	
	
	
	// ......input from user.....
	private static void inputOutput(char board[][], char player) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter " + player + " :");//input from user
		int row = scan.nextInt();
		int col = scan.nextInt();
		
		int checkRow = String.valueOf(col).length();
		int checkCol = String.valueOf(col).length();
		
		if(row >=3 || col >= 3 || checkRow >= 2 || checkCol >= 2) {   //if input is greater than 3 returning the message
			System.out.println("Enter number in between 0 - 3 ");
			inputOutput(board, player);
		}
		if (board[row][col] == ' ') {//updating element into board
			board[row][col] = player;
		} else {					//if element already entered then returning the message
			System.out.println("Invalid position entered!!!!!....");
			System.out.println("Enter a valid position ");
			inputOutput(board, player);
		}
		for (int i = 0; i < 3; i++) {// printing board ...
			for (int j = 0; j < 3; j++) {
				System.out.print(" "+board[i][j]+"| ");
			}
			System.out.println();
		}
	}
}
