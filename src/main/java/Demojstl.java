import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Demojstl")
public class Demojstl extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String name = "Aryan";

        req.setAttribute("name", name);

        RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
        rd.forward(req, res);
    }
}