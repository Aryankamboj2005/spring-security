package AryanBackend.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/square") // same works as the mapping  <servlet> tag in the web.xml app
public class squareServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out = res.getWriter();
		out.println("this is from the square servlet");
		int k =0;
		// # these code are not valid when we are using the res.sendRedirect("square")
//		 int k = (int) req.getAttribute("k"); // we are fatching a value of the intType of the name "k" into the 
//		                            // variable k 

//		    PrintWriter outt = res.getWriter();
//		    outt.println("Value from AddServlet: "k); 
		
		// # to get the data from from the another servlet 
//		HttpSession session= req.getSession();
//		int k = (int) session.getAttribute("k");
//		session.removeAttribute("k"); // to remove the attribute
//		int k = Integer.parseInt(req.getParameter("k"));
		Cookie cookies[] =req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("k"))
				k=Integer.parseInt(c.getValue());
		}
		k = k*k;
		PrintWriter outt = res.getWriter();
        outt.println("Value from AddServlet: "+k); //
}}
