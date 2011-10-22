package com.companyQns.amazon.tournament;

public class Test {
	
    protected static String TOURNAMENT_INPUT_FILE = "/tournament_input.txt"; // "E:\\input.txt"; 
    
	public static void main(String[] args) {
     Integer[] winner = null;
     winner = TournamentUtil.getWinner(Test.TOURNAMENT_INPUT_FILE);
     System.out.println("Team " + winner[0]+" won tournment. Matches won :- "+winner[1]);
	}

}
