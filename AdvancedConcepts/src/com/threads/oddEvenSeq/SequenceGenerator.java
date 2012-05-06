package com.threads.oddEvenSeq;

public class SequenceGenerator implements Runnable {

	private static boolean turnSelector = true;
	public static int LOOP_COUNT;

	private int currentNumber ;
	private boolean initialTurn;

	// Constructor
	public SequenceGenerator(int startingNumber, boolean turn){
		this.currentNumber = startingNumber;
		this.initialTurn = turn;
	}

	// Main Run method
	@Override
	public void run() {
		int limit = 2*LOOP_COUNT;
		while(currentNumber <= limit){
			if(isMyTurn() ){
				System.out.println(Thread.currentThread().getName()+" "+currentNumber);
				currentNumber += 2;
				toggleTurn();
			}
		}
	}

	//NOR logic => ~XOR
	private boolean isMyTurn(){
		return !(initialTurn ^ turnSelector);	
	}

	//Give turn to another thread
	private synchronized void toggleTurn(){
		SequenceGenerator.turnSelector = !SequenceGenerator.turnSelector;
	}

}
