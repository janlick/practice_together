package PAL_v3;

/*
 * <�Ĥ@�����H���ʧ@>�����G���p�����ж�
 * ��J<E/W/S/N>���O�i�ϤH���V-�F(E)�n(S)��(W)�_(N)4�Ӥ�첾��
 * E>> Y>>�H�����ʦܤ@�Ӯ��  N>>���s��ܲ��ʤ�V
 * W>> �H�����ʦܨ��Y�A�J�����j�Q
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
			System.out.print("�аݳp���n�����Ӥ�V���H<E/W/S/N>");
			inputDirection = reader.readLine();
			if (inputDirection.toUpperCase().equals("E")) {
				a = 2;
				while (a == 2) {
					System.out.print("�q���ӤU��Ъ��K�D�A�O�_�i�J�H<Y/N>");
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
				System.out.println("���X�ж��A�b���D�W�J�����j�Q<ENTER>");
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
				System.out.println("�u�O�@�����q������A����]�S���K�K");
				continue;
			}
		}
		System.out.println("");
	}

	public static void Action1_3() throws IOException {
		String inputDirection;
		int a = 1;
		while (a == 1) {
			System.out.print("�аݳp���n�����Ӥ�V���H<D�U��/R�^�ж�/M��]�H�ȩ�>");
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
			System.out.print("�аݳp���n�����Ӥ�V���H<D�U��/R�^�ж�/T�~����>");
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
			System.out.print("K��p�С@1����j�Q�С@2���С@U�W�ӡ@L�P�K�~����");
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
				System.out.println("�ȮɨS������ȥi�i��...");
				continue;
			}
			if (inputDirection.toUpperCase().equals("2")) {
				System.out.println("");
				map.room3();
				System.out.println("");
				System.out.println("�ȮɨS������ȥi�i��...");
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