package fi.agileo.spring.oma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DAOExceptionTest {

	private final Throwable cause = new Throwable();

	@Test
	public void testContructor_no_params() {
		DAOException exception = new DAOException();
		assertEquals("Exception in data access.", exception.getMessage());
	}

	@Test
	public void testContructor_msg_set() {
		DAOException exception = new DAOException("msg");
		assertEquals("msg", exception.getMessage());
	}

	@Test
	public void testContructor_cause_set() {
		DAOException exception = new DAOException(cause);
		assertEquals(cause, exception.getCause());
	}

	@Test
	public void testContructor_msg_and_cause_set() {
		DAOException exception = new DAOException("msg", cause);
		assertEquals(cause, exception.getCause());
		assertEquals("msg", exception.getMessage());
	}
}
