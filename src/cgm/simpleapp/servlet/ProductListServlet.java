package cgm.simpleapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import cgm.simpleapp.beans.Product;
import cgm.simpleapp.conn.SQLServerConnUtils_SQLJDBC;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> listProduct = null;
		//
		try {
			// ket noi csdl - Model
			Connection conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();

			
			// model - lay len danh sach san pham
			//listProduct = DBUtils.queryProduct(conn);
			//http://localhost:8080/MyFirstProject/rest/products/all
			//java
			//Client client = Client.create();
			Client client = ClientBuilder.newClient();
			Response res = client
			.target("http://localhost:8080/MyFirstProject/rest/")
			.path("products/all")
			.request(MediaType.APPLICATION_JSON).header("", true)
			.get(Response.class);
			
			GenericType<List<Product>> generic = new GenericType<List<Product>>() {
				
			};
			
			listProduct = res.readEntity(generic);
			
			//JsonArray actal = new JSon
			
			//Response
			
			//System.out.println("chuoi" + list);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		// dua vao request
		request.setAttribute("list", listProduct);
		// forword den view jsp
		//response.sendRedirect: khong kem du lieu de chuyen di
		//RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ew.jsp");
		response.sendRedirect("/productList");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
