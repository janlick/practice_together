package PAL_v4;

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

public class GreenGenieDM implements Runnable {
	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String attack;

	static Thread atxiaoyao = new Thread(new xiaoyaohp(), "xiaoyaoAt");
	static Thread atDryad = new Thread(new GreenGenieDM(), "GreenGenieDM");

	static Integer GreenGenieHP = 40;
	static Timer timer = new Timer();

	public static void main(String[] args) throws IOException {

		System.out.print("Combat starts <ENTER>");
		String inputNull = reader.readLine();
		atDryad.start();
		timer.schedule(new xiaoyaohp(), 0, 10);
	}

	@Override
	public void run() {
		System.out.println("此時迎面走來一隻綠色小妖，請輸入攻擊指令<AT>來迎擊");
		int numG = 0;
		try {
			label: while (true) {
				attack = reader.readLine();
				if (attack.toUpperCase().equals("AT")) {
					numG = (int) (Math.random() * 14) + 14;
					GreenGenieHP -= (int) (numG * 0.5);
					if (GreenGenieHP - numG * 0.5 > 0) {
						System.out.println("綠色小妖HP-" + (int) (numG * 0.5) + "，綠色小妖HP=" + (GreenGenieHP));
					} else {
						System.out.println("綠色小妖HP-" + (int) (numG * 0.5) + "，綠色小妖HP=" + (GreenGenieHP));
						if (GreenGenieHP == 0) {
							System.out.print("收服綠色小妖，李逍遙HP+40\n-Combat Ends-");
							timer.cancel();
							break;
						} else {
							while (true) {
								attack = reader.readLine();
								if (attack.toUpperCase().equals("AT")) {
									System.out.println("綠色小妖HP-" + GreenGenieHP + "，綠色小妖HP=" + 0);
									System.out.print("收服綠色小妖，李逍遙HP+40\n-Combat Ends-");
									GreenGenieHP = 0;
									timer.cancel();
									break label;
								} else {
									System.out.print("請輸入攻擊指令<AT>來迎擊");
									continue;
								}
							}
						}
					}
				} else {
					System.out.print("請輸入攻擊指令<AT>來迎擊");
					continue;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}