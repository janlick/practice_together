package PAL_v3;

/*
 * <第一幕的人物動作>場景：李逍遙的房間
 * 輸入<E/W/S/N>指令可使人物向-東(E)南(S)西(W)北(N)4個方位移動
 * E>> Y>>人物移動至一樓柴房  N>>重新選擇移動方向
 * W>> 人物移動至走廊，遇見李大娘
 * S>> Nothing Happend
 * N>> Nothing Happend
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Action {

	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String inputNull;

	public static void Action1() throws IOException {
		String inputDirection;
		String inputYN;
		System.out.println("");
		int a = 1;
		while (a == 1) {
			System.out.print("請問逍遙要往哪個方向走？<E/W/S/N>");
			inputDirection = reader.readLine();
			if (inputDirection.toUpperCase().equals("E")) {
				a = 2;
				while (a == 2) {
					System.out.print("通往樓下柴房的密道，是否進入？<Y/N>");
					inputYN = reader.readLine();
					if (inputYN.toUpperCase().equals("Y")) {
						Scene.Scene1_2();
						a = 1;
						continue;
					}
					if (inputYN.toUpperCase().equals("N")) {
						a = 1;
					} else {
						continue;
					}
				}
			}
			if (inputDirection.toUpperCase().equals("W") && Scene.booleanScene1_3 == false) {
				System.out.println("走出房間，在走道上遇見李大娘<ENTER>");
				inputNull = reader.readLine();
				Scene.Scene1_3();
				Action1_3();
				break;
			} else if (inputDirection.toUpperCase().equals("W") && Scene.booleanScene1_3 == true) {
				System.out.println("");
				map.SecondFloor();
				System.out.println("");
				Action1_3();
				break;
			}

			else if (inputDirection.toUpperCase().equals("S") || inputDirection.toUpperCase().equals("N")) {
				System.out.println("只是一面普通的牆壁，什麼也沒有……");
				continue;
			}
		}
		System.out.println("");
	}

	public static void Action1_3() throws IOException {
		String inputDirection;
		int a = 1;
		while (a == 1) {
			System.out.print("請問逍遙要往哪個方向走？<D下樓/R回房間/M到苗人客房>");
			inputDirection = reader.readLine();

			if (inputDirection.toUpperCase().equals("D")) {
				System.out.println("");
				map.lobby();
				Action.Action1_5();
				break;

			} else if (inputDirection.toUpperCase().equals("R")) {
				System.out.println("");
				map.roomXiaoYao();
				Action1();
				break;
			}
			if (inputDirection.toUpperCase().equals("M") && Scene.booleanScene_l2 == false) {
				System.out.println("");
				Scene.Scene_M();
				Action1_4();
				break;
			}
			if (inputDirection.toUpperCase().equals("M") && Scene.booleanScene_1_5 == true) {
				Scene.array = Scene.string1_4.split("\r\n");
				System.out.print(Scene.array[2]);
				inputNull = reader.readLine();
				System.out.println(Scene.array[3]);
				System.out.println("");
				Action1_4();
				break;
			}

			if (inputDirection.toUpperCase().equals("M") && Scene.booleanScene_l2 == true) {
				System.out.println("");
				Scene.Scene_M();
				Action1_4();
				break;
			}
		}
		System.out.println("");
	}

	public static void Action1_4() throws IOException {
		String inputDirection;
		int a = 1;
		while (a == 1) {
			System.out.print("請問逍遙要往哪個方向走？<D下樓/R回房間/T繼續交談>");
			inputDirection = reader.readLine();

			if (inputDirection.toUpperCase().equals("D")) {
				System.out.println("");
				map.lobby();
				Action.Action1_5();
				break;
			} else if (inputDirection.toUpperCase().equals("R")) {
				System.out.println("");
				map.roomXiaoYao();
				Action1();
				break;
			}
			if (inputDirection.toUpperCase().equals("T")) {
				Scene.array = Scene.string1_4.split("\r\n");
				System.out.print(Scene.array[2]);
				inputNull = reader.readLine();
				System.out.println(Scene.array[3]);
				System.out.println("");
				Action1_4();
				break;
			}
		}
		System.out.println("");
	}

	public static void Action1_5() throws IOException {
		String inputDirection;
		int a = 1;

		while (a == 1) {
			System.out.print("K到廚房　1到李大娘房　2到柴房　U上樓　L與醉漢說話");
			inputDirection = reader.readLine();

			if (inputDirection.toUpperCase().equals("K") && Scene.booleanScene_l1 == false) {
				System.out.println("");
				map.Kitchen();
				Scene.Scene_k();
				continue;
			}
			if (inputDirection.toUpperCase().equals("K") && Scene.booleanScene_1_5 == true) {
				Scene.Scene_k();
				continue;
			}

			if (inputDirection.toUpperCase().equals("K") && Scene.booleanScene_l1 == true) {
				System.out.println("");
				map.Kitchen();
				Scene.Scene_k();
				continue;
			} else if (inputDirection.toUpperCase().equals("1")) {
				System.out.println("");
				map.room2();
				System.out.println("");
				System.out.println("暫時沒什麼任務可進行...");
				continue;
			}
			if (inputDirection.toUpperCase().equals("2")) {
				System.out.println("");
				map.room3();
				System.out.println("");
				System.out.println("暫時沒什麼任務可進行...");
				continue;
			}
			if (inputDirection.toUpperCase().equals("U")) {
				System.out.println("");
				map.SecondFloor();
				System.out.println("");
				Action1_3();
				break;
			}
			if (inputDirection.toUpperCase().equals("L") && Scene.booleanScene_1_5 == false) {
				Scene.Scene_L();
				continue;
			}

			if (inputDirection.toUpperCase().equals("L") && Scene.booleanScene_1_5 == true) {
				Scene.Scene_L1();
				break;
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
//		Action1_3();
	}
}