package PAL2.Initial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PAL2.Area.Area;
import PAL2.Area.Room;

public class InitialArea {

	static public List<Area> ini()
	{
		List<Area> listArea=new LinkedList<Area>();
		FileReader fr;
		FileReader roomfr;
		try {
			fr = new FileReader("PAL2/map/world");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null)
			{
				InputStream stream = new FileInputStream("PAL2/map/"+line);
				byte[] b = new byte[stream.available()];
				stream.read(b);
				String filestring=new String(b);
				//System.out.println(filestring.replace("\\r\\n","\r\n"));
				JSONObject jb=new JSONObject(filestring);
				JSONObject areajb=jb.getJSONObject("Area");
				Area area=new Area(areajb.getString("Name"),areajb.getString("ID"),areajb.getString("describe"),areajb.getString("shortDescribe"));
	
				JSONArray ja=jb.getJSONArray("Room");
				for(int a=0;a<ja.length();a++)
				{
					JSONObject roomjb=ja.getJSONObject(a);
					Room room=new Room(roomjb.getString("Name"),roomjb.getString("ID"),roomjb.getString("describe"),roomjb.getString("shortDescribe"),roomjb.getJSONArray("EXIT"));
					area.allRoom.put(roomjb.getString("ID"),room);
				 //   System.out.println(ja.get(a).toString());
				}
				area.setconnect();
				listArea.add(area);
			}
			
			
			return listArea;
		} catch ( IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
