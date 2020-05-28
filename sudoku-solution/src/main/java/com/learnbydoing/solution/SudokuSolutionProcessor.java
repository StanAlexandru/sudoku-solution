package com.learnbydoing.solution;

import java.util.Deque;
import java.util.LinkedList;

import com.learnbydoing.entity.Board;
import com.learnbydoing.solution.entity.GameState;

public class SudokuSolutionProcessor {
	
	private Deque <GameState> solutionStates;
	private GameState initialState;
	private int value = 1;
	private GameState nextState;
	private Board nextBoard;
	
	public SudokuSolutionProcessor(GameState initialState) {
		super();
		this.solutionStates = new LinkedList<>();
		this.initialState = initialState;
	}
	
	public void start() {		
		processState(initialState);		
	}
	
	public void processState(GameState state) {	
		
		System.out.println("processState: \n" + state);
		
		Board currentBoard = state.getBoard().clone();
		
		int[] nextAvailablePosition = currentBoard.nextAvailablePosition();		
		
		if(state.isValid()) {
			
			processValidState(state, currentBoard, nextAvailablePosition);
				
		} else if(value < 9){
			
			value++;
				
			GameState previuosState = getLastSolutionState();
			int [] position = previuosState.getBoard().nextAvailablePosition();
			
			Board nextBoard = currentBoard.clone();
			nextBoard.setValue(value, position);
			
			nextState = new GameState(
					nextBoard, position);
				
			processState(nextState);	
				
		} else {
			
			GameState previuosSolutionState = getLastSolutionState();
			int [] position = previuosSolutionState.getPosition();
			
			Board previousBoard = previuosSolutionState.getBoard().clone();			
			int previousValue = previousBoard.getValue(position);
			
			if(previousValue < 9) {
								
				value = previousValue + 1;
				
				previousBoard.setValue(value, position);
				
				nextState = new GameState(
						previousBoard, position);
				
				this.solutionStates.removeLast();
				
				processState(nextState);
				
			} else {
				
				this.solutionStates.removeLast();
				
				GameState nextPreviuosSolutionState = getLastSolutionState();
				int [] nextPreviuosPosition = nextPreviuosSolutionState.getPosition();
				
				Board nextPreviousBoard = nextPreviuosSolutionState.getBoard().clone();			
				int nextPreviousValue = nextPreviousBoard.getValue(nextPreviuosPosition);
				

				value = nextPreviousValue + 1;
				
				this.solutionStates.removeLast();
				
				nextPreviuosSolutionState = getLastSolutionState();
				
				nextBoard = nextPreviuosSolutionState.getBoard();
				int [] nextPosition = nextBoard.nextAvailablePosition();
				
				
				nextBoard.setValue(value, nextPosition);
				
				nextState = new GameState(
						nextBoard, nextPosition);
				
				processState(nextState);
				
			}
			
		}
		
	}

	private void processValidState(GameState state, Board currentBoard, int[] nextAvailablePosition) {
		this.solutionStates.add(state);	
		
		if(nextAvailablePosition == Board.NO_AVAILABLE_POSITION) {
			displaySolution();
			return;
		}

		nextBoard = currentBoard.clone();
		
		//once added a new valid state reset value
		value = 1;
		
		nextBoard.setValue(value, nextAvailablePosition);
		
		nextState = new GameState(
				nextBoard, 
				nextAvailablePosition);
		
		processState(nextState);
	}

	private GameState getLastSolutionState() {
		if(solutionStates.size() > 0) {
			return solutionStates.peekLast();
		}
		throw new RuntimeException("No available State");
	}
	
	private void displaySolution() {
		System.out.println(getLastSolutionState());
	}

}
