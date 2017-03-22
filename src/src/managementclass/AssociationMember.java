package managementclass;

public class AssociationMember extends Member
{


	private int RemainTime;
	
	public AssociationMember(String name, String Password, String status, String StudentID, String TelNumber, String Subject, int RemainTime)
	{
		super(name, Password, status, StudentID, TelNumber, Subject);
		this.RemainTime = RemainTime;
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
	
	public int getRemainTime()
	{
		return this.RemainTime;
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
	
	public void changeRemainTime(int RemainTime)
	{
		this.RemainTime = RemainTime;
	}
}