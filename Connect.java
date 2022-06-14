package banking_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection connet() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "shivaraj1", "jstmaself");
			System.out.println("Connected");
			return c;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	

}
