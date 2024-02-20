package app1;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Connection {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","Vaishu@sql");
			Statement smt = con.createStatement();
			smt.executeUpdate("CREATE TABLE CUSTOMERS1(\r\n"
					+ "   ID          INT NOT NULL,\r\n"
					+ "   NAME        VARCHAR (20) NOT NULL,\r\n"
					+ "   AGE         INT NOT NULL,\r\n"
					+ "   ADDRESS     CHAR (25),\r\n"
					+ "   SALARY      DECIMAL (18, 2),\r\n"
					+ "   PRIMARY KEY (ID)\r\n"
					+ ")");
			System.out.println("table created");
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
