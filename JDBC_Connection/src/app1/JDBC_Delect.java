package app1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBC_Delect {

	public static void main(String[] args) {

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","Vaishu@sql");
			Statement st = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("enter emp id : ");
				int ID = Integer.parseInt(br.readLine());
				
				
				int count = st.executeUpdate("delete from CUSTOMERS where ID ="+ID);
				if(count==1)
				{
					System.out.println(count+"recorded deleted");
				}
				else
				{
					System.out.println("no recorder deleted");
				}
				System.out.println("do you want to insert again records....");
				String ch = br.readLine();
				if(ch.equalsIgnoreCase("no"));
				break;
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}
}
