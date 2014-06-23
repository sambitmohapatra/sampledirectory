package hibernateconnection;


import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SampleInsert
{
	public static void main(String[] args)
	{
		Configuration conf = new Configuration().configure("/hibernate.cfg.xml");

ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

SessionFactory sf = conf.buildSessionFactory(sr);

Session ses = sf.openSession();

		
		Transaction tx=ses.beginTransaction();
		SampleBean sb=new SampleBean();
		sb.setId(4);
		sb.setAddress("mumbai");
		sb.setName("sahajahan");
		ses.save(sb);
		tx.commit();
		ses.close();
	}

}
