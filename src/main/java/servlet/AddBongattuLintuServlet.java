package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBongattuLintu")
public class AddBongattuLintuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		String laji = req.getParameter("laji");
		String paikka = req.getParameter("paikka");
		String pvm = req.getParameter("pvm");

		System.out.println("Added BongattuLintu: " + laji + " " + paikka + " " + pvm);
		// TODO: lisää BongattuLintu tietokantaan

		// TODO: Uudelleenohjaus etusivulle
		// req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		// resp.sendRedirect("/WEB-INF/index.jsp");

	}
}
