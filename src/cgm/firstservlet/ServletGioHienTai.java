package cgm.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletGioHienTai
 */
@WebServlet(urlPatterns = "/helloBaby.do", initParams = {
		@WebInitParam(name = "mail1", value = "abc@gmail.com"),
		@WebInitParam(name = "mail2", value = "xyz@gmail.com")
} )
public class ServletGioHienTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGioHienTai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//cod o day
		// response ve Browser 1 trang HTML voi cai thoi gian la dong
		PrintWriter out = response.getWriter();//OutPut
		out.println("<html>");
		out.println("<body>");
		Date today = new Date();//gio ngay hien tai
		out.println("<h1 align=center> Hoc Lap Trinh Web </h1>");
		
		out.println("<br> today :" + today);
		
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Hello Web");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
