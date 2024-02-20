package app1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class JDBC_Insert {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","Vaishu@sql");
			PreparedStatement st = con.prepareStatement("insert into CUSTOMERS values(?, ?, ? ,?, ?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("enter emp id : ");
				int ID = Integer.parseInt(br.readLine());
				
				System.out.println("enter emp name:");
				String NAME = br.readLine();
				
				System.out.println("enter emp AGE : ");
				int AGE = Integer.parseInt(br.readLine());
				
				System.out.println("enter emp ADDRESS : ");
				String ADDRESS = (br.readLine());
				
				System.out.println("enter emp SALARY : ");
				double SALARY = Double.parseDouble(br.readLine());
				
				st.setInt(1,  ID);
				st.setString(2,  NAME);
				st.setInt(3, AGE);
				st.setString(4, ADDRESS);
				st.setDouble(5, SALARY);
				int count = st.executeUpdate();
				if(count>0)
				{
					System.out.println(count+"recorded inserted");
				}
				else
				{
					System.out.println("no recorder inserted");
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
