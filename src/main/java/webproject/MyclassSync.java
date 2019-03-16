package webproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.db.DatabaseOper;

public class MyclassSync extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = req.getParameter("forminput");
		System.out.println("servletSync:"+s);
		DatabaseOper dbop = new DatabaseOper();
		dbop.insertdata(s);
		String str = dbop.selectdata();
		req.setAttribute("str", str);
		req.getRequestDispatcher("/test/test.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
}
