package com.app.game;

public enum Choice {
	ROCK("1"), PAPER("2"), SCISSORS("3");
	
	Choice(String num) {
		this.number = num;
	}
	
	private final String number;
	
	public static Choice getChoice(String num) {
		for (Choice choice: Choice.values()) {
			if(choice.number.equals(num)) {
				return choice;
			}
		}
		return null;
	}
	
	/**
	 * Compares current choice with "other" choice
	 * 
	 * @param other 
	 * @return 1 - current choice win; -1 - other choice win; 0 - tie 
	 * 
	 */
	public int getResult(Choice other) {
		if(this == other) {
			return 0;
		}
        switch (this) {
        case ROCK:
            return (other == SCISSORS ? 1 : -1);
        case PAPER:
            return (other == ROCK ? 1 : -1);
        case SCISSORS:
            return (other == PAPER ? 1 : -1);
        }
		return 0;
	}
}
