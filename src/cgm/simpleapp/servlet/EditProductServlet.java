package cgm.simpleapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.internal.routing.ClientResponseMediaTypeDeterminer;

import cgm.simpleapp.beans.Product;
import cgm.simpleapp.conn.SQLServerConnUtils_SQLJDBC;
import cgm.simpleapp.utils.DBUtils;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Product product = null;
		// DB
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// edi thang nao=>code
		String code = request.getParameter("code");

		// lay thong cua sp bang ma
		try {
			//REST
			product = DBUtils.findProduct(conn, code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// kem du lieu
		request.setAttribute("product", product);

		// chuyeen teip sang editProductView.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// DB
		Connection conn = null;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String code = request.getParameter("code").toString();
		String name = request.getParameter("name").toString();

		String priceStr = (String) request.getParameter("price");
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
		}

		Product product = new Product(code, name, price);

		String errorString = null;
		
		//caap nhat udpate
		//http://localhost:8080/MyFirstProject/rest/products/edit/{code}
		try {
			//DBUtils.updateProduct(conn, product);
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client
					.target("http://localhost:8080/MyFirstProject/rest/")
					.path("edit");
			Invocation.Builder invoBuilder = webTarget
					.request(MediaType.APPLICATION_JSON);
			Response rs = invoBuilder
					.put(Entity.
							entity(product, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		//chuyen tiep trang phu hojp
		
		request.setAttribute("product", product);
		request.setAttribute("errorString", errorString);
		
		
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(request, response);
		}
		// Nếu mọi thứ tốt đẹp.
		// Redirect sang trang danh sách sản phẩm.
		else {
			response.sendRedirect(request.getContextPath() + "/productList");
		}

	}

}
