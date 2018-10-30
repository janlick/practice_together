package PAL2.Character;

import PAL2.MainProgramThread;
import PAL2.MudObject;
import PAL2.Area.Door;
import PAL2.Area.Room;
import PAL2.Item.Equipment;

public class Character extends MudObject {
	public static final int stand =0, sit=1,sleep=2;
	public static final int east = 0, west = 1, south = 2, north = 3, up = 4, down = 5;
	public static final int HEAD = 0, NEAK = 1, UPPERBODY = 2, SHOLDER = 3, ARM = 4, HAND = 5, FINGER = 6,
			LOWERBODY = 7, KNEE = 8, FEET = 9;
	Equipment[] equipment = new Equipment[10];
	
	int maxhp, maxmp, maxmv;
	int hp, mp, mv;
	int rhp, rmp, rmv;
	public Room room;
	public String Id;

	public Character(String Name, String Id, String describe, String shortDescribe, Equipment[] equipment, int maxhp,
			int maxmp, int maxmv, Room room) {
		super(Name,  describe);
		this.Id=Id;
		this.equipment = equipment;
		this.maxhp = maxhp;
		this.maxmp = maxmp;
		this.maxmv = maxmv;
		this.room = room;
	}

	public Character(String Name, String Id, String describe, String shortDescribe) {
		super(Name, describe);
		// TODO Auto-generated constructor stub
	}

	public String look(String command) {
		if (MainProgramThread.direction.containsKey(command)) {
			Door door = room.doorArray[MainProgramThread.direction.get(command)];
			if (door == null)
				return "這個方向沒有甚麼特別的";
			return room.doorArray[MainProgramThread.direction.get(command)].look(room, this);
		}
		return "你看不到那樣東西";
	}

	public String open(String command) {
		if (MainProgramThread.direction.containsKey(command)) {
			Door door = room.doorArray[MainProgramThread.direction.get(command)];
			if (door == null)
				return "這個方向沒有門喔";
			return room.doorArray[MainProgramThread.direction.get(command)].open(room);
		}
		return "你想要打開什麼呢?";
	}

	public String close(String command) {
		if (MainProgramThread.direction.containsKey(command)) {
			Door door = room.doorArray[MainProgramThread.direction.get(command)];
			if (door == null)
				return "這個方向沒有門喔";
			return room.doorArray[MainProgramThread.direction.get(command)].close(room, this);
		}
		return "你想要關閉什麼呢?";
	}

	public String move(int direct) {
		Door door = room.doorArray[direct];
		if (door != null) {
			if (door.doorstate < 2) {
				room = door.move(room, this);
				return (this.room.look(this));
			} else {
				return ("這個方向的門是關著的");
			}
		} else {
			return ("這個方向沒有路喔!!");
		}
	}
}
