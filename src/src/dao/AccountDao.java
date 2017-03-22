/**   
* @Title: AccountDao.java 
* @Package dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月4日 下午5:17:47 
* @version V1.0   
*/
package dao;
import managementclass.StaffContribution;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** 
* @ClassName: AccountDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月4日 下午5:17:47 
*  
*/
public class AccountDao {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static ObservableList<StaffContribution> GetStaffContribution(String StudentID, String Date)
	{
		ObservableList<StaffContribution> stafflist = FXCollections.observableArrayList();
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			if(StudentID == null && Date == null)
			{

				rs = stmt.executeQuery("select * from membersalary");
			}
			else if(StudentID != null && Date == null)
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from staff where staffposition='" + StudentID + "'");
			}
			else if(StudentID == null && Date == null)
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from staff where contributiondate='" + Date + "'");
			}
			else
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from staff where contributiondate='" + Date + "'&& studentnumber='" + StudentID + "'");
			}
			if(rs != null)
			{
				while(rs.next())
				{
					String id = rs.getString(1);
					String studentID = rs.getString(2);
					String date = rs.getString(3);
					String contribution = rs.getString(4);
					StaffContribution staffContribution = new StaffContribution(id, studentID, date, contribution);
					stafflist.add(staffContribution);
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
	
	public static void UpdateContribution(String id, String new_studentid, String new_date, String new_contribution)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int judge;
			judge = stmt.executeUpdate("update membersalary set studentnumber='" + new_studentid + "', contributiondate='" + new_date + "', contribution='" + new_contribution +"' where id=" + id);
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
	
	public static void AddContribution(String studentid, String date, String contribution)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int judge;
			judge = stmt.executeUpdate("insert into membersalary (studentnumber, contributiondate, contribution) values ('" + studentid + "', '" + date + "', '" + contribution + "')");
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
}
