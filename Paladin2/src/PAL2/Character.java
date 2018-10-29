package PAL2;

import PAL2.Area.Door;
import PAL2.Area.Room;

public class Character extends MudObject {
    public static final int east=0,west=1,south=2,north=3,up=4,down=5;
	public static final int HEAD=0,NEAK=1,UPPERBODY=2,SHOLDER=3,ARM=4,HAND=5,FINGER=6,LOWERBODY=7,KNEE=8,FEET=9;
	Equipment[] equipment= new Equipment[10];
	int maxhp,maxmp,maxmv;
	int hp,mp,mv;
	int rhp,rmp,rmv;
	Room room;
	public Character(String Name, String Id, String describe, String shortDescribe, Equipment[] equipment, int maxhp,
			int maxmp, int maxmv,Room room) {
		super(Name, Id, describe, shortDescribe);
		this.equipment = equipment;
		this.maxhp = maxhp;
		this.maxmp = maxmp;
		this.maxmv = maxmv;
		this.room = room;
	}
	public Character(String Name, String Id, String describe, String shortDescribe) {
		super(Name, Id, describe, shortDescribe);
		// TODO Auto-generated constructor stub
	}
    public String look(String command)
    {
    	switch(command) 
    	{
    	case "east":
    		return room.doorArray[east].look(room, this);
    	case "west":
    		return room.doorArray[west].look(room, this);
    	case "south":
    		return room.doorArray[south].look(room, this);
    	case "north":
    		return room.doorArray[north].look(room, this);
    	case "up":
    		return room.doorArray[up].look(room, this);
    	case "down":
    		return room.doorArray[down].look(room, this);
    	}
    	return "你看不到那樣東西";
    }
    public String open(String command)
    {
    	switch(command) 
    	{
    	case "east":
    		return room.doorArray[east].open(room, this);
    	case "west":
    		return room.doorArray[west].open(room, this);
    	case "south":
    		return room.doorArray[south].open(room, this);
    	case "north":
    		return room.doorArray[north].open(room, this);
    	case "up":
    		return room.doorArray[up].open(room, this);
    	case "down":
    		return room.doorArray[down].open(room, this);
    	}
    	return "你想要打開什麼呢?";
    }
    public void move(int direct)
    {
    	Door door=room.doorArray[direct];
    	if(door!=null)
    	{
    		if(door.doorstate<2)
    		{
    			room=door.move(room,this);
    			System.out.println(this.room.look(this));
    		}
    		else
    		{
        		System.out.println("這個方向的門是關著的");
    		}
    	}
    	else 
    	{
    		System.out.println("這個方向沒有路喔!!");
    	}
    }
	
	

}
