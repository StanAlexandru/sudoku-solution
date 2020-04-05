package com.learnbydoing.entity;

public class Board implements GameShape{
	
	private GameShape [] lines;
	private GameShape [] columns;
	private GameShape [] smallSquares;
	
	public Board() {
		super();
		this.lines = new Line[9];
		this.columns = new Column[9];
		this.smallSquares = new SmallSquare[9];
		
		init();
	}

	@Override
	public void setValue(int value, int ...indexes) {
		
		int i = indexes[0];
		int j = indexes[1];
		
		this.lines[i].setValue(value, j);
		this.columns[j].setValue(value, i);		

		int smallSquareIndex = getSmallSquareIndex(i, j);		
		this.smallSquares[smallSquareIndex].setValue(value, i, j);
	}
	
	@Override
	public int getValue(int ...indexes) {
		
		int i = indexes[0];
		int j = indexes[1];
		
		int smallSquareIndex = getSmallSquareIndex(i, j);
		
		return this.smallSquares[smallSquareIndex]
				.getValue(i, j);
	}
	
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		result.append("Board:").append("\n");
		for(int i = 0; i < this.lines.length; i++) {
			
			if(i == 0 || i == 3 || i == 6) {
				result.append("----------------------").append("\n");
			}
						
			result.append(lines[i]);			
			
			if(i == this.lines.length - 1) {
				result.append("----------------------").append("\n");
			}
		}
		
		return result.toString();

	}
	
	private void init() {
		for(int i = 0; i < 9; i++) {
			this.lines[i] = new Line();
			this.columns[i] = new Column();
			this.smallSquares[i] = new SmallSquare();
		}
	}
	
	private int getSmallSquareIndex(int i, int j) {
		
		if(i < 3) {
			if(j < 3) {
				return 0;
			}
			if(3 <= j && j < 6) {
				return 1;
			}
			if(j >= 6) {
				return 2;
			}
		} else if(3 <= i && i < 6) {
			if(j < 3) {
				return 3;
			}
			if(3 <= j && j < 6) {
				return 4;
			}
			if(j >= 6) {
				return 5;
			}
		} else if(i >= 6) {
			if(j < 3) {
				return 6;
			}
			if(3 <= j && j < 6) {
				return 7;
			}
			if(j >= 6) {
				return 8;
			}
		} 
		
		throw new ArrayIndexOutOfBoundsException();
	}

}
