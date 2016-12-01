import java.util.List;

public interface Format{

	public void setSchedule(Tournament tournament);			//set the schedule for the tournament

	public void editSchedule(Tournament tournament);	//edit the tournament schedule

	Team[] getSchedule(Tournament tournament);
}