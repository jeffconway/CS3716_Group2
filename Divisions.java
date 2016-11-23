import java.util.List;
import java.util.Random;

public class Divisions implements Format{

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
	}
	
/*	public void setSchedule(Match[] matches){			//set the schedule for the tournament
		Tournament t1;
		Team ts;
		Match m1;
		TournamentFrame tf;
		List<Team> teamList = t1.getTeams();
		Team[] randTeamList = null;
		Random rand = new Random();
			
		for(int i=0;i<teamList.size();i++){
			int  r = rand.nextInt(teamList.size()) + 1;
				
			if(){
					
			}
				
			}
		
			//set the schedule for the tournament
	} */

	@Override
	public void editSchedule(Tournament tournament){	//edit the tournament schedule
	}

	@Override
	public void setSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
	}

	@Override
	public Team[] getSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
		return null;
	}
}