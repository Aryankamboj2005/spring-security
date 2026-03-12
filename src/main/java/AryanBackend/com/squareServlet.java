package AryanBackend.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class squareServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out = res.getWriter();
		out.println("this is from the square servlet");
		// # these code are not valid when we are using the res.sendRedirect("square")
//		 int k = (int) req.getAttribute("k"); // we are fatching a value of the intType of the name "k" into the 
//		                            // variable k 

//		    PrintWriter outt = res.getWriter();
//		    outt.println("Value from AddServlet: "k); 
		
		// # to get the data from from the another servlet 
		int k = Integer.parseInt(req.getParameter("k"));
		PrintWriter outt = res.getWriter();
        outt.println("Value from AddServlet: "+k); 
}}
