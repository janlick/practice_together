package PAL_v3;

/*
 * ���p���G
 * HP 40  EXP 1  GOLD 0
 * �ܩʡG�r0%  ��50%  �p50%  ��90%  ��0%  �g90%
 * ���ޡG--
 * ���ѡG--
 * �ԧQ�~�G--
 * �F���ȡG1
 * �a�}�G1D28
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GreenGenieDM {
//	public static void greengenieattack() {
//	}

	public static void main(String[] args) throws IOException {

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		String inputNull;
		String attack;
		System.out.print("Combat starts <ENTER>");
		inputNull = reader.readLine();

		Integer GreenGenieHP = 40;

		System.out.println("���ɪﭱ���Ӥ@�����p���A�п�J�������O<AT>�Ӫ���");

		// int numX = 0;
		int numG = 0;
		Timer timer = new Timer();
		timer.schedule(new DateTask(), 0, 10);

		while (true) {
			attack = reader.readLine();
			if (attack.toUpperCase().equals("AT")) {
				// numX = (int) (Math.random() * 14) + 14;
				numG = (int) (Math.random() * 14) + 14;

				GreenGenieHP = GreenGenieHP - (int) (numG * 0.5);

				if (GreenGenieHP - numG * 0.5 > 0) {
					System.out.println("���p��HP-" + (int) (numG * 0.5) + "�A���p��HP=" + (GreenGenieHP));
				} else {
					System.out.println("���p��HP-" + (int) (numG * 0.5) + "�A���p��HP=" + (GreenGenieHP));
					if (GreenGenieHP == 0) {
						System.out.print("���A���p���A���p��HP+40\n-Combat Ends-");
						timer.cancel();
						break;
					} else if (GreenGenieHP - numG * 0.5 < 0) {
						while (true) {
							attack = reader.readLine();
							if (attack.toUpperCase().equals("AT")) {
								System.out.println("���p��HP-" + GreenGenieHP + "�A���p��HP=" + 0);
								System.out.print("���A���p���A���p��HP+40\n-Combat Ends-");
								GreenGenieHP = 0;
								timer.cancel();
								break;
							} else {
								System.out.print("�п�J�������O<AT>�Ӫ���");
								continue;
							}
						}
						break;
					}
				}
			} else {
				System.out.print("�п�J�������O<AT>�Ӫ���");
				continue;
			}
		}
		// System.out.print("\nfinal GreenGenieHP = "+GreenGenieHP+", final XiaoYaoHP =
		// "+XiaoYaoHP);
	}
}
