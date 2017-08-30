/**
 * @author Doctor_
 * 2017-3-11  	下午1:38:40
 */
package page_flip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBCUtils {
	
private Connection conn=null;
//private PreparedStatement pstmt=null; 
/**
* connect 连接数据库
* @return
*/
public Connection connect(){
	String user="root";
	String password="yudeqq814";
	String driverClass = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost:3306/jokes";
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
}
/**
* close 关闭数据库
* @param conn
* @param pstmt
* @param resu
*/
public void close(Connection conn,PreparedStatement pstmt,ResultSet result){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result != null){
			try {
				result.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
