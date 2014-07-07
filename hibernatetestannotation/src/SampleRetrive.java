

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;

import java.util.*;

public class SampleRetrive
{
	public static void main(String[] args)throws Exception
	{
		Configuration conf = new Configuration().configure("persistence.xml");

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		SessionFactory sf = conf.buildSessionFactory(sr);

		Session ses = sf.openSession();


		 Query q2=(Query) ses.getNamedQuery("p2");
		((org.hibernate.Query) q2).setInteger(0,1);


		@SuppressWarnings("rawtypes")
		List l2=((org.hibernate.Query) q2).list();
		for(int i=0;i<l2.size();i++)
		{
		SampleBean s2=(SampleBean)l2.get(i);
		System.out.println("id is "+s2.getId());
		System.out.println("address is "+s2.getAddress());
		ses.close();
	}
}
}
