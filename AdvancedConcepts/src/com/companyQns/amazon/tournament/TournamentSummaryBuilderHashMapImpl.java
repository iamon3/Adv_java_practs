package com.companyQns.amazon.tournament;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class TournamentSummaryBuilderHashMapImpl implements
TournamentSummaryBuilder {
	
	@Override
	public TournamentSummary buildSummary(String inputFile) {
		
	    TournamentSummaryHashMapImpl tournamentSummary = new TournamentSummaryHashMapImpl();	
		String currDir = System.getProperty("user.dir");
		try {
			Map<Integer, Map<Integer, Integer>> summary = null;
			//readFileAndCreatTournamentSummary(inputFile);
			summary = readFileAndCreatTournamentSummary(currDir.concat(inputFile));
			tournamentSummary.setSummary(summary);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tournamentSummary;
	}

	
	private Map<Integer,Map<Integer,Integer>> readFileAndCreatTournamentSummary(String inputFile) throws IOException{
		
		Map<Integer,Map<Integer,Integer>> summary = new HashMap<Integer,Map<Integer,Integer>>(); 
		
		File readFile = new File(inputFile);
		FileReader fileReader;
		try {
			fileReader = new FileReader(readFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine ; 
			while((readLine = bufferedReader.readLine()) != null){
				System.out.println(readLine);
				String[] tokens = readLine.split(" ");
				updateSummary(summary,tokens);
			}
			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
        return summary;
	}

	
	private void updateSummary(Map<Integer,Map<Integer,Integer>> summary,String[] tokens){
		
		Integer matchId  = Integer.parseInt(tokens[0]);
		Integer teamId   = Integer.parseInt(tokens[1]);
		Integer playerId = Integer.parseInt(tokens[2]);
		Integer score  = Integer.parseInt(tokens[3]);
		
		if (false == summary.containsKey(matchId)){
			
			Map<Integer, Integer> teamScoreSummary = new HashMap<Integer, Integer>();
			teamScoreSummary.put(teamId, score);
			summary.put(matchId,teamScoreSummary);
		}
		else{
			Map<Integer, Integer> teamScoresSummary = summary.get(matchId);
			if(false == teamScoresSummary.containsKey(teamId)){
			  teamScoresSummary.put(teamId, score);	
			}
			else{
				Integer prevScore = teamScoresSummary.get(teamId);
				teamScoresSummary.put(teamId, prevScore + score);
			}
		}
	}

}
