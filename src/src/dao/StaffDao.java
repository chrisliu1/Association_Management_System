/**   
* @Title: StaffDao.java 
* @Package DAO 
* @Description: 从数据库取得与员工有关的数据 
* @author wjliu1998@gmail.com
* @date 2017年1月25日 上午10:50:26 
* @version V1.0   
*/
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DbConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import managementclass.Staff;
import dao.DbClose;
/** 
* @ClassName: StaffDao 
* @Description: 员工类与数据库的交互
* @author wjliu1998@gmail.com
* @date 2017年1月25日 上午10:50:26 
*  
*/
public final class StaffDao {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static ObservableList<Staff> GetStaffList(String status)
	{
		//ArrayList<Staff> stafflist = new ArrayList<>();
		ObservableList<Staff> stafflist = FXCollections.observableArrayList();
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			if(status == null)
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from staff");
			}
			else
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from staff where staffposition = " + status);
			}
			if(rs != null)
			{
				while(rs.next())
				{
					String name = rs.getString(1);
					String password = rs.getString(2);
					String subject = rs.getString(3);
					String studentID = rs.getString(4);
					String position = rs.getString(5);
					String telnumber = rs.getString(6);
					Staff staff = new Staff(name, password, position, studentID, telnumber, subject);
					stafflist.add(staff);
				}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			DbClose.queryClose(stmt, rs, conn);
		}
		return stafflist;
	}
	
	public static Staff GetStaff(String studentID)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1:3306", "root", "*********");
		String name;
		String password;
		String subject;
		String position;
		String telnumber;
		Staff staff = null;
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from staff where studentnumber = " + studentID);
			if(rs != null)
			{
			while(rs.next())
			{
			name = rs.getString(1);
			password = rs.getString(2);
			subject = rs.getString(3);
			position = rs.getString(5);
			telnumber = rs.getString(6);
			staff = new Staff(name, password, position, studentID, telnumber, subject);
			}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			DbClose.queryClose(stmt, rs, conn);
		}
		return staff;
	}
	
	public static void UpdateStaff(String name, String password, String position, String studentID, String telnumber, String subject)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1:3306", "root", "*********");
		int judge = 0;
		try
		{
			stmt = conn.createStatement();
			judge = stmt.executeUpdate("update staff set staffname='"+name+"' where studentnumber="+studentID);
			judge = stmt.executeUpdate("update staff set staffpassword='"+password+"' where studentnumber="+studentID);
			judge = stmt.executeUpdate("update staff set staffposition='"+position+"' where studentnumber="+studentID);
			judge = stmt.executeUpdate("update staff set telnumber='"+telnumber+"' where studentnumber="+studentID);
			judge = stmt.executeUpdate("update staff set staffsubject='"+subject+"' where studentnumber="+studentID);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			DbClose.queryClose(stmt, rs, conn);
		}
	}
	
	public static void AddStaff(String name, String password, String position, String studentID, String telnumber, String subject)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1:3306", "root", "*********");
		int judge = 0;
		try
		{
			stmt = conn.createStatement();
			judge = stmt.executeUpdate("insert into staff values ('" + name + "','" + password + "','" + subject + "','" + studentID + "','" + position + "','" + telnumber + "')");
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			DbClose.queryClose(stmt, rs, conn);
		}
	}
	
	public static String GetName(String StudentID)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1:3306", "root", "*********");
		int judge = 0;
		String name = null;
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select staffname from staff where studentnumber='" + StudentID + "'");
			if(rs != null)
			{
				while(rs.next())
				{
					name = rs.getString(1);
				}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			DbClose.queryClose(stmt, rs, conn);
		}
		return name;
	}
}

