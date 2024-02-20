package app1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBC_Udate {

	public static void main(String[] args) throws Exception{
		String value;
		int eid;
		double esal;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","Vaishu@sql");
			Statement st = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
				System.out.println("enter emp id : ");
				value = br.readLine();
				int ID = Integer.parseInt(value);
				
				System.out.println("enter emp new SALARY : ");
				value = br.readLine();
				double SALARY = Double.parseDouble(value);
				
				int count = st.executeUpdate("udate CUSTOMERS set SALARY = "+SALARY+" where ID = "+ID);
				if(count>0)
				{
					System.out.println(count+"recorded changed inserted");
				}
				else
				{
					System.out.println("no recorder found");
				}
			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
