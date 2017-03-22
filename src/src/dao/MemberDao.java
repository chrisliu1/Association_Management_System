/**   
* @Title: MemberDao.java 
* @Package dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月12日 下午4:12:19 
* @version V1.0   
*/
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import managementclass.AssociationMember;
import managementclass.Staff;

/** 
* @ClassName: MemberDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月12日 下午4:12:19 
*  
*/
public final class MemberDao {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static ObservableList<AssociationMember> GetMemberList()
	{
		//ArrayList<Staff> stafflist = new ArrayList<>();
		ObservableList<AssociationMember> memberlist = FXCollections.observableArrayList();
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			if(rs != null)
			{
				while(rs.next())
				{
					String name = rs.getString(1);
					String subject = rs.getString(2);
					String studentID = rs.getString(3);
					String telnumber = rs.getString(4);
					int remaintime = rs.getInt(5);
					AssociationMember member = new AssociationMember(name, null, null, studentID, telnumber, subject, remaintime);
					memberlist.add(member);
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
		return memberlist;
	}
	
	/*public static Staff GetStaff(String studentID)
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
	}*/
	
	public static void AddMember(String name,  String studentID, String telnumber, String subject, Integer remaintime)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1:3306", "root", "*********");
		int judge = 0;
		try
		{
			stmt = conn.createStatement();
			judge = stmt.executeUpdate("insert into member values ('" + name + "','" + subject + "','" + studentID + "','" + telnumber + "','" + remaintime + "')");
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
	
	/*public static String GetName(String StudentID)
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
	}*/
}
