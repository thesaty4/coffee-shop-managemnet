package coffee_shop;
import java.sql.*;
/*
 * @author Satya Narayan Mishra
 */

public class connection{
	Connection cn;
	Statement stm;
	connection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_shop", "root", "");
			stm = cn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		new connection();
	}
}

