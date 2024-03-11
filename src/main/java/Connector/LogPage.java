package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class LogPage {
	static String dbUrl="jdbc:mysql://localhost:3306/final_db";
	static String dbUsername="root";
	static String dbPassword="";
	static String dbDriver="com.mysql.cj.jdbc.Driver";
	static String mail_id,pass;
	static Connection con=null;
	public LogPage(String user_id,String pass_id)
	{
		mail_id=user_id;
		pass=pass_id;
	}
	public void signup()
	{
		try {
			Class.forName(dbDriver);
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String sql="INSERT INTO user_check VALUES ('"+mail_id+"','"+pass+"');";
			//System.out.println("connected");
			Statement s=con.createStatement();
			s.executeUpdate(sql);
			con.close();	
		}
		catch (Exception e)
		{
			System.out.print("error"+e);
		}
	}
	public boolean signin() {
	    try {
	        Class.forName(dbDriver);
	        con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	        String sql = "SELECT username, Password FROM user_check WHERE username='"+mail_id+"'AND Password='"+pass+"';";
	        Statement s=con.createStatement();
			ResultSet res=s.executeQuery(sql);
			if(res.next())
			{
				con.close();
				return true;
			}
			else
			{
				con.close();
				return false;
			}
	        
	    } catch (Exception e) {
	        System.out.print("error" + e);
	    }
		return false;
	}

}
