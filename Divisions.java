import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Divisions implements Format, Serializable {
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

	public void setSchedule1(Tournament tournament) {
		List<Team> teamList = tournament.getTeams(); // total number of teams
		Team[] randTeamList = null;

		Random rand = new Random();

		for (int i = 0; i < teamList.size(); i++) {
			int r = rand.nextInt(teamList.size()) + 1;

			if (r <= teamList.size()) {
				Team teamName = teamList.get(r);
				randTeamList[i] = teamName;
				teamList.remove(r);
			} else {
				break;
			}
		}

		List<Match> matches = new ArrayList<Match>();
		int group_per_players = teamList.size() / t1.getNumDivs(); // number of
																	// players
																	// in each
																	// division
		int g = group_per_players; // random

		for (int j = 0; j < g; g++) {
			for (int i = 0; i < group_per_players; i = i + 2) {
				if (teamList.size() % 2 == 0) { // check if teams are even
												// numbers
					Match match = new Match();
					match.setTeam1(randTeamList[i]);
					match.setTeam2(randTeamList[i + 1]);
					matches.add(match);
				} else {
					teamList.remove(rand.nextInt(teamList.size()) + 1);
					continue;
				}
			}
		}
	}

	@Override
	public void editSchedule(Tournament tournament) { // edit the tournament
														// schedule
	}

}