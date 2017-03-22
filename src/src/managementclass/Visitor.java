package managementclass;
/**
 * 
* @ClassName: Visitor 
* @Description: �ο���
* @author wjliu1998@gmail.com
* @date 2017��1��8�� ����4:51:04 
*
 */
public class Visitor extends People
{
	private String ID;
	
	public Visitor(String ID)
	{
		super(null, null);
		this.ID = ID;
	}
	
	public String getID()
	{
		return this.ID;
	}
}