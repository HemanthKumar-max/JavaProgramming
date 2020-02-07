package com.bridgelabz.fellowship.LogicalPrograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a Program to play a Cross Game or Tic-Tac-Toe Game. Player 1 is the Computer and the Player 2 is the user. Player 1 take Random Cell that is the Column and Row.  b
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import java.util.Scanner;

public class Tictactoe
{

	static final int EMPTY = 0;
	static final int NONE = 0;
	static final int USER = 2;
	static final int COMPUTER = 1;
	static final int STALEMATE = 3;


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		// Data objects
		// 1 = user, 2 = computer
		int turn = COMPUTER;


		// We will represent the board as nine cells 
		// 0 = empty, 1 = user, 2 = computer
		int[][] board = new int[3][3];

		// move: 1-9 representing ul through lr
		int move;

		// winner: 0 = none, 1 = user, 2 = computer, 3 = stalemate
		int winner;

		// Print Instructions
		System.out.println("This is a tic-tac-toe game");
		System.out.println("You are playing against the computer!");
		System.out.println("Enter 1-9 to indicate your move");

		// Print the board
		print_board(board);

		// While (game not over)
		while(true) {
			if(turn == COMPUTER)
			{
				move = computer_move(board);
				System.out.println("Computer move: " + move);

			}
			else {
				System.out.println("Your move");
				move = -1;
				while (move<0 || move>9 || board[move/3][move%3] != EMPTY) 
				{
					System.out.println("Please enter your move(0-9): ");
					move = sc.nextInt();

				}
			}

			// Update the board
			board[(int)(move/3)][move%3] = turn;

			// Print the board
			print_board(board);

			// if game is over
			winner = checkWinner(board);

			if(winner != NONE)
				break;

			// switch turn
			if(turn == USER) {
				turn = COMPUTER;
			} else {
				turn = USER;
			}

		}

		// Print out the outcome
		switch(winner) {
		case USER:
			System.out.println("You won!");
			break;
		case COMPUTER: 
			System.out.println("Computer won!");
			break;
		default:
			System.out.println("Tie!");
			break;
		}






	}

	// Print the board
	public static void print_board(int[][] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0][0] + " | " + board[0][1]+ " | " + board[0][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println("/---|---|---\\");
	}

	// Return an X or O, depending upon whose move it was
	public static char printChar(int b) {
		switch(b) {
		case EMPTY:
			return ' ';
		case USER:
			return 'X';
		case COMPUTER:
			return 'O';
		}
		return ' ';
	}

	// See if the game is over
	public static int checkWinner(int[][] board) {
		// Check if someone won
		// Check horizontals

		// top row
		if((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
			return board[0][0];

		// middle row
		if((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
			return board[1][0];

		// bottom row
		if((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
			return board[2][0];

		// Check verticals

		// left column
		if((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
			return board[0][0];

		// middle column
		if((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
			return board[0][1];

		// right column
		if((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
			return board[0][2];

		// Check diagonals
		// one diagonal
		if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
			return board[0][0];

		// the other diagonal
		if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
			return board[0][2];

		// Check if the board is full
		if(board[0][0] == EMPTY || 
				board[0][1] == EMPTY || 
				board[0][2] == EMPTY || 
				board[1][0] == EMPTY ||
				board[1][1] == EMPTY ||
				board[1][2] == EMPTY ||
				board[2][0] == EMPTY ||
				board[2][1] == EMPTY ||
				board[2][2] == EMPTY)
			return NONE;

		return STALEMATE;
	}

	// Generate a random computer move
	public static int computer_move(int[][] board) {
		int move = (int)(Math.random()*9);

		while(board[move/3][move%3] != EMPTY) 
			move = (int)(Math.random()*9);

		return move;
	}
}
