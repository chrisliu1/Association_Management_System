package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
* @ClassName: DbConn 
* @Description: 取得与数据库的连接 
* @author wjliu1998@gmail.com
* @date 2017年1月25日 上午10:54:40 
*
 */
public final class DbConn
{
	public static Connection getconn(String url, String user, String password)
	{
		//url = "jdbc:mysql://127.0.0.1:3306"
		//user = "root"
		//password = "*********"
		Connection conn = null;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}