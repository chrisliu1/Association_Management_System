/**   
* @Title: ItemDao.java 
* @Package dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午10:14:18 
* @version V1.0   
*/
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import managementclass.Item;

/** 
* @ClassName: ItemDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午10:14:18 
*  
*/
public class ItemDao {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static ObservableList<Item> GetItemList()
	{
		ObservableList<Item> itemlist = FXCollections.observableArrayList();
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from item");
			if(rs != null)
			{
				while(rs.next())
				{
					String itemname = rs.getString(1);
					int cost = rs.getInt(2);
					int price = rs.getInt(3);
					int remainnumber = rs.getInt(4);
					Item item = new Item(itemname, cost, price, remainnumber);
					itemlist.add(item);
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
		return itemlist;
	}
	
	public static ObservableList<String> GetItemNameList()
	{
		ObservableList<String> itemNameList = FXCollections.observableArrayList();
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select itemname from item");
			while(rs.next())
			{
				itemNameList.add(rs.getString(1));
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
		return itemNameList;
	}
	
	public static void UpdateItemState(String itemName, int amount)
	{
		conn = DbConn.getconn("jdbc:mysql://127.0.0.1", "root", "*********");
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select remainnumber from item where itemname = '" + itemName + "'");
			rs.next();
			int remainnumber = rs.getInt(1);
			@SuppressWarnings("unused")
			int state = stmt.executeUpdate("update item" + " set remainnumber=" + (remainnumber+amount) + " where itemname='" + itemName + "'");
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
