package com.app.game;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		game = new Game();
		System.setOut(new PrintStream(out));
	}

	@Test
	public final void testShowWinnerTie() {
		game.showWinner(Choice.PAPER, Choice.PAPER);
		assertEquals(String.format("Tie!%n"), out.toString());
	}
	
	@Test
	public final void testShowWinnerPlayer() {
		game.showWinner(Choice.PAPER, Choice.ROCK);
		assertEquals(String.format("Player wins!%n"), out.toString());
	}
	
	@Test
	public final void testShowWinnerComputer() {
		game.showWinner(Choice.PAPER, Choice.SCISSORS);
		assertEquals(String.format("Computer wins!%n"), out.toString());
	}
}
