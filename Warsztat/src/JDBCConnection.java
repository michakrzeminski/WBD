import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	
	Connection con;
	
	public JDBCConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##wbd","wbdproject");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeConn() throws SQLException {
		this.con.close();
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		try {
			Statement st = this.con.createStatement();
			String sql = query;
			rs = st.executeQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
