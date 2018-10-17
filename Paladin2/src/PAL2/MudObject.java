package PAL2;

public class MudObject {

	public String Name;
	public String Id;
	public String describe;
	public String shortDescribe;
	public MudObject() {}
	public MudObject(String Name,String Id,String describe,String shortDescribe)
	{
		this.Name=Name;
		this.Id=Id;
		this.describe=describe;
		this.shortDescribe=shortDescribe;
	}
	public String shortDescribe() 
	{
		return shortDescribe;
	}
	public String describe()
	{
		return describe;
	}
}
