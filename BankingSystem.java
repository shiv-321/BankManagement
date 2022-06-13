package banking_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. New user");
			System.out.println("2. Existing user");
			System.out.println("Enter your choice:(1 or 2");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice == 1) {
				System.out.println("Enter your name");
				String name = sc.nextLine();
				System.out.println("Create password");
				String password = sc.nextLine();
				System.out.println("Please confirm your password");
				String confirmPassword = sc.nextLine();
				if(password.equals(confirmPassword)) {
					Utils util = new Utils();
					String accNum = util.accountNumber();
					System.out.println("Your account is created");
					System.out.println("Your account Number is: " + accNum);
					
					
				}else {
					System.out.println("Password not matching");
				}
			}
		
//			Connection connect = Connect.connet();
//			PreparedStatement ps = connect.prepareStatement("insert into customer (name, password) values (?,?)");
			// yy mm dd
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
