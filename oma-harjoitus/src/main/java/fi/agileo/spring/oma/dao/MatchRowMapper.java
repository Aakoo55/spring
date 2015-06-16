package fi.agileo.spring.oma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.agileo.spring.oma.bean.Match;

public class MatchRowMapper implements RowMapper<Match> {

	public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Match(rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
	}

}
