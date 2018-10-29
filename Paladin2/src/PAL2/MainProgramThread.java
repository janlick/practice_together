package PAL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

import PAL2.Area.Room;

public class MainProgramThread implements Runnable{
    public static final int east=0,west=1,south=2,north=3,up=4,down=5;
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(input);
	Character character;
	    public MainProgramThread(Character character) {
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
	    	String[] directioncommand= {"east","west","north","south","up","down"};
	    	for(int a=0;a<directioncommand.length;a++)
	    	{
	    		//lookSystem.out.println(directioncommand[a]+"  "+command[0]);
	    		if(directioncommand[a].startsWith(target))
	    		{
	    			target=directioncommand[a];
	    			break;
	    		}
	    	}
	    	String[] areatarget;
	    	String[] charactertarget;
	    	return target;
	    }
	    public String commandfill(String command)
	    {
	    	String[] directioncommand= {"east","west","north","south","up","down"};
	    	for(int a=0;a<directioncommand.length;a++)
	    	{
	    		//lookSystem.out.println(directioncommand[a]+"  "+command[0]);
	    		if(directioncommand[a].startsWith(command))
	    		{
	    			command=directioncommand[a];
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
	    	case "east":
	    		if(command.length==1)
	    		{
	    			character.move(east);
	    		}
	    		break;
	    	case "west":
	    		if(command.length==1)
	    		{
	    			character.move(west);
	    		}
	    		break;
	    	case "south":
	    		if(command.length==1)
	    		{
	    			character.move(south);
	    		}
	    		break;
	    	case "north":
	    		if(command.length==1)
	    		{
	    			character.move(north);
	    		}
	    		break;
	    	case "up":
	    		if(command.length==1)
	    		{
	    			character.move(up);
	    		}
	    		break;
	    	case "down":
	    		if(command.length==1)
	    		{
	    			character.move(down);
	    		}
	    		break;
	    	case "open":
	    		if(command.length==2)
	    		{
	    			System.out.println(character.open(command[1]));
	    		}
	    		break;
	    	
	    	}
	    }
}
