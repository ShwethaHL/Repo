package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Resetpwd
 */
public class Resetpwd extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String oldpwd = req.getParameter("oldpwd");
		String newpwd = req.getParameter("newpwd");
		HttpSession session = req.getSession();
		String accno = (String) session.getAttribute("acccno");
		
		Model m=new Model();
		m.setAccno(accno);
		m.setOldpwd(oldpwd);
		m.setNewpwd(newpwd);
		
		int x = m.Resetpwd();
		if(x==1)
		{
			res.sendRedirect("/Mvc2/SuccessResetpwd.html");
		}
		else
		{
			res.sendRedirect("/Mvc2/FailureResetpwd.html");
		}
		
	}

}
