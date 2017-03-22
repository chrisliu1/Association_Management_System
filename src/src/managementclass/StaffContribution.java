/**   
* @Title: StaffContribution.java 
* @Package manegementclass 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月11日 下午5:01:05 
* @version V1.0   
*/
package managementclass;

import dao.StaffDao;

/** 
* @ClassName: StaffContribution 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月11日 下午5:01:05 
*  
*/
public class StaffContribution 
{
	private String StudentID;
	private String Date;
	private String Contribution;
	private String Name;
	private String id;
	public StaffContribution(String id, String StudentID, String Date, String Contribution)
	{
		this.id = id;
		this.StudentID = StudentID;
		this.Date = Date;
		this.Name = StaffDao.GetName(StudentID);
		this.Contribution = Contribution;
	}
	
	public String getID()
	{
		return this.id;
	}
	public String getStudentID()
	{
		return this.StudentID;
	}
	
	public String getDate()
	{
		return this.Date;
	}
	
	public String getContribution()
	{
		return this.Contribution;
	}
	
	public String getName()
	{
		return this.Name;
	}
}
