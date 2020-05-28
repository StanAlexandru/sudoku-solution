package com.learnbydoing.entity;

import java.util.Arrays;

public class Board implements GameShape{
	
	public static final int[] NO_AVAILABLE_POSITION = new int [] {-1, -1};
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

	public Board(GameShape [] lines, GameShape [] columns, GameShape [] smallSquares) {
		super();
		this.lines = lines;
		this.columns = columns;
		this.smallSquares = smallSquares;
	}

	@Override
	public void setValue(int value, int ...indexes) {
		
		int i = indexes[0];
		int j = indexes[1];
		
		this.getLines()[i].setValue(value, j);
		this.getColumns()[j].setValue(value, i);		

		int smallSquareIndex = getSmallSquareIndex(i, j);		
		this.getSmallSquares()[smallSquareIndex].setValue(value, i, j);
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
	
	@Override
	public boolean isInvalid() {
		for(GameShape l : this.lines) {
			if(l.isInvalid()) {
				return true;
			}
		}
		for(GameShape c : this.columns) {
			if(c.isInvalid()) {
				return true;
			}
		}
		for(GameShape s : this.smallSquares) {
			if(s.isInvalid()) {
				return true;
			}
		}
		return false;
	}
	
	public int[] nextAvailablePosition() {
		for(int i = 0; i < this.lines.length; i++) {
			for (int j = 0; j < this.columns.length; j++) {
				int value = this.lines[i].getValue(j);				
				if(value == 0) {
					return new int[] {i, j};				
				}
			}
		}
		return NO_AVAILABLE_POSITION;
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
		} else if(i >= 6 && i < 9) {
			if(j < 3) {
				return 6;
			}
			if(3 <= j && j < 6) {
				return 7;
			}
			if(j >= 6 && j < 9) {
				return 8;
			}
		} 
		
		throw new ArrayIndexOutOfBoundsException("Wrong Index!");
	}

	public GameShape[] getLines() {
		return Arrays.copyOf(this.lines, this.lines.length);
	}

	public GameShape[] getColumns() {
		return this.columns;
	}

	public GameShape[] getSmallSquares() {
		return this.smallSquares;
	}
	
	public Board clone() {
		
		GameShape[] linesClone = new Line[9];
		for(int i = 0; i < this.lines.length; i++) {			
			linesClone[i] = new Line();			
			for(int j = 0; j < this.columns.length; j++) {				
				int value = this.lines[i].getValue(j);
				linesClone[i].setValue(value, j);				
			}					
		}	
		
		GameShape[] columnsClone = new Column[9];
		for(int i = 0; i < this.columns.length; i++) {			
			columnsClone[i] = new Column();			
			for(int j = 0; j < this.lines.length; j++) {				
				int value = this.columns[i].getValue(j);
				columnsClone[i].setValue(value, j);				
			}					
		}
		
		GameShape[] squaresClone = new SmallSquare[9];
		for(int i = 0; i < this.smallSquares.length; i++) {			
			squaresClone[i] = new SmallSquare();
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					int value = this.smallSquares[i].getValue(x, y);
					squaresClone[i].setValue(value, x, y);
				}
			}			
		}
		
		return new Board(linesClone, columnsClone, squaresClone);		
		
	}
	
}
