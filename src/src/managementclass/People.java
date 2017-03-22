package managementclass;
/**
 * 
* @ClassName: People 
* @Description: ��Ϊ������ĸ���
* @author wjliu1998@gmail.com
* @date 2017��1��8�� ����4:48:21 
*
 */
public class People
{
	private String name;
	private String status;
	private double ID;

	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: ����������</p> 
	* @param name
	* @param status
	 */
	public People(String name, String status)
	{
		this.name = name;
		this.status = status;
	}
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: ���ο�ʹ�õĹ�����</p> 
	* @param ID
	 */
	/*public People(double ID)
	{
		this.ID = ID;
	}*/
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: ����Աʹ�õĹ�����</p> 
	* @param name
	* @param status
	* @param StudentID
	* @param TelNumber
	* @param Subject
	 */
	/*public People(String name, String status, String StudentID, String TelNumber, String Subject)
	{
		this.name = name;
		this.status = status;
		this.studentID = studentID;
		this.TelNumber = TelNumber;
		this.Subject = Subject;
	}*/
	
	/**
	 * 
	* @Title: get** 
	* @Description: ����get����
	* @param @return   
	* @return String    
	* @throws
	 */
	public String getName()
	{
		return this.name;
	}
	
	public String getStatus()
	{
		return this.status;
	}

	/**
	 * 
	* @Title: change** 
	* @Description: ����change���� 
	* @param @param name  
	* @return void    
	* @throws
	 */
	public void changeName(String name)
	{
		this.name = name;
	}
	
	public void changeStatus(String status)
	{
		this.status = status;
	}
	

}