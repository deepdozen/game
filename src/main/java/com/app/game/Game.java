package com.app.game;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.Multiset;

public class Game {

	private Computer computer;
	private Player player;
	private int numberOfGames, cpuWins, playerWins, ties;
	private Multiset<Choice> playerChoices;

	public Game() {
		this.computer = new Computer();
		this.player = new Player();
		this.playerChoices = EnumMultiset.create(Choice.class);
	}

	public void start() {
		System.out.println("Game started!");
		Choice playerChoice = player.getChoice();
		Choice cpuChoice = null;
		if (playerChoices.size() == 0) {
			cpuChoice = computer.getChoice();
		} else {
			cpuChoice = computer.getChoice(playerChoices);
		}

		System.out.printf("Your choice : %s%n", playerChoice);
		System.out.printf("Computer choice : %s%n", cpuChoice);
		showWinner(playerChoice, cpuChoice);

		if (player.playAgain()) {
			System.out.println();
			start();
		} else {
			showStats();
		}
	}

	private void showStats() {
		System.out.printf("Number of games: %s%n", numberOfGames);
		System.out.printf("Player choices: %s%n", playerChoices);
		System.out.printf("Player wins: %s; Computer wins: %s; Ties: %s;%n", cpuWins, playerWins, ties);
	}

	public void showWinner(Choice playerChoice, Choice cpuChoice) {
		int result = playerChoice.getResult(cpuChoice);
		if (result == 0) {
			System.out.println("Tie!");
			ties++;
		} else if (result == 1) {
			System.out.println("Player wins!");
			cpuWins++;
		} else if (result == -1) {
			System.out.println("Computer wins!");
			playerWins++;
		}
		numberOfGames++;
		playerChoices.add(playerChoice);
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
