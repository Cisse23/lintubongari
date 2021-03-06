package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BongattuLintuDAO;
import model.BongattuLintu;

@WebServlet("/lintubongari")
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BongattuLintuDAO dao = new database.JDBCBongattuLintu();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<BongattuLintu> linnut = dao.bongatutLinnut();

		req.setAttribute("linnut", linnut);

		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}