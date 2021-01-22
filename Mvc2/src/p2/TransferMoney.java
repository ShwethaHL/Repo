package p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferMoney
 */
public class TransferMoney extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String raccno = req.getParameter("raccno");
		String amt = req.getParameter("amt");
		
		HttpSession session = req.getSession();
		String accno = (String) session.getAttribute("accno");
		
		Model m=new Model();
		m.setAccno(accno);
		m.setRaccno(raccno);
		m.setAmt(amt);
		
		int x=m.TransferMoney();
		
		if(x==0)
		{
			res.sendRedirect("/Mvc2/FailureTransferMoney");
		}
		else
		{
			res.sendRedirect("/Mvc2/SucccessTransferMoney");
		}
		
	}

}
