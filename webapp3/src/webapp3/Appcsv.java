package webapp3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Servlet implementation class Appcsv
 */
@WebServlet("/Appcsv")
public class Appcsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appcsv() {
        super();
        // TODO Auto-generated constructor stub
    }

    Session ses=null;
	public void init()
	{
		Configuration conf = new Configuration().configure("/hibernate.cfg.xml");

ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

SessionFactory sf = conf.buildSessionFactory(sr);

ses = sf.openSession();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileWriter fw=new FileWriter("app.csv");
		PrintWriter pw=new PrintWriter(fw);
		//System.out.println("hiiiiho");
		Query q1=ses.createQuery("from EmpBean as eb1");
		@SuppressWarnings("rawtypes")
		List l1=q1.list();
		for(int i=0;i<l1.size();i++)
		{
			EmpBean eb1=(EmpBean)l1.get(i);
		pw.println(eb1.getId()+","+eb1.getAddress());
		
		
	}
		pw.close();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
