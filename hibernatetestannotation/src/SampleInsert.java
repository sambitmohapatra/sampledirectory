


import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.HibernateException;

public class SampleInsert
{
	public static void main(String[] args)throws Exception
	{
		Configuration conf = new Configuration().configure("/hibernate.cfg.xml");

ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

SessionFactory sf = conf.buildSessionFactory(sr);

Session ses = sf.openSession();

		
		Transaction tx=ses.beginTransaction();
		SampleBean sb=new SampleBean();
		//sb.setId(3);
	sb.setAddress("sri");
	ses.save(sb);
		tx.commit();
		ses.close();
	}

}
