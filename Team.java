import java.util.ArrayList;
import java.util.List;

public class Team{

	String name;								//name of team
	List<Player> players = new ArrayList();		//list of player names
	List<User> coaches = new ArrayList();		//list of coaches of the team
	int wins = 0, losses = 0;					//total wins and losses for the team, each object starts with 0

	public Team(String name){					//constructor for team
		this.name = name;
	}

	public String getTeamName(){				//get team name
		return name;
	}

	public List<Player> getPlayers(){			//get all players on team
		return players;
	}

	/*
	public List<Users> getCoaches(){			//get all coaches
		//search the user list for all coaches
		
	}
	*/

	public int getWins(){						//get the number of wins for the team
		return wins;
	}

	public int getLosses(){						//get the number of losses for the team
		return losses;
	}

	public void setTeamName(String name){		//set team name
		this.name = name;
	}	

	public void addPlayer(Player newPlayer){	//add a player to the team
		players.add(newPlayer);
	}

	public void addWin(){						//add a win
		wins++;
	}

	public void addLoss(){						//add a loss
		losses--;
	}

	public void delPlayer(Player playerDel){			//remove a player from the team		
		for(int i = 0; i <= players.size(); i++){
			if(players.get(i) == playerDel){			//this might not work... not sure if you can compare it directly like this. could change it to check for player name.
				players.remove(i);
				return;
			}
		}
	}	

	public void delCoach(User coachDel){				//remove a coach from the team
		for(int i = 0; i <= coaches.size(); i++){
			if(coaches.get(i) == coachDel){				//this might not work... not sure if you can compare it directly like this. could change it to check for coach name.
				players.remove(i);
				return;
			}
		}	
	}

	public void removeWin(){					//remove a win
		wins--;
	}

	public void removeLoss(){					//remove a loss
		losses--;
	}
}