package PAL2.Area;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import PAL2.MudObject;

public class Area extends MudObject {

	// public LinkedList<Room> allRoom = new LinkedList<Room>();
	public Map<String, Room> allRoom = new HashMap<String, Room>();
	public Map<String, Door> roomconnect = new HashMap<String, Door>();

	// public Area(String Name,String Id,String describe,String shortDescribe)
	// {
	//
	// }
	public Area(String name, String id, String describe, String shortDescribe) {
		super(name, describe);
	}

	public void setconnect() {
		for (Room room : allRoom.values()) {
			for (int a = 0; a < room.exitroomjb.length(); a++) {
				try {
					JSONObject exit = room.exitroomjb.getJSONObject(a);

					if (allRoom.containsKey(exit.getString("room"))) {
						Room connectroom = allRoom.get(exit.getString("room"));
						Door d;
						if (!(roomconnect.containsKey(room.Id + connectroom.Id)
								|| roomconnect.containsKey(connectroom.Id + room.Id))) {
							if (exit.has("door")) {
								if (exit.has("lock")) {
									d = new Door(room, connectroom, exit.getInt("door"), exit.getString("lock"));
								} else {
									d = new Door(room, connectroom, exit.getInt("door"));
								}
							} else {
								d = new Door(room, connectroom);
							}
							System.out.println(d.roomconnect1.Id + "**" + d.roomconnect2.Id);
							roomconnect.put(room.Id + connectroom.Id, d);
						} else if (!(roomconnect.containsKey(room.Id + connectroom.Id))) {
							d = roomconnect.get(connectroom.Id + room.Id);
						} else {
							d = roomconnect.get(room.Id + connectroom.Id);
						}
						switch (exit.getString("exit")) {
						case "e":
							room.doorArray[0] = d;
							break;
						case "w":
							room.doorArray[1] = d;
							break;
						case "s":
							room.doorArray[2] = d;
							break;
						case "n":
							room.doorArray[3] = d;
							break;
						case "u":
							room.doorArray[4] = d;
							break;
						case "d":
							room.doorArray[5] = d;
							break;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
