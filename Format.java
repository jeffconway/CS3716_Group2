public interface Format{

	public Team[] setSchedule(Tournament tournament);			//set the schedule for the tournament

	public void editSchedule(Tournament tournament);	//edit the tournament schedule

	Team[] getSchedule(Tournament tournament);
}