package fi.agileo.spring.oma.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.agileo.spring.oma.bean.Match;

public class MatchDAOSpringJdbcImplTest {

	private MatchDAOSpringJdbcImpl matchDAO;
	private JdbcTemplate jdbcTemplate;
	private List<Match> matches;

	@Before
	public void setUp() throws Exception {

		matches.add(new Match("", "", 0, 0, false));
		matches.add(new Match("", "", 0, 0, false));
		matches.add(new Match("", "", 0, 0, false));

		jdbcTemplate = new JdbcTemplate() {
			@Override
			public int update(String sql, Object... args)
					throws DataAccessException {
				return 1;
			}

			@Override
			public <T> List<T> query(String sql, Object[] args,
					RowMapper<T> rowMapper) throws DataAccessException {
				if ("select id, home, away, home_goals, away_goals, overtime from hockeymatch"
						.equals(sql)) {
					return (List<T>) matches;
				}
				return null;
			}

		};

		matchDAO = new MatchDAOSpringJdbcImpl();
		matchDAO.setJdbcTemplate(jdbcTemplate);

	}

	@Test
	public void testFetchAll() throws DAOException {
		assertEquals(matches, matchDAO.fetchAll());
	}

//	@Test
//	public void testAdd() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testRemove() {
//		assertEquals(matches, matchDAO.remove(2));
//	}

}
