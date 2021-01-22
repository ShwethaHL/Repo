package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String accno = (String) session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		int x = m.CheckBalance();
		if(x==1)
		{
			String balance = m.getBalance();
			session.setAttribute("bal", balance);
			res.sendRedirect("/Mvc2/dispBalance.jsp");
		}
		else
		{
			System.out.println("problem to fetch the data");
		}
	}

}
