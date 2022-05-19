package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BongattuLintuDAO;
import database.JDBCBongattuLintu;
import model.BongattuLintu;

@WebServlet("/addBongattuLintu")
public class AddBongattuLintuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BongattuLintuDAO dao = new JDBCBongattuLintu();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		String laji = req.getParameter("laji");
		String paikka = req.getParameter("paikka");
		String pvm = req.getParameter("pvm");

		BongattuLintu lintu = new BongattuLintu(0, laji, paikka, pvm);
		dao.addBongattuLintu(lintu);

		System.out.println("Adding: " + laji + " " + paikka + " " + pvm);

		resp.sendRedirect("lintubongari");

	}
}
