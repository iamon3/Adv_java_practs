package com.companyQns.amazon.tournament;

public class TournamentUtil {
	
     public static Integer[] getWinner(String inputFile){
	 Integer[] winner = null;   
	 
	 TournamentSummaryBuilder tournamentSummaryBuilder = new TournamentSummaryBuilderHashMapImpl();
	 TournamentSummary tournamentSummary = tournamentSummaryBuilder.buildSummary(inputFile);
     winner = tournamentSummary.getWinner();
	 
     return winner;
   }
}
