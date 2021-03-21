import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataBase
 */
public class DataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
    * @see HttpServlet#HttpServlet()
     */
	Connection con;
    public DataBase() {
        super();
        String user_name="system";
		String password ="admin";
    try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user_name,password);
}

catch
	(Exception e)		
	{
		e.printStackTrace();
}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String sname=request.getParameter("username");
		String fname=request.getParameter("fathername");
	    int age=Integer.parseInt(request.getParameter("age"));
	    String Password=request.getParameter("pname");
	   String Gender=request.getParameter("gender");
		String Email=request.getParameter("email");
		long phoneno=Long.parseLong(request.getParameter("phone"));
		
	    PrintWriter out=response.getWriter();
	    out.println("<html><body style=\"background-color:powderblue;\">");
	    out.println(""+"<b>Username is :</b>"+""+sname);
	    out.println("<br><br>");
	    out.println(""+"<b>Fathername is :</b>"+""+fname);
	    out.println("<br><br>");
	    out.println(""+"<b>Myage is :</b>"+""+age);
	    out.println("<br><br>");
	    out.println(""+"<b>Password is :</b>"+""+Password);
	    out.println("<br><br>");
	    out.println(""+"<b>Gender is:</b>"+""+Gender);
	    out.println("<br><br>");
	    out.println(""+"<b>EmailId`is :</b>"+""+Email);
	    out.println("<br><br>");
	    out.println(""+"<b>MobileNumber`is :</b>"+""+phoneno);
	    out.println("<br><br>");
	    out.println("</html></body>");
	   try {
		   PreparedStatement pst=con.prepareStatement("insert into registationform values(?,?,?,?,?,?,?)");  
	   pst.setString(1,sname);
	   pst.setString(2,fname);
	   pst.setInt(3,age);
	   pst.setString(4,Password);
	   pst.setString(5,Gender);
	   pst.setString(6,Email);
	   pst.setLong(7,phoneno);
	   int numb=pst.executeUpdate();
	   System.out.println("the number of rows updated"+numb); 
	   con.close();
	}
catch (Exception e1) {
	e1.printStackTrace();

}
	   }
	}