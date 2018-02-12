package com.app.game;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

public class PlayerTest {
	
	private Player player1;
	private Player player2;

	@Test
	public final void testGetChoice() {
		String choice = "1";
		System.setIn(new ByteArrayInputStream(choice.getBytes()));
		Scanner scanner = new Scanner(System.in);
		player1 = new Player(scanner);
		assertEquals(Choice.ROCK, player1.getChoice());
	}

	@Test
	public final void testPlayAgain() {
		String choice = "y";
		System.setIn(new ByteArrayInputStream(choice.getBytes()));
		Scanner scanner = new Scanner(System.in);
		player2 = new Player(scanner);
		assertTrue(player2.playAgain()); 	
	}

}
