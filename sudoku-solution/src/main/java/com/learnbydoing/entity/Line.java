package com.learnbydoing.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Line implements GameShape{
	
	private int [] values;
	
	public Line() {
		this.values = new int [9];
	}

	@Override
	public void setValue(int value, int... indexes) {
		int j = indexes[0];
		this.values[j] = value;
	}
	
	@Override
	public int getValue(int... indexes) {
		int j = indexes[0];
		return this.values[j];
	}

	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < this.values.length; i++) {
			
			int val = this.values[i];
			
			if(i % 3 == 0) {
				result.append("|");
			}
			
			if(val != 0) {
				result.append(val + " ");
			} else {
				result.append("_" + " ");
			}
		}
		result.append("|").append("\n");
		return result.toString();
	}
	
	@Override
	public boolean isInvalid() {
		
		Set <Integer> uniqueValues = new HashSet<>();
		for (int v : this.values) {
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

}
