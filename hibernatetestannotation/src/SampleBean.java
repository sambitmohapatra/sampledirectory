import javax.persistence.*;

@Entity 
@Table(name="sambitdatabase.sample1")
@NamedNativeQuery(name="p2",query="select * from SampleBean sb where sb.id=?", resultClass=SampleBean.class)

public class SampleBean
{
	private long id;
	private String address;
	@Id
	@Column(name="idsample")
	public long getId()
	{
	return id;
	}
	@Column(name="address")
	public String getAddress()
	{
		return address;
	}
	public void setId(long id)
	{
		this.id=id;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}

}
