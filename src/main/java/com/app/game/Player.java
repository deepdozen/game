package com.app.game;

import java.util.Scanner;

public class Player implements Action {
	
	private Scanner scanner;

	public Player() {
		this.scanner = new Scanner(System.in);
	}

	public Player(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public Choice getChoice() {
		System.out.println("Please, choose number : [1 = ROCK, 2 = PAPER, 3 = SCISSORS]");
		String input = scanner.nextLine();
		
		Choice choice = Choice.getChoice(input);
		
		if(choice != null)
			return choice;
		
		return getChoice();
	}

	public boolean playAgain() {
	    System.out.println("Do you want play again ? [Y/N]");
	    String input = scanner.nextLine();
	    return input.toUpperCase().equals("Y");
	}
	
}
