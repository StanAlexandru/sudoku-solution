package com.learnbydoing.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void testCreate() {				
		assertNotNull(board);		
	}

	@Test
	public void testSetValue_0_0() {
		board.setValue(8, 0, 0);
		assertEquals(8, board.getValue(0, 0));
	}
	
	@Test
	public void testSetValue_6_7() {
		board.setValue(9, 6, 7);
		assertEquals(9, board.getValue(6, 7));
	}
	
	@Test
	public void testPrint_sudoku1_jpg() {
		
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
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetSmallSquareIndexForWrongValues() {
		assertEquals(0, board.getValue(new int [] {9, 9}));
	}
}
