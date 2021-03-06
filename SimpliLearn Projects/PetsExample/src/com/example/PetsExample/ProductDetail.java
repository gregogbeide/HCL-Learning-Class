package com.example.PetsExample;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.PetsExample.model.DBConnection;


public class ProductDetail extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String id = request.getParameter("productId");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
            if(id == null || id.equals("") || !isValidNumber(id)){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProductDetail</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Product Id is required.</p>");          
                out.println("</body>");
                out.println("</html>");            
            }else{
               
                getProductDetail(id,out);
            }
        }
    }
    
    private boolean isValidNumber(String value){
        boolean result = false;
        try{
            Integer.parseInt(value);
            result = true;
        }catch(Exception e){
            
        }
        return result;
    }
    
    
    private void getProductDetail(String id, PrintWriter out) throws IOException{
          try {
        	
            out.println("<html><body>");
                 
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
                
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
        	Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rst = stmt.executeQuery("select * from products where id = " + Integer.parseInt(id));
            
            out.println("<p>Product id: " + id + "</p>");
            out.println("<table><tr><th>Name</th><th>Color</th><th>Price</th></tr>");
            
            boolean found = false;
            while (rst.next()) {
            	found = true;
                out.println("<tr><td>" + rst.getString("name") + "</td>" + "<td>" +
                		rst.getString("color") + "</td><td>" + rst.getBigDecimal("price") + "</td></tr>");
            }
            
            if(found == false) {
            	 out.println("<tr><td colspan='3'> No Record found.</td></tr>" );
            }
            
            out.println("</table>");
        
            stmt.close();        
   
        
            out.println("</body></html>");
            conn.closeConnection();
        
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }


}
