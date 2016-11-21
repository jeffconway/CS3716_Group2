public interface Format{

	public Match[] getSchedule();						//get the tournament schedule

	public void setSchedule(Match[] matches);			//set the schedule for the tournament

	public void editSchedule(Tournament tournament);	//edit the tournament schedule
}