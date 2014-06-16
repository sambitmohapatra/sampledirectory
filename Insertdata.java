package jdbcconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdata
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		try
		{

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sambitdatabase","root","tiger");
		Statement st=con.createStatement();
String qry="INSERT INTO `sambitdatabase`.`sample` (`idsample`, `name`) VALUES ('4', 'simran');";
int res=st.executeUpdate(qry);
if(res==0)
{
System.out.println("record not inserted");	
}
else
{
System.out.println("record inserted");	
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
