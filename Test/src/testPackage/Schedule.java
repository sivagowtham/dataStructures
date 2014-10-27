package testPackage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Schedule {
	public static List<Show> findOptimalSchedule(Collection<Show> shows)
	{
		ArrayList<Show> showsList = (ArrayList<Show>) shows;
		ArrayList<Show> solution = new ArrayList<Show>();
		solution.add(showsList.get(0));
		int i = 0;
		int n = showsList.size();

		for (int m=1;m<n;m++){
			Date start = (Date) showsList.get(m).getStartTime();
			Date finish = (Date) showsList.get(i).getEndTime();
			if (finish.before(start)){
				solution.add(showsList.get(m));
				i = m;
			}
		}
		return solution;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

		ArrayList<Show> shows = new ArrayList<Show>();
		shows.add(new Show("Show1", sdf.parse("2013-08-06 18:00"), sdf.parse("2013-08-06 20:00")));
		shows.add(new Show("Show2", sdf.parse("2013-08-06 19:00"), sdf.parse("2013-08-06 22:00")));
		shows.add(new Show("Show3", sdf.parse("2013-08-06 21:00"), sdf.parse("2013-08-06 23:00")));
		shows.add(new Show("Show3", sdf.parse("2013-08-06 21:00"), sdf.parse("2013-08-06 23:00")));
		List<Show> list = Schedule.findOptimalSchedule(shows);
		for (Show show : list) {
			System.out.println(show.getName());
		}
	}
}

class Show {
	private String name;
	private Date startTime;
	private Date endTime;

	public Show(String name, Date startTime, Date endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
}