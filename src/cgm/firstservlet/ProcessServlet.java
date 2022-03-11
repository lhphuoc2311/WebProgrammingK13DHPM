package cgm.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/helloProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		this.getServletConfig().getInitParameter("");
		///this.getServletContext().getInitParameter(name)
		
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Infromation</title></head>");

		out.println("<body>");
		out.println("<h3>Infromation form</h3>");
		out.println("<p>First Name = " + firstName + "</p>");
		out.println("<p>Lats Name = " + lastName + "</p>");
		out.println("</body>");
		out.println("<html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
