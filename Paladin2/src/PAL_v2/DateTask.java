package PAL_v2;

//import java.util.Date;
import java.util.TimerTask;
import PAL_v2.*;

public class DateTask extends TimerTask {
	
	public void run() {
		int numX = (int) (Math.random() * 14) + 14;
		main.XiaoYaoHP = main.XiaoYaoHP - (int) (numX * 0.5);

		if (main.XiaoYaoHP - (int) (numX * 0.5) <= 0) {
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + main.XiaoYaoHP);
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
			System.out.println("李逍遙HP-" + main.XiaoYaoHP + ", 李逍遙HP=" + 0);
			System.out.println("勝敗乃兵家常事，大俠請重新來過。");
			main.XiaoYaoHP = 0;
			this.cancel();
		} else {
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + main.XiaoYaoHP);
		}
		if (main.XiaoYaoHP <= 25 && main.XiaoYaoHP > 0) {
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
		}
	}
}