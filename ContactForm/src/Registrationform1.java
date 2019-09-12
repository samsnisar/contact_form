

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registrationform1 extends HttpServlet {
	private static Connection conn;
	private static final long serialVersionUID = 1L;
       
    
    public Registrationform1() {
        super();
      
    }

	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/practice","admin","admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String	s=request.getParameter("search");
		try {
			
			PreparedStatement ps=conn.prepareStatement("select * from registrationform where name= (?)");
			ps.setString(1, s);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			PrintWriter pw=response.getWriter();
			pw.println("<table align='center' border=1>");
			pw.println("<th>Name</th><th>email</th><th>phone</th><th>gender</th>");
			pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getBigDecimal(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			pw.println("</table>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
