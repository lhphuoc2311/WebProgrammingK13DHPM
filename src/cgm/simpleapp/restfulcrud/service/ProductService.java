package cgm.simpleapp.restfulcrud.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cgm.simpleapp.beans.Product;
import cgm.simpleapp.conn.SQLServerConnUtils_SQLJDBC;
import cgm.simpleapp.utils.DBUtils;

@Path("products")//http://localhost:8080/MyFirstProject/rest/prodcuts
public class ProductService {
	
	
	//http://localhost:8080/MyFirstProject/rest/products/hello
	@Path("/hello")
	@GET
	public String hello() {
		return "Hello Baby!";
	}
	
	
	//http://localhost:8080/MyFirstProject/rest/products/all
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProduct(){
		List<Product> list = null;
		//tai su dung lai
		Connection conn;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			list = DBUtils.queryProduct(conn);//API
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//http://localhost:8080/MyFirstProject/rest/products/add
	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addProduct(Product product ) {
		Connection conn = null;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			DBUtils.insertProduct(conn, product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//http://localhost:8080/MyFirstProject/rest/products/edit/{code}
	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateProduct(Product product) {
		Connection conn = null;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			DBUtils.updateProduct(conn, product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//http://localhost:8080/MyFirstProject/rest/products/delete/{code}
	
	@DELETE
	@Path("/delete/{code}")
	public void deleteProduct(@PathParam("code") String code) {
		
		Connection conn = null;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
			DBUtils.deleteProduct(conn, code);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 } 
	
	

}
