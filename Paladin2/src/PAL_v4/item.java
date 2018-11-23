package PAL_v4;

import java.util.ArrayList;
import java.util.List;

public class item {

	static List<String> itemlist = new ArrayList<>();

	public static void itemlist() {
		System.out.println("");
		System.out.println("金錢：" + main.money);
		System.out.println("物品清單：");
		if (itemlist.size() < 1)
			System.out.print("無");
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
