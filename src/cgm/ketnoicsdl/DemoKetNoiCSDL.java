package cgm.ketnoicsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoKetNoiCSDL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Ket NOi CSDL");
		
		Connection con;
		String user = "sa";
		String password = "123";
		
		String hostName = "localhost";
		
	     String sqlInstanceName = "SQLEXPRESS";
	     
	     String database = "QLSach";
		
		String url = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
