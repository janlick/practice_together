package PAL_v2;

//import java.util.Date;
import java.util.TimerTask;
import PAL_v2.*;

public class DateTask extends TimerTask {
	
	public void run() {
		int numX = (int) (Math.random() * 14) + 14;
		main.XiaoYaoHP = main.XiaoYaoHP - (int) (numX * 0.5);

		if (main.XiaoYaoHP - (int) (numX * 0.5) <= 0) {
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + main.XiaoYaoHP);
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
			System.out.println("���p��HP-" + main.XiaoYaoHP + ", ���p��HP=" + 0);
			System.out.println("�ӱѤD�L�a�`�ơA�j�L�Э��s�ӹL�C");
			main.XiaoYaoHP = 0;
			this.cancel();
		} else {
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + main.XiaoYaoHP);
		}
		if (main.XiaoYaoHP <= 25 && main.XiaoYaoHP > 0) {
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
		}
	}
}