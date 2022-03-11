package cgm.ketnoicsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiCSDL_JTDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello Ket NOi CSDL");
		
		Connection con = null;
		String user = "sa";
		String password = "123";
		
		String hostName = "localhost";
		
	     String sqlInstanceName = "SQLEXPRESS";
	     
	     String database = "QLSach";
		
		//String url = "jdbc:jtds:sqlserver://" + hostName + ":1433"
	      //       + ";instance=" + sqlInstanceName + ";databaseName=" + database;
		
		String url = "jdbc:jtds:sqlserver://" + hostName + ":1433/"
	             + database + ";instance=" + sqlInstanceName;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM PRODUCT";
			
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Code: " + rs.getString("CODE"));
				System.out.println("Name: " + rs.getString("NAME"));
				System.out.println("Price: " + rs.getFloat("PRICE"));
			}
			
			System.out.println(con.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
