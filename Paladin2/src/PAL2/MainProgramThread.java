package PAL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import PAL2.Area.Room;
import PAL2.Character.Character;

public class MainProgramThread implements Runnable{
	public static Map<String,Integer> direction=new HashMap<String,Integer>();
    public static final String[] directions= { "east","west","south","north","up","down"};
    public static final int east=0,west=1,south=2,north=3,up=4,down=5;
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(input);
	Character character;
	    public MainProgramThread(Character character) {
	    	for(int s=0;s<directions.length;s++)
	    	{
	    	    direction.put(directions[s], s);
	    	}
           this.character=character;
	    }

	    @Override
	    public void run() {
	        while (true) {
				try {
					String a = reader.readLine();
					String[] command=a.split(" ");
					command[0]=commandfill(command[0]);
					for(int i=1;i<command.length;i++)
					{
						command[i]=targetfill(command[i]);
					}
					publiccommand(command);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	    public String targetfill(String target)
	    {
	    	for(int a=0;a<directions.length;a++)
	    	{
	    		//lookSystem.out.println(directioncommand[a]+"  "+command[0]);
	    		if(directions[a].startsWith(target))
	    		{
	    			target=directions[a];
	    			break;
	    		}
	    	}
	    	String[] areatarget;
	    	String[] charactertarget;
	    	return target;
	    }
	    public String commandfill(String command)
	    {
	    	for(int a=0;a<directions.length;a++)
	    	{
	    		//lookSystem.out.println(directioncommand[a]+"  "+command[0]);
	    		if(directions[a].startsWith(command))
	    		{
	    			command=directions[a];
	    			break;
	    		}
	    	}
	    	String[] commoncommand= {"look","open","close","kill","score","get","put","eat","drink","drop","wear","remove","say"};
	    	for(int a=0;a<commoncommand.length;a++)
	    	{
	    		//lookSystem.out.println(directioncommand[a]+"  "+command[0]);
	    		if(commoncommand[a].startsWith(command))
	    		{
	    			command=commoncommand[a];
	    			break;
	    		}
	    	}
	    	return command;
	    }
	    public void publiccommand(String[] command) 
	    {
	    	if(direction.containsKey(command[0]))
	    	{
	    		character.move(direction.get(command[0]));
	    	}
	    	switch(command[0]) 
	    	{
	    	case "look":
	    		if(command.length==1)
	    		{
	    			System.out.println(character.room.look(character));
	    		}
	    		else
	    		{
	    			System.out.println(character.look(command[1]));
	    		}
	    		break;
	    	case "open":
	    		if(command.length>1)
	    		{
	    			System.out.println(character.open(command[1]));
	    		}
	    		break;
	    	case "close":
	    		if(command.length>1)
	    		{
	    			System.out.println(character.close(command[1]));
	    		}
	    		break;
	    	}
	    }
}
