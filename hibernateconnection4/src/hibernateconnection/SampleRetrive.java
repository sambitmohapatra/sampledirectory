package hibernateconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;

public class SampleRetrive
{
	public static void main(String[] args)throws Exception
	{
		Configuration conf = new Configuration().configure();

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		SessionFactory sf = conf.buildSessionFactory(sr);

		Session ses = sf.openSession();

		Long eno=new Long(2);
		SampleBean sb=(SampleBean)ses.load(SampleBean.class,eno);
		
		System.out.println("id is "+sb.getId());
		System.out.println("name is "+sb.getName());
		System.out.println("address is "+sb.getAddress());
		ses.close();
	}
}
