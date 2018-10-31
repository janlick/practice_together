package PAL_v2;

import java.io.*;
import PAL_v2.map;

public class Scene {
	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String inputNull;
	static String array[];
	static boolean booleanScene1_3;
	static boolean booleanScene_M;
	static boolean booleanScene_k1;
	static boolean booleanScene_k2;
	static boolean booleanScene_l1;
	static boolean booleanScene_l2;
	static boolean booleanScene_l3;
	static boolean booleanScene_1_5;

	static String string1_1 = "李～逍～遙，李～逍～遙！\r\n" + "李逍遙:哇哇！作惡多端的羅煞鬼婆，既然落在你的手裡，  要殺要剮不用多說！\r\n"
			+ "李大娘︰李逍遙！你皮癢啊？敢說老娘是什麼鬼婆！\r\n" + "李逍遙︰哎呦～疼啊！\r\n" + "李大娘︰又在作白日夢了！你也老大不小了，整天瘋瘋癲癲地，也不學學做正經事！\r\n"
			+ "李逍遙︰嬸嬸～　你不要每次叫人起床都拿鍋呀、鏟呀，亂敲一通的，會嚇死人哪！咱們這木床又不牢靠，萬一我給摔死了，咱們李家就絕後啦。\r\n"
			+ "李大娘︰不這樣叫得醒你嗎？好歹你也跟林師傅學過幾個月的木工，床不牢自己動手修一修不就好了？就只會削些木刀木劍的，成天學你爹舞刀弄劍，沒個定性，有哪家姑娘願意嫁給你喔．．\r\n"
			+ "李逍遙︰那我爹怎麼會娶到我娘？\r\n" + "李大娘︰嘖！你娘也是跟你爹一個樣兒嫁到咱們李家來，也不做針線女紅，就只會跟著你爹瘋．．\r\n"
			+ "李逍遙︰嘿．．大家都說～他們是江湖上人人羨慕的鴛鴦俠侶呢！\r\n"
			+ "李大娘︰是哦～俠侶？說要去行俠仗義丟下你這惹禍精，一去無回還不是我這老太婆省吃儉用的開了這麼一家小小的客棧，才把你拉拔到這麼大，結果養出這麼一個懶鬼！\r\n" + "李逍遙︰誰說我是懶鬼啦？\r\n"
			+ "李逍遙︰我將來要像我爹娘一樣練成絕世武功，縱橫四海、稱霸江湖的一代大俠！\r\n" + "李大娘︰少跟老娘鬼扯淡！你呀～游手好閒是出了名的。要不是這回我忙不過來，才不指望你這懶鬼來幫忙呢！\r\n"
			+ "李逍遙︰一大早就有客人上門啦？\r\n" + "李大娘︰是啊．．還不快過來幫忙！\r\n"
			+ "李逍遙︰真沒意思．．一大清早就要人家做這個又做那個的．．嘿．．昨晚做好的密道正好派上用場。這次就從這裡溜出去吧．．\r\n" + "李大娘︰逍遙！還窩在房裡幹啥？快出來幫忙招呼客人喔！\r\n"
			+ "．．我馬上就去";

	static String string1_2 = "嘖～算了，晚上再用密道吧。現在被發現就慘了\r\n" + "李大娘︰逍遙！窩在房裡做啥？還不快出來幫忙招呼客人！\r\n" + "李逍遙︰啊！　．．我馬上就去";

	static String string1_3 = "李大娘︰搞什麼～慢吞吞的！\r\n" + "李大娘︰各位客官．．裡邊兒請．．\r\n" + "李大娘︰逍遙！幫我招呼客官們歇歇腿，我到廚房準備酒菜．．\r\n"
			+ "<李大娘轉身離去>";

	static String string1_4 = "苗人頭領︰小二！這間客棧我們包下了，除了老闆和夥計，其他不相干的人全都給我請出去\r\n"
			+ "李逍遙︰小店今天沒別的客人，各位客官．．啊～不！請問各位大爺們還有啥吩咐的？\r\n" + "苗人頭領︰以後沒有我們的吩咐，不許閒雜人等上樓來，知道了嗎？\r\n"
			+ "李逍遙︰是．．這容易，小的一定照辦\r\n" + "苗人頭領︰很好！這些銀子你拿去，往後這幾天只要你乖乖聽我們的話辦事，賞銀不會少你的。\r\n"
			+ "李逍遙︰是～謝大爺的賞．．小店一定讓您賓至如歸！\r\n" + "得到５００文錢\r\n" + "李逍遙︰哇哈！真是遇到財神爺了。別怠慢了客人。\r\n";

	static String string_k1 = "李大娘︰逍遙你來的正好，快把門口那個臭要飯的趕走，免得妨礙咱們做生意記得喔！等一下到廚房來幫忙端菜。";

	static String string_k2 = "\"桌上擺著一份豐盛的酒菜，嗯～看起來很好吃的樣子\"\r\n" + "李大娘︰逍遙！快把桌上的酒菜端上樓去！\r\n" + "李大娘︰對了！就是那盤，趕快端去給樓上的客官。\r\n"
			+ "\"李逍遙端起韭菜\"";

