package fi.agileo.spring.oma.dao;

import java.util.List;

import fi.agileo.spring.oma.bean.Match;

public interface MatchDAO {

	/**
	 * Fetch all matches from DB
	 * 
	 * @return list of matches
	 */
	public List<Match> fetchAll() throws DAOException;

	/**
	 * Adds match to DB
	 * 
	 * @param m
	 *            Match to add
	 */
	public void add(Match h) throws DAOException;

	/**
	 * Removes match from DB
	 * 
	 * @param m
	 *            Id of match to remove
	 */
	public void remove(int id) throws DAOException;

}
