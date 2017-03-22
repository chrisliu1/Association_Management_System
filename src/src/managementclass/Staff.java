package managementclass;

public class Staff extends Member
{
	private String Position;
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param name
	* @param status
	* @param StudentID
	* @param TelNumber
	* @param Subject 
	*/
	
	
	public Staff(String name, String Password, String status, String StudentID, String TelNumber, String Subject) {
		super(name, Password, status, StudentID, TelNumber, Subject);
	}
	
	public String getPassword()
	{
		return super.getPassword();
	}
	public String getName()
	{
		return super.getName();
	}
	
	public String getStatus()
	{
		return super.getStatus();
	}
	
	public String getStudentID()
	{
		return super.getStudentID();
	}
	
	public String getSubject()
	{
		return super.getSubject();
	}
	
	public String getTelNumber()
	{
		return super.getTelNumber();
	}
	

	public void changeName(String name)
	{
		super.changeName(name);
	}
	
	public void changeStatus(String status)
	{
		super.changeStatus(status);
	}
	
	public void changeStudentID(String studentID)
	{
		super.changeStudentID(studentID);
	}
	
	public void changeSubject(String Subject)
	{
		this.changeSubject(Subject);
	}
	
	public void changeTelNumber(String TelNumber)
	{
		this.changeTelNumber(TelNumber);
	}
	

	
	public void changePassword(String Password)
	{
		super.changePassword(Password);
	}
}