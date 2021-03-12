

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

import com.example.HibernateUtil;
import com.example.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        try {
             /*  SessionFactory factory = HibernateUtil.getSessionFactory();
               
               Session session = factory.openSession();
               // using HQL
               List<User> list = session.createQuery("from User", User.class).list();
               
               session.close();
               
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<b>User Listing</b><br>");
                for(User p: list) {
                        out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                        ", Email: " + String.valueOf(p.getEmail()) + ", Password: " + p.getPassword() + "<br>");
                }
                
            out.println("</body></html>");
            */
        	
        	request.getRequestDispatcher("user-registration.jsp").include(request, response);
            
        } catch (Exception ex) {
                throw ex;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset=\"UTF-8\"><title>User Registration Form Submission</title><body>");
        out.println("<b>Adding User</b> " + request.getParameter("name") + "<br>");

String name = request.getParameter("name");
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        
        if(name == null || name.equals("")){
            out.println("<p>Name is required.</p>");
        }else if(password == null || password.equals("")){
            out.println("<p>Password is required.</p>");
        }else if(emailAddress == null || emailAddress.equals("")){
            out.println("<p>Email Address is required.</p>");
        }else{
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(emailAddress);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();               
        try (Session session = factory.openSession()) {
            session.save(user);
        }

        out.println("<p>User added.</p>");
            
        }
        
   
        out.println("<br><a href=\"index.jsp\">Login</a> <br>");
        out.println("<a href='register'>Return to Registration Form</a><br>");
        out.println("</body></html>");

	}

}
