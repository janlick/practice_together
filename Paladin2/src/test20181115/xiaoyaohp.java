package test20181115;

//import java.util.Date;
import java.util.TimerTask;

public class xiaoyaohp extends TimerTask implements Runnable {
	public static int XiaoYaoHP = 200;

	@Override
	public void run() {
		int numX = (int) (Math.random() * 14) + 14;
		XiaoYaoHP = XiaoYaoHP - (int) (numX * 0.5);

		if (XiaoYaoHP - (int) (numX * 0.5) <= 0) {
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + XiaoYaoHP);
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
			System.out.println("李逍遙HP-" + XiaoYaoHP + ", 李逍遙HP=" + 0);
			System.out.println("勝敗乃兵家常事，大俠請重新來過。");
			XiaoYaoHP = 0;
			this.cancel();
		} else {
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + XiaoYaoHP);
		}
		if (XiaoYaoHP <= 25 && XiaoYaoHP > 0) {
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
		}
	}
}