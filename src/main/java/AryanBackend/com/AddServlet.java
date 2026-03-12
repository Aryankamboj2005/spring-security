package AryanBackend.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AddServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) 
	        throws IOException, ServletException {

	    int i = Integer.parseInt(req.getParameter("num1"));
	    int j = Integer.parseInt(req.getParameter("num2"));

	    int k = i + j;
	    //    ## one method to get data or request data from the another servlet 
	   // req.setAttribute("k", k); //we send the value k to the req and the name of the value is "k"

//	    RequestDispatcher rd = req.getRequestDispatcher("square");
//	    rd.forward(req,res);
	    
	    // another method to request data from the another servlet 
	    res.sendRedirect("square?k="+k);
	    
	}}