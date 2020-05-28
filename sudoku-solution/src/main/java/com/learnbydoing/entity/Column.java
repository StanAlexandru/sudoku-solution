package com.learnbydoing.entity;

import java.util.HashSet;
import java.util.Set;

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

	@Override
	public boolean isInvalid() {
		
		Set <Integer> uniqueValues = new HashSet<>();
		for (int v : values) {
			if (v != 0) { 
				if(!uniqueValues.contains(Integer.valueOf(v))) {
					uniqueValues.add(v);
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}
}
