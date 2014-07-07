package webapp3;


public class EmpBean implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//not required in this program,here just not to get the warning to avoid the problem during deserialization
	private int id;
	private String address;
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

}
