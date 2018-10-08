package PAL2.Area;

import java.util.LinkedList;
import java.util.List;

import PAL2.MudObject;

public class Room extends MudObject{

	public List<Room> exitroom =new LinkedList<Room>();
	public Room() 
	{
		super();
		System.out.println(this.describe);
	}
}
