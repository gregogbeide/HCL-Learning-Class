package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.Product;
import java.math.BigDecimal;


/**
 * Servlet implementation class PetsServlet
 */
public class PetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
        try {
               SessionFactory factory = HibernateUtil.getSessionFactory();
               
               Session session = factory.openSession();
               // using HQL
               List<Product> list = session.createQuery("from Product", Product.class).list();
               
               session.close();
               
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<b>Product Listing</b><br>");
                for(Product p: list) {
                        out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                        ", Price: " + String.valueOf(p.getPrice()) + ", Color: " + p.getColor().toString() + "<br>");
                }
                
            out.println("</body></html>");
            
            
        } catch (Exception ex) {
                throw ex;
        }

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Adding Pet</b> " + request.getParameter("name") + "<br>");
                      
            String name = request.getParameter("name");
            String color = request.getParameter("color");
            String price = request.getParameter("price");
            
            if(name == null || name.equals("")){
                out.println("<p>Product name is required.</p>");
            }else if(color == null || color.equals("")){
                out.println("<p>Product color is required.</p>");
            }else if(price == null || price.equals("")){
                out.println("<p>Product price is required.</p>");
            }else{
                                  
            Product product = new Product();
            product.setName(name);
            product.setColor(color);
            product.setPrice(new BigDecimal(price));
            //product.setID(5);
                       
            
            SessionFactory factory = HibernateUtil.getSessionFactory();               
            try (Session session = factory.openSession()) {
                session.save(product);
            }

            out.println("<p>Product added.</p>");
                
            }
            
            out.println("<a href='addpet.jsp'>Add New Pet</a><br>");
            out.println("<a href='index.jsp'>Return to Main</a><br>");
            out.println("</body></html>");
                
	}
}
