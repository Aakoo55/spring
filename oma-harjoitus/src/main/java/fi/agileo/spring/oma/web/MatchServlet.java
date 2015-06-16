package fi.agileo.spring.oma.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.agileo.spring.oma.bean.Match;
import fi.agileo.spring.oma.dao.DAOException;
import fi.agileo.spring.oma.dao.MatchDAO;

@WebServlet("/matches")
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MatchDAO hDao;
	ClassPathXmlApplicationContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatchServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		hDao = (MatchDAO) context.getBean("daoLuokka");
	}

	@Override
	public void destroy() {
		super.destroy();
		context.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String home = request.getParameter("home");
		String away = request.getParameter("away");
		int homeGoals = Integer.parseInt(request.getParameter("homeGoals"));
		int awayGoals = Integer.parseInt(request.getParameter("awayGoals"));
		boolean overtime = Boolean.parseBoolean(request
				.getParameter("overtime"));

		Match h = new Match(home, away, homeGoals, awayGoals, overtime);

		try {
			hDao.add(h);
		} catch (DAOException e) {
			throw new ServletException(e);
		}

		response.sendRedirect("matches"); // redirect doGet
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ASD");
		List<Match> matches = null;

		String delIdString = request.getParameter("delId");

		try {
			if (delIdString != null) {
				try {
					int id = Integer.parseInt(delIdString);
					hDao.remove(id);
				} catch (DAOException e) {
					request.setAttribute("error", e.getMessage());
				} catch (NumberFormatException e) {
					request.setAttribute("error", "Muotoilu virheellinen. Id="
							+ delIdString);
				}
			}

			// tietokannasta henkilöt
			matches = hDao.fetchAll();
		} catch (DAOException e) {
			throw new ServletException(e);
		}

		// requestiin talteen
		request.setAttribute("matches", matches);

		// jsp hoitaa muotoilun
		request.getRequestDispatcher("WEB-INF/jsp/matches.jsp").forward(
				request, response);
	}

}
