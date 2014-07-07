package webapp3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.JSONException;
//import org.json.JSONObject;

/**
 * Servlet implementation class Appjson
 */
@WebServlet("/Appjson")
public class Appjson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appjson() {
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
		Query q1=ses.createQuery("from EmpBean as eb1");
		@SuppressWarnings("rawtypes")
		List l1=q1.list();
		JSONArray ja= new JSONArray();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for(int i=0;i<l1.size();i++)
		{
			EmpBean eb1=(EmpBean)l1.get(i);
			JSONObject obj = new JSONObject();

			
				try {
					obj.put("id",eb1.getId());
					obj.put("address", eb1.getAddress());
					jsonList.add(obj);
				}
				 catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		ja.put(jsonList);
		
	System.out.print(ja);
	FileWriter fw=new FileWriter("app.json");
	PrintWriter pw=new PrintWriter(fw);
	pw.println(ja);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	public void destroy()
	{
		ses.close();
	}
}
