package PAL_v3;

/*
 * 綠色小妖：
 * HP 40  EXP 1  GOLD 0
 * 抗性：毒0%  風50%  雷50%  水90%  火0%  土90%
 * 絕技：--
 * 偷竊：--
 * 戰利品：--
 * 靈葫值：1
 * 地址：1D28
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

		System.out.println("此時迎面走來一隻綠色小妖，請輸入攻擊指令<AT>來迎擊");

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
					System.out.println("綠色小妖HP-" + (int) (numG * 0.5) + "，綠色小妖HP=" + (GreenGenieHP));
				} else {
					System.out.println("綠色小妖HP-" + (int) (numG * 0.5) + "，綠色小妖HP=" + (GreenGenieHP));
					if (GreenGenieHP == 0) {
						System.out.print("收服綠色小妖，李逍遙HP+40\n-Combat Ends-");
						timer.cancel();
						break;
					} else if (GreenGenieHP - numG * 0.5 < 0) {
						while (true) {
							attack = reader.readLine();
							if (attack.toUpperCase().equals("AT")) {
								System.out.println("綠色小妖HP-" + GreenGenieHP + "，綠色小妖HP=" + 0);
								System.out.print("收服綠色小妖，李逍遙HP+40\n-Combat Ends-");
								GreenGenieHP = 0;
								timer.cancel();
								break;
							} else {
								System.out.print("請輸入攻擊指令<AT>來迎擊");
								continue;
							}
						}
						break;
					}
				}
			} else {
				System.out.print("請輸入攻擊指令<AT>來迎擊");
				continue;
			}
		}
		// System.out.print("\nfinal GreenGenieHP = "+GreenGenieHP+", final XiaoYaoHP =
		// "+XiaoYaoHP);
	}
}
