package com.learnbydoing.entity;

import java.util.HashSet;
import java.util.Set;

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
		
		this.values[line][column] = value;
	}
	
	@Override
	public int getValue(int... indexes) {
		
		int i = indexes[0];
		int j = indexes[1];
		
		int line = getLine(i);
		int column = getColumn(j);
		
		return this.values[line][column];
	}
	
	@Override
	public boolean isInvalid() {
		
		Set <Integer> uniqueValues = new HashSet<>();
		for (int i = 0; i < this.values.length; i++) {
			for (int j = 0; j < this.values.length; j++) {
				int value = this.values[i][j];
				if (value != 0) { 
					if(!uniqueValues.contains(Integer.valueOf(value))) {
						uniqueValues.add(value);
					} else {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	private int getLine(int i) {
		return i % 3;
	}
	
	private int getColumn(int j) {
		return j % 3;
	}
	
	public int[][] getValues() {
		return values;
	}
	
	public void setValues(int[][] values) {
		this.values = values;
	}

}
