import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Divisions implements Format{
	Tournament t1;
	
	Match m1;

	public Match[] getSchedule(){						//get the tournament schedule
		return null;
	}

	@SuppressWarnings("null")
	
	
	
	
	
	public void setSchedule1(Tournament tournament) {
		List<Team> teamList = tournament.getTeams();
		
		Team[] randTeamList = null;
		
		Random rand = new Random();
		
		for (int i=0; i < teamList.size(); i++) {
			int r = rand.nextInt(teamList.size()) + 1;
			
			if (r <= teamList.size()) {
				Team teamName = teamList.get(r);
				randTeamList[i] = teamName;
				teamList.remove(r);
			}
			else {
				break;
			}
		}
		
		List<Match> matches = new ArrayList();
		//List<Match> temp = new ArrayList();
		
		int group_per_players= matches.size()/t1.getNumDivs();   // number of players in each division
		
		/*
		for(int i=0;i<group_per_players;i++){   // put teams into diffent  groups
			temp1.add(i, m1.getTeam1());     // add teams into different groups, so that each groups will have teams
		}
		*/
		
		if(teamList.size()%2==0){     // check if teams are even numbers
			for(int i=0;i<group_per_players;i=i+2){
				
				Match match = new Match();
				
				match.setTeam1(randTeamList[i]);
				match.setTeam2(randTeamList[i+1]);
				matches.add(match);
			}
		}
		
		else{
			
			teamList.remove(rand.nextInt(teamList.size()) + 1);
			
		}
			
		

	}
	


	@Override
	public void editSchedule(Tournament tournament){	//edit the tournament schedule
	}

	//@Override
	//public void setSchedule(Tournament tournament) {
		 
	//}

	//@Override
	//public Team[] getSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
		//return null;
	//}
}