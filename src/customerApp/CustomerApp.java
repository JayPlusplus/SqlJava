package customerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class CustomerApp {
	public static void main(String[] args) {
		
		MethodClass obj = new MethodClass();
		String tot;
		int a;
		System.out.println("Press (1) to search for another customer or press (2) to Edit the customer's address.");
		Scanner keyboard=new Scanner(System.in);
		a = keyboard.nextInt();
		if (a == 1) {
		   obj.method1();
		//update Customers set firstname = 'Vanessa', lastname = 'Smith'
	}			//  where firstname = 'Vanesa' and lastname = 'Brown';
		if (a == 2) {
			obj.method2();
				
		}
		
		System.out.println("enter 'total' if you want to find "
				+ "the numbers of customers");
		tot = keyboard.next();
		if (tot.equals("total")) {
			obj.method3();
		}
	}
}
