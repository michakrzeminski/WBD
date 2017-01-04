import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {
	
	public JDBCConnection()  
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##wbd","wbdproject");
			Statement st = con.createStatement();
			String sql = "select * from PRACOWNIK";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
				System.out.println(rs.getInt(1)+ "   " + rs.getString(2)+ "   " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
