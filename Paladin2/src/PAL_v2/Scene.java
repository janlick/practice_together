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

	static String string1_1 = "����p�㻻�A����p�㻻�I\r\n" + "���p��:�z�z�I�@�c�h�ݪ�ù�ٰ��C�A�J�M���b�A����̡A  �n���n�l���Φh���I\r\n"
			+ "���j�Q�J���p���I�A���o�ڡH�����ѮQ�O���򰭱C�I\r\n" + "���p���J�u���k�ڡI\r\n" + "���j�Q�J�S�b�@�դ�ڤF�I�A�]�Ѥj���p�F�A��Ѻƺ������a�A�]���Ǿǰ����g�ơI\r\n"
			+ "���p���J�T�T��@�A���n�C���s�H�_�ɳ�����r�B��r�A�úV�@�q���A�|�~���H���I���̳o��ɤS���c�a�A�U�@�ڵ��L���F�A���̧��a�N����աC\r\n"
			+ "���j�Q�J���o�˥s�o���A�ܡH�n��A�]��L�v�žǹL�X�Ӥ몺��u�A�ɤ��c�ۤv�ʤ�פ@�פ��N�n�F�H�N�u�|�d�Ǥ�M��C���A���ѾǧA�R�R�M�˼C�A�S�өw�ʡA�����a�h�Q�@�N�����A��D�D\r\n"
			+ "���p���J���گR���|����ڮQ�H\r\n" + "���j�Q�J�ɡI�A�Q�]�O��A�R�@�Ӽ˨���쫥�̧��a�ӡA�]�����w�u�k���A�N�u�|��ۧA�R�ơD�D\r\n"
			+ "���p���J�K�D�D�j�a������L�̬O����W�H�H�r�}���p�m�L�Q�O�I\r\n"
			+ "���j�Q�J�O�@��L�Q�H���n�h��L�M�q��U�A�o�S�׺�A�@�h�L�^�٤��O�ڳo�ѤӱC�٦Y���Ϊ��}�F�o��@�a�p�p���ȴ̡A�~��A�ԩި�o��j�A���G�i�X�o��@���i���I\r\n" + "���p���J�ֻ��ڬO�i���աH\r\n"
			+ "���p���J�ڱN�ӭn���گR�Q�@�˽m�����@�Z�\�A�a��|���B���Q���򪺤@�N�j�L�I\r\n" + "���j�Q�J�ָ�ѮQ����H�I�A�r����n���O�X�F�W���C�n���O�o�^�ڦ����L�ӡA�~������A�o�i���������O�I\r\n"
			+ "���p���J�@�j���N���ȤH�W���աH\r\n" + "���j�Q�J�O�ڡD�D�٤��ֹL�������I\r\n"
			+ "���p���J�u�S�N��D�D�@�j�M���N�n�H�a���o�ӤS�����Ӫ��D�D�K�D�D�Q�߰��n���K�D���n���W�γ��C�o���N�q�o�̷ȥX�h�a�D�D\r\n" + "���j�Q�J�p���I�ٺۦb�и̷Fԣ�H�֥X�������۩I�ȤH��I\r\n"
			+ "�D�D�ڰ��W�N�h";

	static String string1_2 = "�ɡ��F�A�ߤW�A�αK�D�a�C�{�b�Q�o�{�N�G�F\r\n" + "���j�Q�J�p���I�ۦb�и̰�ԣ�H�٤��֥X�������۩I�ȤH�I\r\n" + "���p���J�ڡI�@�D�D�ڰ��W�N�h";

	static String string1_3 = "���j�Q�J�d�����C�]�]���I\r\n" + "���j�Q�J�U��ȩx�D�D�����СD�D\r\n" + "���j�Q�J�p���I���ک۩I�ȩx�̷����L�A�ڨ�p�зǳưs��D�D\r\n"
			+ "<���j�Q�ਭ���h>";

	static String string1_4 = "�]�H�Y��J�p�G�I�o���ȴ̧ڭ̥]�U�F�A���F����M�٭p�A��L���ۤz���H�������ڽХX�h\r\n"
			+ "���p���J�p�����ѨS�O���ȤH�A�U��ȩx�D�D�ڡ㤣�I�аݦU��j�ݭ��٦�ԣ�h�J���H\r\n" + "�]�H�Y��J�H��S���ڭ̪��h�J�A���\�����H���W�ӨӡA���D�F�ܡH\r\n"
			+ "���p���J�O�D�D�o�e���A�p���@�w�ӿ�\r\n" + "�]�H�Y��J�ܦn�I�o�ǻȤl�A���h�A����o�X�ѥu�n�A�Ĩ�ť�ڭ̪��ܿ�ơA��Ȥ��|�֧A���C\r\n"
			+ "���p���J�O���¤j�ݪ���D�D�p���@�w���z���ܦp�k�I\r\n" + "�o�좴�������\r\n" + "���p���J�z���I�u�O�J��]���ݤF�C�O��C�F�ȤH�C\r\n";

	static String string_k1 = "���j�Q�J�p���A�Ӫ����n�A�֧���f���ӯ�n���������A�K�o��ê���̰��ͷN�O�o��I���@�U��p�Ш������ݵ�C";

	static String string_k2 = "\"��W�\�ۤ@���ײ����s��A���ݰ_�ӫܦn�Y���ˤl\"\r\n" + "���j�Q�J�p���I�֧��W���s��ݤW�ӥh�I\r\n" + "���j�Q�J��F�I�N�O���L�A���ֺݥh���ӤW���ȩx�C\r\n"
			+ "\"���p���ݰ_����\"";

	static String string1_5 = "���p���J���j�ݡI�s��e�ӤF�C\r\n" + "���i�ӡI\r\n" + "�]�H���o�J���o�O����s�r�H�@�I���D�]�S���I\r\n"
			+ "���p���J�@�I�j�ݱz���Ҥ����A���s�D���a���W����۪�s�A�M���̾J�L��A�s��ª��Q�m�Q�Q���R�ܪ����o�F�O�I\r\n" + "�]�H���o�J�����I�����I�ڭ̳ܺD�P�s�~���n�Q�̳ܪ��s�C\r\n"
			+ "���p���J����D�D�p���A���z���@���ӡC\r\n" + "�]�H���o�J�����F�I���̦ۤv���a�s�C \r\n" + "\"���p���N�۪�s���J�h��\"";

	static String string_l1 = "\"�@�W��mİ�����K�~���b���f\"\r\n" + "���p���J�h�h�h�I�ڭ̤]�ܽa�A�S�������A\r\n"
			+ "�K�D�h�J�ڤ��O�n���A�ڥu�Q�Q�ǰs�ܤp�S�̡���U�@�U���D�D���ڤ@�I�s�a\r\n" + "���p���J�����I�����I���T�T���D�F�ڭ���|�A�A���֨��a�I\r\n"
			+ "�K�D�h�J�u�r�I�S�s�ܧڤ@�B�]�����ʧA�N���n�a�D�D ";
	static String string_l2 = "�K�D�h�J�s�P�P�D�D�D�D�A�D�D�@�f�D�D�ܤ@�f�D�D�N�n\r\n";

	static String string_l3 = "�K�D�h�J�s�P�P�D�D�D�D�A�D�D�@�f�D�D�ܤ@�f�D�D�N�n\r\n" + "���p���J�ݧA�i���A�N���A�ܤ@�f�a�ޡ�u��ܤ@�f��I\r\n" + "�K�D�h�J�ڡD�D�D�D�n�s�I\r\n"
			+ "���p���J�u�r�D�D�A���ܥ��F�I\r\n" + "�K�D�h�J�С�ڤ@�f�N�O����j�f�u�O���n�N��D�D\r\n" + "���p���J�A�D�D�D�A�n�ߧڡI\r\n"
			+ "�K�D�h�J�����D�D�n���ڥi�S���A���O�ܷQ�ǼC�ܡH\r\n" + "���p���J�A��򪾹D�H\r\n" + "�K�D�h�J�ݦb�s�����W�h�D�i�H�}�ҫ��I�A�X��\r\n" + "���p���J�D�D�A�D�D�A�n�ЧڼC�k�H�H\r\n"
			+ "���p���J�ѧB�D�D�z�O�r�ڤF�z�٬O�֨��a�A�n�O�����T�T���D�ڮ��s���A�ܡA��|�H��\r\n" + "�K�D�h�J�������I���N���ߤT��Q���Y\"�s���q\"�C���������I\r\n"
			+ "\"�K�D�h�ܻ����@�ȷϦa�N�����F�D�D\"\r\n" + "�x��H�O�H";

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
			System.out.println("���j�Q�J�s�ݵ��ӤW�ȤH�F�ܡH�o�̼ȮɨS������i�H�������F");
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
