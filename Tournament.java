import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Tournament implements Serializable{

	List<Team> teams = new ArrayList<Team>();						//the teams in the tournament
	List<Match> matches = new ArrayList<Match>();					//the matches in the tournament
	Format format;											//the format of the tournament
	String deadline, name, maxTeams, location;//the deadline to sign up for the tournament and the name of the tournament

	public Tournament(String deadline, String name, String maxTeams, String location){		//constructor for tournament
		this.deadline = deadline;
		this.name = name;
		this.maxTeams = maxTeams;
		this.location = location;
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
	
	public void setMaxTeams(String maxTeams) {
		this.maxTeams = maxTeams;
	}
	
	public void setLocation(String location) {
		this.location = location;
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

	public void delTeam(Team delTeam){			//remove a player from the team		
		for(int i = 0; i <= teams.size(); i++){
			Team temp = teams.get(i);
			if((temp.name.compareTo(delTeam.name)) == 0){
				teams.remove(i);
				return;
			}
		}
	}
	
	public Team getTeams(Team teams){
		return teams;
	}

	public boolean isDeadline(){							//return true if the deadline has passed
		Date startDate;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();		
		try{
			startDate = df.parse(deadline);
			System.out.println(startDate);
			if(startDate.after(currentDate)){
				return true;
			}
			else{
				return false;
			}
		}
		catch (ParseException e){
			e.printStackTrace();
			return false;
		}
	}

	public void createMatches(){							//creates the matches of the tournament
	}

	public void editMatches(){								//edits the matches of the tournament
	}

	public void editSchedule(){								//edits the schedule of the tournament
	}
}
