package test20181115;

/*
 * 樹妖：
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

public class Dryadhp implements Runnable {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Thread atxiaoyao = new Thread(new xiaoyaohp(), "atxiaoyao");
	static Thread atDryad = new Thread(new Dryadhp(), "atDryad");
	static Timer timer = new Timer();
	static String attack;
	static Integer DryadHP = 40;

	public static void main(String[] args) throws IOException {

		System.out.print("Combat starts <ENTER>");
		String inputNull = reader.readLine();

		atDryad.start();
		timer.schedule(new xiaoyaohp(), 0, 10);
	}

	public void attackDryad() throws atDryadError, IOException {
		if (xiaoyaohp.XiaoYaoHP <= 0)
			throw new atDryadError("逍遙HP=0~~~不能再攻擊");
		else
			attack = reader.readLine();
	}

	public void atDryad() throws atDryadError, IOException {

		int numG = 0;
		while (true) {
			this.attackDryad();
			if (attack.toUpperCase().equals("AT")) {
				numG = (int) (Math.random() * 14) + 14;
				DryadHP = DryadHP - (int) (numG * 0.5);
				if (DryadHP - numG * 0.5 > 0) {
					System.out.println("樹妖HP-" + (int) (numG * 0.5) + "，樹妖HP=" + (DryadHP));
				} else {
					System.out.println("樹妖HP-" + (int) (numG * 0.5) + "，樹妖HP=" + (DryadHP));
					if (DryadHP == 0) {
						System.out.print("收服樹妖，李逍遙HP+40\n-Combat Ends-");
						timer.cancel();
						break;
					} else if (DryadHP - numG * 0.5 < 0) {
						while (true) {
							this.attackDryad();
							if (attack.toUpperCase().equals("AT")) {
								System.out.println("樹妖HP-" + DryadHP + "，樹妖HP=" + 0);
								System.out.print("收服樹妖，李逍遙HP+40\n-Combat Ends-");
								DryadHP = 0;
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
	}

	@Override
	public void run() {
		System.out.println("此時迎面走來一隻樹妖，請輸入攻擊指令<AT>來迎擊");
		try {
			this.atDryad();
		} catch (atDryadError | IOException e) {
			e.printStackTrace();
		}
	}

	class atDryadError extends Exception {

		private static final long serialVersionUID = 1L;

		public atDryadError(String msg) {
			super(msg);
		}
	}
}
