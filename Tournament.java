import java.util.ArrayList;
import java.util.List;

public class Tournament{

	List<Team> teams = new ArrayList();						//the teams in the tournament
	List<Match> matches = new ArrayList();					//the matches in the tournament
	Format format;											//the format of the tournament
	String deadline, name, maxTeams, location;
	int numDivs; //the deadline to sign up for the tournament and the name of the tournament

	public Tournament(String deadline, String name, String maxTeams, String location, int numDivs){		//constructor for tournament
		this.deadline = deadline;
		this.name = name;
		this.maxTeams = maxTeams;
		this.location = location;
		this.numDivs = numDivs;
	}

	public List<Team> getTeams(){							//get the teams in the tournament
		return teams;
	}

	public List<Match> getMatches(){						//get the matches of the tournament
		return matches;
	}

	public Format getFormat(){								//get the format of the tournament
		return format;
	}

	public String getDeadline(){							//get the deadline of the tournament
		return deadline;
	}

	public String getName(){								//get the tournament name
		return name;
	}
	
	public String getMaxTeams() {
		return maxTeams;
	}
	
	public String getLocation() {
		return location;
	}

	public int getNumDivs() {
		return numDivs;
	}
	
	public void setMaxTeams(String maxTeams) {
		this.maxTeams = maxTeams;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setNumDivs(int numDivs) {
		this.numDivs = numDivs;
	}
	
	public void setFormat(Format tournamentFormat){			//set the format of the tournament
		format = tournamentFormat;
	}

	public void setSchedule(Match[] matches){				//set the schedule of the tournament
	}

	public void setName(String name){						//set the tournament name
		this.name = name;
	}

	public void addTeam(Team newTeam){						//add a team to the tournament
		teams.add(newTeam);
	}

	public void delTeam(Team newTeam){						//removes a team from the tournament
		//deletes team newTeam
	}
	
	public Team getTeams(Team teams){
		return teams;
	}

	public boolean isDeadline(){							//return if the deadline has passed
		//compare current date/time with deadline
		//if(past deadline){
		return true;
		//}
	}

	public void createMatches(){							//creates the matches of the tournament
	}

	public void editMatches(){								//edits the matches of the tournament
	}

	public void editSchedule(){								//edits the schedule of the tournament
	}
}