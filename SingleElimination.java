import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

public class SingleElimination implements Format,Serializable{

	@SuppressWarnings("null")
	@Override
	public void setSchedule(Tournament tournament){			//set the schedule for the tournament
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
		
			List<Match> matches = new ArrayList<Match>();
			int i = 0;
			while (i <= teamList.size()) {
				if ((teamList.size() % 2) != 1) {
					Match match = new Match();
					match.setTeam1(randTeamList[i]);
					match.setTeam2(randTeamList[i+1]);
					matches.add(match);
					i = i+2;
				} else {
					teamList.remove(rand.nextInt(teamList.size()) + 1);
					break;
				}
			}
	}

	@Override
	public void editSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team[] getSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
		return null;
	}

}
