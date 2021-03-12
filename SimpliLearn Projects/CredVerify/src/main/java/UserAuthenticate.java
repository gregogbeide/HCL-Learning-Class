

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.User;

/**
 * Servlet implementation class UserAuthenticate
 */
@WebServlet
public class UserAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            
            if(name == null || name.equals("")){
                out.println("<p>Username is required.</p>");
            }else if(pass == null || pass.equals("")){
                out.println("<p>Password is required.</p>");
            }else{
         	   
            
	               Query query = session.createQuery("from User u where name = ?1 and password = ?2",User.class);
	               query.setParameter(1, name);
	               query.setParameter(2, pass);
	               User u = null;
	               try {
	            	   u = (User) query.getSingleResult();
	               }catch(Exception e) {}
	               
	               session.close();               
	              	               
	               if(u != null) {
	            	   out.println("<b>User Authenticated</b><br>");
	            	   out.println("<br><a href=\"index.jsp\">Logout</a> <br>");
	               }else {
	            	   
	            	   out.println("<p>Error: Unable to authenticate. Please try again</p>");
	            	   out.println("<br><a href=\"index.jsp\">Login</a> <br>");
	               }
            }
            
         out.println("</body></html>");
         
         
     } catch (Exception ex) {
             throw ex;
     }
	}

}
