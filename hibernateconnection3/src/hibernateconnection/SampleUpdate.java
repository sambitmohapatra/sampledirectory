package hibernateconnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class SampleUpdate {

	public static void main(String[] args)throws Exception
	{
		Configuration conf = new Configuration().configure();

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		SessionFactory sf = conf.buildSessionFactory(sr);

		Session ses = sf.openSession();
		

		Transaction tx=ses.beginTransaction();
		Long eno=new Long(4);
		SampleBean sb=(SampleBean)ses.load(SampleBean.class,eno);
		sb.setAddress("hyderabad");
		ses.save(sb);
		tx.commit();
		
		System.out.println("id is "+sb.getId());
		System.out.println("name is "+sb.getName());
		System.out.println("address is "+sb.getAddress());
		ses.close();
	}

}
