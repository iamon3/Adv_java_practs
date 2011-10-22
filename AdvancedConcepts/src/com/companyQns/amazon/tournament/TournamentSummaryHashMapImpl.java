package com.companyQns.amazon.tournament;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TournamentSummaryHashMapImpl implements TournamentSummary {

	private Map<Integer, Map<Integer, Integer>> summary;  // <MatchId, <TeamId, Score>

	public Map<Integer, Map<Integer, Integer>> getSummary() {
		return summary;
	}

	public void setSummary(Map<Integer, Map<Integer, Integer>> summary) {
		this.summary = summary;
	}

	private void updateTeamStatAndWinnerTeam(Map<Integer, Integer> teamStat,Integer team, Integer[] winnerTeam){
		Integer matchesWon=0;
		
		if(false == teamStat.containsKey(team)){
			teamStat.put(team, 1);
			matchesWon = teamStat.get(team);
		}	
		else{
			matchesWon = teamStat.get(team);
			matchesWon = matchesWon +1;
			teamStat.put(team, matchesWon);
		}
			
			if (winnerTeam[1] < matchesWon){
				winnerTeam[0] = team;
				winnerTeam[1]= matchesWon;
			}
	}

	private void updateTeamStatAndWinnerTeam(Map<Integer, Integer> teamStat,Map<Integer, Integer> matchSummary, Integer[] winnerTeam){
		int i=0;
		Integer[] twoTeams = new Integer[4];

		for(Map.Entry<Integer, Integer> team:matchSummary.entrySet()){
			twoTeams[i]= team.getKey();
			twoTeams[i+1]=team.getValue();
			i =2;    	  
		}  	
		if(twoTeams[1] > twoTeams[3]){
			updateTeamStatAndWinnerTeam(teamStat,twoTeams[0], winnerTeam);
		}
		else if(twoTeams[1] < twoTeams[3]){
			updateTeamStatAndWinnerTeam(teamStat,twoTeams[2], winnerTeam);
		}
		//No need to handle draw case
		//else{
		//updateTeamStat(teamStat,twoTeams[0],twoTeams[2]);
		//}
	}


	public Integer[] getWinner() {

		Integer[] winnerTeam = new Integer[2];
		winnerTeam[0]=-1;
		winnerTeam[1]=-1;
		Map<Integer, Integer> teamStat = new HashMap<Integer, Integer>();

		for(Map.Entry<Integer, Map<Integer,Integer>> matchSummary:summary.entrySet()){
			updateTeamStatAndWinnerTeam(teamStat, matchSummary.getValue(), winnerTeam); 			
		}
		return winnerTeam;
	}

}
