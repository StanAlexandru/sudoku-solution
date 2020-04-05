package com.learnbydoing.entity;

public class Column implements GameShape {
	
	private int [] values;
	
	public Column() {
		this.values = new int[9];
	}
	
	@Override
	public void setValue(int value, int... indexes) {
		int i = indexes[0];
		this.values[i] = value;
	}

	@Override
	public int getValue(int... indexes) {
		int i = indexes[0];
		return this.values[i];
	}

}
