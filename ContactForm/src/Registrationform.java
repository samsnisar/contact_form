

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registrationform extends HttpServlet {
	private static Connection conn;
	private static final long serialVersionUID = 1L;
       
   
    public Registrationform() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		String	s=request.getParameter("name");
		String	e=request.getParameter("email");
		BigDecimal big=new BigDecimal(request.getParameter("phone"));
		String	g=request.getParameter("gender");
		
		PreparedStatement ps=conn.prepareStatement("Insert into registrationform values(?,?,?,?)");
			ps.setString(1,s);
			ps.setString(2, e);
			ps.setBigDecimal(3, big);;
			ps.setString(4, g);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
