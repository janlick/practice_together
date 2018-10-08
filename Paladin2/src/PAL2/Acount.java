package PAL2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Acount {
	String acountName;
	String password;
	String playtime;

	public Acount(String acountName, String password) {
		this.acountName = acountName;
		this.password = password;
	}

	public boolean saveAcount() {
		FileWriter writer;
		try {
			writer = new FileWriter("savefile/"+acountName);
			StringBuilder msg = new StringBuilder(password);
			int userKey = 6;
			for (int i = 0; i < msg.length(); i++) {
				msg.setCharAt(i, (char) (msg.charAt(i) + userKey));
			}
			writer.write(msg.toString());

			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String loadAcount() 
	{
		try {
			FileReader fr=new FileReader("savefile/"+acountName);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder msg = new StringBuilder(br.readLine());
			int userKey = 6;
			for (int i = 0; i < msg.length(); i++) {
				msg.setCharAt(i, (char) (msg.charAt(i) - userKey));
			}
			System.out.println(msg);
			return msg.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
