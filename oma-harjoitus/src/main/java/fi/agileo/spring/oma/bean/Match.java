package fi.agileo.spring.oma.bean;

public class Match {

	private long id;
	private String home;
	private String away;
	private int homeGoals;
	private int awayGoals;
	private boolean overtime;

	public Match(int id, String home, String away, int homeGoals,
			int awayGoals, boolean overtime) {
		setId(id);
		setHome(home);
		setAway(away);
		setHomeGoals(homeGoals);
		setAwayGoals(awayGoals);
		setOvertime(overtime);
	}

	public Match(String home, String away, int homeGoals, int awayGoals,
			boolean overtime) {
		setId(0);
		setHome(home);
		setAway(away);
		setHomeGoals(homeGoals);
		setAwayGoals(awayGoals);
		setOvertime(overtime);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	public boolean isOvertime() {
		return overtime;
	}

	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}

}
