package fi.agileo.spring.oma.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.agileo.spring.oma.bean.Match;

public class MatchDAOSpringJdbcImpl implements MatchDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Match> fetchAll() throws DAOException {

		String sql = "select id, home, away, home_goals, away_goals, overtime from hockeymatch";
		RowMapper<Match> mapper = new MatchRowMapper();
		List<Match> matches = jdbcTemplate.query(sql, mapper);

		return matches;
	}

	public void add(Match h) throws DAOException {

		String sql = "insert into hockeymatch(home, away, home_goals, away_goals, overtime) values(?,?,?,?,?)";

		Object[] parametrit = new Object[] { h.getHome(), h.getAway(),
				h.getHomeGoals(), h.getAwayGoals(), h.isOvertime() };
		jdbcTemplate.update(sql, parametrit);
	}

	public void remove(int id) throws DAOException {

		String sql = "delete from hockeymatch where id = ?";
		
		Object[] parametrit = new Object[] { id };
		jdbcTemplate.update(sql, parametrit);
	}

}