	static String string1_5 = "李逍遙︰兩位大爺！酒菜送來了。\r\n" + "拿進來！\r\n" + "苗人嘍囉︰嗯～這是什麼酒呀？一點味道也沒有！\r\n"
			+ "李逍遙︰哦！大爺您有所不知，此酒乃本地的名產～桂花酒，清香甘醇無比，連當朝的貴妃娘娘都愛喝的不得了呢！\r\n" + "苗人嘍囉︰拿走！拿走！我們喝慣烈酒才不要娘們喝的酒。\r\n"
			+ "李逍遙︰那麼．．小的再給您換一壺來。\r\n" + "苗人嘍囉︰不必了！咱們自己有帶酒。 \r\n" + "\"李逍遙將桂花酒收入懷中\"";

	static String string_l1 = "\"一名衣衫襤褸的醉漢躺在門口\"\r\n" + "李逍遙︰去去去！我們也很窮，沒錢分給你\r\n"
			+ "醉道士︰我不是要錢，我只想討些酒喝小兄弟～拜託一下嘛．．給我一點酒吧\r\n" + "李逍遙︰不成！不成！給嬸嬸知道了我准挨罵，你趕快走吧！\r\n"
			+ "醉道士︰哎呀！沒酒喝我一步也走不動你就行行好吧．． ";
	static String string_l2 = "醉道士︰酒··求求．．你．．一口．．喝一口．．就好\r\n";

	static String string_l3 = "醉道士︰酒··求求．．你．．一口．．喝一口．．就好\r\n" + "李逍遙︰看你可憐，就給你喝一口吧喂～只能喝一口喔！\r\n" + "醉道士︰啊．．．．好酒！\r\n"
			+ "李逍遙︰哎呀．．你怎麼喝光了！\r\n" + "醉道士︰嗝～我一口就是那麼大口真是不好意思．．\r\n" + "李逍遙︰你．．．你要賠我！\r\n"
			+ "醉道士︰呵呵．．要錢我可沒有你不是很想學劍嗎？\r\n" + "李逍遙︰你怎麼知道？\r\n" + "醉道士︰看在酒的份上貧道可以破例指點你幾招\r\n" + "李逍遙︰．．你．．你要教我劍法？？\r\n"
			+ "李逍遙︰老伯．．您別逗我了您還是快走吧，要是給我嬸嬸知道我拿酒給你喝，准罵人的\r\n" + "醉道士︰哈哈哈！那就明晚三更十里坡\"山神廟\"。不見不散！\r\n"
			+ "\"醉道士話說完一溜煙地就不見了．．\"\r\n" + "咦～人呢？";

	public static void runScene() throws IOException {
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			inputNull = reader.readLine();
		}
		System.out.println("");
	}

	public static void Scene1() throws IOException {
		array = string1_1.split("\r\n");
		System.out.println("Scene1 starts, please press <ENTER> each step to continue the story...");
		inputNull = reader.readLine();
		map.roomXiaoYao_1();
		runScene();
		map.roomXiaoYao_2();
	}

	public static void Scene1_2() throws IOException {
		array = string1_2.split("\r\n");
		runScene();
		System.out.println("");
	}

	public static void Scene1_3() throws IOException {
		array = string1_3.split("\r\n");
		map.SecondFloor_1();
		runScene();
		booleanScene1_3 = true;
	}

	public static void Scene_M() throws IOException {
		if (Scene.booleanScene_l2 == false) {
			if (booleanScene_k2 == true) {
				array = string1_5.split("\r\n");
				runScene();
				System.out.println("");
				booleanScene_1_5 = true;
			}

			if (booleanScene_M == false) {
				array = string1_4.split("\r\n");
				map.room1();
				runScene();
				main.money += 500;
				map.room1();
			}
			if (booleanScene_M == true) {
				array = string1_4.split("\r\n");
				System.out.print(array[2]);
				inputNull = reader.readLine();
				System.out.println(array[3]);
				System.out.println("");
			}
		}
		if (Scene.booleanScene_l2 == true) {
			array = string1_5.split("\r\n");
			runScene();
			System.out.println("");
			booleanScene_1_5 = true;
		}
		booleanScene_M = true;
	}

	public static void Scene_k() throws IOException {

		if (booleanScene_1_5 == true) {
			map.Kitchen();
			System.out.println("李大娘︰酒端給樓上客人了嗎？這裡暫時沒有什麼可以幫忙的了");
			System.out.println("");
		} else {
			if (booleanScene_k1 == false) {
				array = string_k1.split("\r\n");
				runScene();
				map.lobby();
			}
			if (booleanScene_k1 == true && booleanScene_l2 == false) {
				array = string_k1.split("\r\n");
				runScene();
				map.lobby();
			}
			if (booleanScene_k1 == true && booleanScene_l2 == true) {
				array = string_k2.split("\r\n");
				runScene();
				map.Kitchen();
				if (booleanScene_l2 == true)
					booleanScene_k2 = true;
			}
		}
		booleanScene_k1 = true;
	}

	public static void Scene_L() throws IOException {
		if (booleanScene_k1 == true)
			booleanScene_l2 = true;

		if (booleanScene_l1 == false) {
			array = string_l1.split("\r\n");
			runScene();
			map.lobby();
			booleanScene_l1 = true;
		} else if (booleanScene_l1 == true) {
			array = string_l2.split("\r\n");
			runScene();
			map.lobby();
		}
	}

	public static void Scene_L1() throws IOException {
		Scene.array = Scene.string_l3.split("\r\n");
		Scene.runScene();
		System.out.println("-Scene 1 ends-");
	}
}
