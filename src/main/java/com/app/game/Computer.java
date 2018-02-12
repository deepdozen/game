package com.app.game;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.collect.Multiset;

public class Computer implements Action {

	@Override
	public Choice getChoice() {
		Choice[] choices = Choice.values();
		Random random = new Random();
		return choices[random.nextInt(choices.length)];
	}

	/**
	 *  returns choice based on previous player results
	 *  choose minimum occurrence
	 */
	public Choice getChoice(Multiset<Choice> bag) {
		ArrayList<Integer> list = new ArrayList<>(3);
		Choice[] choices = Choice.values();
		for(int i = 0; i < 3; i++) {
			list.add(bag.count(Choice.getChoice((new Integer(i+1)).toString())));
		}
		int min = list.stream().min(Integer::compare).get();
		return choices[list.indexOf(min)];
	}
}
