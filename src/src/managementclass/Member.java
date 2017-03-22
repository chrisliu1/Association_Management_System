package managementclass;


public class Member extends People
{
	private String studentID;
	private String TelNumber;
	private String Subject;
	private String Password;
	
	public Member(String name, String Password, String status, String StudentID, String TelNumber, String Subject)
	{
		super(name, status);
		this.Password = Password;
		this.studentID = StudentID;
		this.TelNumber = TelNumber;
		this.Subject = Subject;
	}
	
	public String getPassword()
	{
		return this.Password;
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
		return this.studentID;
	}
	
	public String getSubject()
	{
		return this.Subject;
	}
	
	public String getTelNumber()
	{
		return this.TelNumber;
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
		this.studentID = studentID;
	}
	
	public void changeSubject(String Subject)
	{
		this.Subject = Subject;
	}
	
	public void changeTelNumber(String TelNumber)
	{
		this.TelNumber = TelNumber;
	}
	public void changePassword(String Password)
	{
		this.Password = Password;
	}
}