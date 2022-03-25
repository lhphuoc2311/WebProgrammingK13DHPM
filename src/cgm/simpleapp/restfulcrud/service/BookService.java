package cgm.simpleapp.restfulcrud.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import cgm.simpleapp.beans.Product;
import cgm.simpleapp.conn.SQLServerConnUtils_SQLJDBC;
import cgm.simpleapp.utils.DBUtils;

@Path("books")
public class BookService {

	@GET
	@Path("/helloworld")
	public String helloworld() {
		return "Helloworld !!!!";
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> queryProduct() {
		Connection conn = null;

		List<Product> list = null;

		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			list = DBUtils.queryProduct(conn);
		} catch (SQLException e) { // TODOuto-generated
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}
	
	@Path("/insert")
	@POST
	public void addProduct(Product p) {
		
		Connection conn = null;

		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			DBUtils.insertProduct(conn, p);;
		} catch (SQLException e) { // TODOuto-generated
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
