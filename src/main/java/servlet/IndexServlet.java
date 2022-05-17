package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BongattuLintu;

@WebServlet("")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BongattuLintu> linnut = new ArrayList<BongattuLintu>();
		BongattuLintu lintu1 = new BongattuLintu("Tilhi", "Takapiha", "17.5.2022");
		BongattuLintu lintu2 = new BongattuLintu("Lokki", "Kauppatori", "13.5.2022");
		BongattuLintu lintu3 = new BongattuLintu("Varis", "Takapiha", "7.3.2022");

		linnut.add(lintu1);
		linnut.add(lintu2);
		linnut.add(lintu3);

		req.setAttribute("linnut", linnut);

		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}