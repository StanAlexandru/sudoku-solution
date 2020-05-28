package com.learnbydoing.solution;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.learnbydoing.entity.Board;
import com.learnbydoing.solution.entity.GameState;

public class SudokuSolutionProcessorTest {
	
	private Board board;
	private GameState initialState;
	
	
	@Before
	public void setUp() {
		board = new Board();
		board.setValue(8, 0, 0); board.setValue(4, 0, 3); board.setValue(6, 0, 5); board.setValue(7, 0, 8);
		board.setValue(4, 1, 6);		
		board.setValue(1, 2, 1); board.setValue(6, 2, 6); board.setValue(5, 2, 7);
		board.setValue(5, 3, 0); board.setValue(9, 3, 2); board.setValue(3, 3, 4); board.setValue(7, 3, 6); board.setValue(8, 3, 7);
		board.setValue(7, 4, 4);
		board.setValue(4, 5, 1); board.setValue(8, 5, 2); board.setValue(2, 5, 4); board.setValue(1, 5, 6); board.setValue(3, 5, 8);
		board.setValue(5, 6, 1); board.setValue(2, 6, 2); board.setValue(9, 6, 7);
		board.setValue(1, 7, 2);
		board.setValue(3, 8, 0); board.setValue(9, 8, 3); board.setValue(2, 8, 5); board.setValue(5, 8, 8);
		
		System.out.println(board);
		
		initialState = new GameState(board, new int[] {0,0});
	}
	
	/*
	@Before
	public void setUp() {
		board = new Board();
		board.setValue(4, 0, 0); board.setValue(2, 0, 2); board.setValue(6, 0, 3); board.setValue(3, 0, 4);
		board.setValue(8, 0, 5); board.setValue(1, 0, 6); board.setValue(7, 0, 7); board.setValue(9, 0, 8);
		
		System.out.println(board);
		
		initialState = new GameState(board, new int[] {0,0});
	}
	*/
	/*
	@Before
	public void setUp() {
		board = new Board();
		board.setValue(8, 0, 0); 
		board.setValue(3, 1, 2); board.setValue(6, 1, 3);
		board.setValue(7, 2, 1); board.setValue(9, 2, 4); board.setValue(2, 2, 6);
		board.setValue(5, 3, 1); board.setValue(7, 3, 5);
		board.setValue(4, 4, 4); board.setValue(5, 4, 5); board.setValue(7, 4, 6);
		board.setValue(1, 5, 3); board.setValue(3, 5, 7); 
		board.setValue(1, 6, 2); board.setValue(6, 6, 7); board.setValue(8, 6, 8);
		board.setValue(8, 7, 2); board.setValue(5, 7, 3); board.setValue(1, 7, 7);
		board.setValue(9, 8, 1); board.setValue(4, 8, 6); 
		
		System.out.println(board);
		
		initialState = new GameState(board, new int[] {0,0});
	}
	*/

	@Test
	public void testInitialStateIsValid() {		
		assertFalse(initialState.isInvalid());
	}
	
	@Test
	public void testNextAvailablePosition() {
		int[] nextAvailablePosition = initialState.getBoard().nextAvailablePosition();
		assertEquals(0, nextAvailablePosition[0]);
		assertEquals(1, nextAvailablePosition[1]);
	}
	
	@Test
	public void testResolve() {
		SudokuSolutionProcessor p = new SudokuSolutionProcessor(initialState);
		p.start();
	}
	

}
