package PAL2.Area;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

import PAL2.MudObject;
import PAL2.Character.Character;

public class Room extends MudObject{
	public String[] way= {"東","西","南","北","上","下"};
    public static final int east=0,west=1,south=2,north=3,up=4,down=5;
	public Door[] doorArray =new Door[6];
	public List<MudObject> objectList=new LinkedList<MudObject>();
	public JSONArray exitroomjb;

	public Room(String Name, String Id, String describe, String shortDescribe,JSONArray exitroomjb) {
		super(Name, Id, describe, shortDescribe);
		this.exitroomjb = exitroomjb;
		// TODO Auto-generated constructor stub
	}
	public String look(Character character) 
	{
		String returnstring=describe+"\n 明顯的出口有:<";
		for (int a=0;a<6;a++)
		{
			if(doorArray[a]!=null&&doorArray[a].doorstate<2)
				returnstring+=way[a]+",";
			
		}
		returnstring+=">\n";
		for(MudObject mo : objectList)
		{
			if(mo==character)
			{
			    returnstring+="你<"+mo.Name+"> 正站在這裡\n";
			}
			else
			{
			    returnstring+=mo.shortDescribe+"<"+mo.Name+"> 站在這裡\n";
			}
		}
		return returnstring;
	}
}
