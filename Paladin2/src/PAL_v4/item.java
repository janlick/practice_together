package PAL_v4;

import java.util.ArrayList;
import java.util.List;

public class item {

	static List<String> itemlist = new ArrayList<>();

	public static void itemlist() {
		System.out.println("");
		System.out.println("�����G" + main.money);
		System.out.println("���~�M��G");
		if (itemlist.size() < 1)
			System.out.print("�L");
		else
			for (int i = 0; i < itemlist.size(); i++) {
				String name = itemlist.get(i);
				System.out.print(name.toUpperCase() + "\t");
				if ((i + 1) % 5 == 0)
					System.out.println("");
			}
		System.out.println("\n");
	}
}
