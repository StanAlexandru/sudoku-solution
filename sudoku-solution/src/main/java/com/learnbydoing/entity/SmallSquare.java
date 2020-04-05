package com.learnbydoing.entity;

public class SmallSquare implements GameShape {
	
	private int [][] values;

	public SmallSquare() {
		values = new int [3][3];
		for (int i = 0; i < 3; i++) {
			values[i] = new int [3];
		}
	}
	
	@Override
	public void setValue(int value, int... indexes) {	
		
		int i = indexes[0];
		int j = indexes[1];
		
		int line = getLine(i);
		int column = getColumn(j);
		
		values[line][column] = value;
	}
	
	@Override
	public int getValue(int... indexes) {
		
		int i = indexes[0];
		int j = indexes[1];
		
		int line = getLine(i);
		int column = getColumn(j);
		
		return this.values[line][column];
	}

	private int getLine(int i) {
		return i % 3;
	}
	
	private int getColumn(int j) {
		return j % 3;
	}

}
