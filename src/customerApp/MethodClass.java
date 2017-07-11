package customerApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MethodClass {
	Scanner keyboard = new Scanner(System.in);
		String sql;
		int a;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
public void method1() {
		
		//System.out.println("Press (1) to search for another customer or press (2) to Edit the customer's address.");
		//a = keyboard.nextInt();
		//if (a == 1) {
		System.out.println("Please input customer's name");
		String name = keyboard.next();
		sql = "select * from customers where lastname = '" + name+"'";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
            con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1) + "\t");
		    //System.out.println(rs.getString(2));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//update Customers set firstname = 'Vanessa', lastname = 'Smith'	
}
public void method2() {
	
	System.out.println("Please input customer's lastname and firstname");
	String lastname = keyboard.next();
	String firstname = keyboard.next();
	keyboard.nextLine();
	sql = "select streetaddress from customers where lastname like '" + lastname+"' and firstname like '" + firstname +"'";
	//String sql2 = 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString(1) + "\t");
			//System.out.println(rs.getString(2));
		}
		System.out.println("Please input customer's new address");
		String streetAddress = keyboard.nextLine();
		sql = "update customers set streetaddress = '"+ streetAddress +"'"
				+ " where firstname = '" + firstname +"' and lastname = '"+ lastname +"'";
		System.out.println(sql);
		int numUp = stmt.executeUpdate(sql);
		System.out.printf("%d records updated\n",numUp);
		System.out.println("Your new address is " + streetAddress);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
	} 
	
	finally {
		try {
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
	public void method3() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        //con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
	        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			String total = "select count(*) from customers";
			rs = stmt.executeQuery(total);
			while(rs.next()){
				System.out.println(rs.getString(1) + "\t");
				//System.out.println(rs.getString(2));
			}
			//System.out.println("Please input customer's new address");
			//String streetAddress = keyboard.nextLine();
			
			//int numUp = stmt.executeUpdate(sql);
			//System.out.printf("%d records updated\n",numUp);
			//System.out.println("Your new address is " + streetAddress);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} 
		
		finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
