package app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Select {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Vaishu@sql");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from CUSTOMERS");
			while(rs.next())
			{
				int ID = rs.getInt(1);
				
				String NAME = rs.getString(2);
				
				int AGE = rs.getInt(3);
				
				String ADDRESS = rs.getString(4);
				
				double SALARY = rs.getDouble(5);
				
				System.out.print(ID +" ,"+NAME +" ,"+ AGE +", "+ADDRESS+" ,"+SALARY);
				System.out.println();
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
