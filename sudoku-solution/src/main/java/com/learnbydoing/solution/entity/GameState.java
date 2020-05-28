package com.learnbydoing.solution.entity;

import java.util.Arrays;

import com.learnbydoing.entity.Board;

public class GameState {
	
	private Board board;

	private int [] position;	
	
	public GameState(Board board, int[] position) {
		super();
		this.board = board;
		this.position = position;
	}

	public boolean isInvalid() {
		return board.isInvalid();
	}
	
	public boolean isValid() {
		return !board.isInvalid();
	}

	public Board getBoard() {		
		return this.board;
	}

	public int[] getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "GameState [board=" + board + ", position=" + Arrays.toString(position) + "]";
	}
	
}
