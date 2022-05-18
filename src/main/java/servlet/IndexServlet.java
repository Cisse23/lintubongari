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

@WebServlet("")
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BongattuLintuDAO dao = new database.JDBCBongattuLintu();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<BongattuLintu> linnut = new ArrayList<BongattuLintu>();
//		BongattuLintu lintu1 = new BongattuLintu(1, "Tilhi", "Takapiha", "17.5.2022");
//		BongattuLintu lintu2 = new BongattuLintu(2, "Lokki", "Kauppatori", "13.5.2022");
//		BongattuLintu lintu3 = new BongattuLintu(3, "Varis", "Takapiha", "7.3.2022");
//
//		linnut.add(lintu1);
//		linnut.add(lintu2);
//		linnut.add(lintu3);

		List<BongattuLintu> linnut = dao.bongatutLinnut();

		req.setAttribute("linnut", linnut);

		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}