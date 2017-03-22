package dao;

import java.sql.*;

public final class DbClose
{
	public static void addClose(Statement stmt, Connection conn)
	{
		try
		{
			if(stmt != null)
			{
				stmt.close();
			}
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		}catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public static void queryClose(Statement stmt, ResultSet rs, Connection conn)
	{
		try
		{
			if (stmt != null)
			{
				stmt.close();
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (rs != null )
			{
				rs.close();
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}