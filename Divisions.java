import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Divisions implements Format, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tournament t1;
	Team t;
	Match m1;

	public Match[] getSchedule() { // get the tournament schedule
		return null;
	}

	@SuppressWarnings("null")

	public void setSchedule(Tournament tournament) {
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
		int group_per_players = randTeamList.size() / tournament.getNumDivs(); // number of
																	// players
																	// in each
																	// division
		int g = group_per_players; // random

		for (int j = 0; j < g; j++) {
			for (int i = 0; i < group_per_players; i = i + 2) {
				System.out.println(i+" test "+j);
				if (randTeamList.size() % 2 == 0) { // check if teams are even
												// numbers
					Match match = new Match();
					match.setTeam1(randTeamList.get(i));
					match.setTeam2(randTeamList.get(i + 1));
					matches.add(match);
				} else {
					randTeamList.remove(rand.nextInt(randTeamList.size()));
					continue;
				}
			}
		}
		tournament.setMatches(matches);
	}

	@Override
	public void editSchedule(Tournament tournament) { // edit the tournament
														// schedule
	}
	public Team[] getSchedule(Tournament tournament) { // edit the tournament
		Team[] t = new Team[1];		
		return t;											// schedule
	}
	public String getType() {
		return "d";
	}
}
