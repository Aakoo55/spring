package fi.agileo.spring.oma.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super("Exception in data access.");
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
