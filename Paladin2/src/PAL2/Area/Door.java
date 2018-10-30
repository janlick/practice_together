package PAL2.Area;

import java.util.LinkedList;
import java.util.List;

import PAL2.MudObject;
import PAL2.Character.Character;

public class Door extends MudObject{

	public static final int nodoor = 0, open = 1, close = 2, lock = 3;
	boolean lockflag = false;
	Room roomconnect1, roomconnect2;
	public int doorstate = 0;

	public Door(Room roomconnect1, Room roomconnect2) {
		this.roomconnect1 = roomconnect1;
		this.roomconnect2 = roomconnect2;
	}

	public Door(Room roomconnect1, Room roomconnect2, int doorstate) {
		this.roomconnect1 = roomconnect1;
		this.roomconnect2 = roomconnect2;
		this.doorstate = doorstate;
	}

	public Door(Room roomconnect1, Room roomconnect2, int doorstate, String keyId) {
		super();
		this.roomconnect1 = roomconnect1;
		this.roomconnect2 = roomconnect2;
		this.doorstate = doorstate;
		this.keyId = keyId;
		lockflag = true;
	}

	public Room move(Room room, Character character) {
		if (room == roomconnect1) {
			roomconnect1.objectList.remove(character);
			roomconnect2.objectList.add(character);
			return roomconnect2;
		} else {
			roomconnect1.objectList.add(character);
			roomconnect2.objectList.remove(character);
			return roomconnect1;
		}

	}

	public String look(Room room, Character character) {
		if (doorstate < 2) {
			if (room == roomconnect1) {
				return roomconnect2.look(character);
			} else {
				return roomconnect1.look(character);
			}
		} else {
			return "這扇門被緊緊的關著";
		}

	}
	public String open(Room room) {
		if (doorstate == close) {
			doorstate =open;
            return "你打開了一扇門";
		} 
		else if(doorstate==open)
			return "你想試著打開一扇已經開著的門";
		else if(doorstate==nodoor)
			return "你想試著打開一扇不存在的門";
		else {
			return "你需要鑰匙來這扇被鎖住的門";
		}
	}
	public String close(Room room, Character character) {
		if (doorstate == 1) {
			doorstate =2;
            return character.Name+"關閉了一扇門";
		} else if(doorstate==0){
			return "這個方向沒有門喔";
		}
		else
		{
            return "這邊的門已經關著了";
		}
	}
	String keyId;

}
