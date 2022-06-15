package banking_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transction {
	
	public static Connection c;
	
	public void deposit(String accNum, int amount) throws Exception{
		c=Connect.connet();
		PreparedStatement ps = c.prepareStatement("update account set balance = ? where accnum = ? ");
		int val = getBalance(accNum);
		ps.setInt(1, amount + val);
		ps.setString(2, accNum);
		ps.execute();
	}
	public int getBalance(String accNum) throws Exception{
		c=Connect.connet();
		ResultSet rs = c.prepareStatement("select balance from account where accnum = " + accNum).executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
	public void withdraw(String accNum, int amount) throws Exception{
		int val = getBalance(accNum);
		if(amount>val) {
			System.out.println("Insufficient balance");
		}else {
			PreparedStatement ps = c.prepareStatement("update account set balance = ? where accnum = ? ");
			ps.setInt(1, val-amount);
			ps.setString(2, accNum);
			ps.execute();
		}
	}
}
