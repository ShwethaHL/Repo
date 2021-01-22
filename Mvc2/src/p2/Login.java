package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String un = req.getParameter("un");
	    String pw = req.getParameter("pw");
	    Model m=new Model();
	    m.setUn(un);
	    m.setPw(pw);
	    int x = m.login();
	    if(x==0)
	    {
	    	res.sendRedirect("/Mvc2/FailureLogin.html");
	    	
	    }
	    else
	    {
	    	HttpSession session = req.getSession(true);
	    	String name = m.getName();
	    	String accno = m.getAccno();
	    	session.setAttribute("name", name);
	    	session.setAttribute("accno", accno);
	    	res.sendRedirect("/Mvc2/Home.jsp");
	    	
	    }
}
}
