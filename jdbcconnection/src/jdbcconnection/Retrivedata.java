package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrivedata {

	public static void main(String[] args)throws ClassNotFoundException
	{
		try
		{

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdatabase","root","tiger");
		Statement st=con.createStatement();
String qry="SELECT * FROM sambitdatabase.sample;";
ResultSet rs=st.executeQuery(qry);
while(rs.next()!=false)
{
System.out.println(rs.getInt(1)+""+rs.getString(2));	
}
st.close();
con.close();
		}
		catch(SQLException se)
			{
				se.printStackTrace();
			}

	}

}