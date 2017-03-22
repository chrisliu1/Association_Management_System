/**   
* @Title: Item.java 
* @Package managementclass 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午10:06:02 
* @version V1.0   
*/
package managementclass;

/** 
* @ClassName: Item 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午10:06:02 
*  
*/
public class Item {
	private String itemname;
	private int cost;
	private int price;
	private int remainnumber;
	
	public Item(String itemname, int cost, int price, int remainnumber)
	{
		this.itemname = itemname;
		this.cost = cost;
		this.price = price;
		this.remainnumber = remainnumber;
	}
	
	public String getItemname()
	{
		return this.itemname;
	}
	
	public int getCost()
	{
		return this.cost;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public int getRemainnumber()
	{
		return this.remainnumber;
	}
	
	public void setItemname(String itemname)
	{
		this.itemname = itemname;
	}
	
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setRemainnumber(int remainnumber)
	{
		this.remainnumber = remainnumber;
	}
	
}
