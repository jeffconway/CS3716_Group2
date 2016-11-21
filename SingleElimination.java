import java.util.List;
import java.util.Random;

public class SingleElimination implements Format{


	@SuppressWarnings("null")
	@Override
	public Team[] setSchedule(Tournament tournament){			//set the schedule for the tournament
		List<Team> teamList = tournament.getTeams();
		Team[] bracket = null;
		Random rand = new Random();
		
		for (int i=0; i < teamList.size() -1; i++) {
			int r = rand.nextInt(teamList.size() + 1) + 1;
			
			if (r <= teamList.size()) {
				Team teamName = teamList.get(r);
				bracket[i] = teamName;
				teamList.remove(r);
			}
			else {
				break;
			}
			
		}
		return bracket;
	}

	@Override
	public Team[] getSchedule(Tournament tournament){
		return setSchedule(tournament);
	}

	@Override
	public void editSchedule(Tournament tournament) {
		// TODO Auto-generated method stub
		
	}

}