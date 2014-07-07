package strutsapp1;

import javax.servlet.annotation.WebServlet;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;

/**
 * Servlet implementation class Info
 */
@WebServlet("/Info")
public class Info extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private int teno;
	
	public int getTeno()
	{
	return teno;
	}
	public void setTeno(int teno)
	{
		this.teno=teno;
	}
	
	public int getId()
	{
	return id;
	}
	public String getAddress()
	{
		return address;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String execute()
	{
		String Driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sambitdatabase";
        String uName ="root";
        String pwd = "tiger";
        Connection conn=null;
 
        
            try {
				Class.forName(Driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				conn = DriverManager.getConnection(url, uName, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Statement stmt = null;
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            int ido =this.teno; //inf3.inf();
            ResultSet rs = null;
			try {
				rs = stmt.executeQuery("SELECT * FROM sambitdatabase.sample1 WHERE idsample ='"+ido+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				while (rs.next()) 
				{
				    id= rs.getInt("idsample");
				    address= rs.getString("address");
				    
					
				
}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return SUCCESS;

}}
