import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

public class SingleElimination implements Format,Serializable{

	@SuppressWarnings("null")
	@Override
	public void setSchedule(Tournament tournament){			//set the schedule for the tournament
		ArrayList<Team> teamList = new ArrayList<Team>();
		try {
			for (int i=0; i < tournament.getTeams().size(); i++) {
				teamList.add(((Team) tournament.getTeams().get(i).clone()));
			}
		}
		catch(CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		ArrayList<Team> randTeamList = new ArrayList<Team>();
		Random rand = new Random();
		int size = teamList.size();
		for (int i=0; i < size; i++) {
			int r = rand.nextInt(teamList.size());
				Team teamName = teamList.get(r);
				randTeamList.add(teamName);
				teamList.remove(r);
		}
		
		List<Match> matches = new ArrayList<Match>();
		int i = 0;
		while (i < randTeamList.size()) {
			if ((randTeamList.size() % 2) != 1) {
				Match match = new Match();
				match.setTeam1(randTeamList.get(i));
				match.setTeam2(randTeamList.get(i+1));
				matches.add(match);
				i = i+2;
			} else {
				randTeamList.remove(rand.nextInt(teamList.size()));
				continue;
			}
		}
		tournament.setMatches(matches);
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
