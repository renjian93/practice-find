package com.baldur.turbo.shame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{
		response.getWriter().println("contacts");
		response.getWriter().println("Get contact by id : "+request.getParameter("contactId"));

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch (Exception e){
		}

		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts?user=root&password=renjian");
			response.getWriter().println(connection);
			connection.close();
		}catch (SQLException sqle){
			response.getWriter().println("Can mot connect to DB");
			response.getWriter().println(sqle.getMessage());
			sqle.printStackTrace();
		}
	}
}
