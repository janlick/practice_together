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
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + XiaoYaoHP);
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
			System.out.println("���p��HP-" + XiaoYaoHP + ", ���p��HP=" + 0);
			System.out.println("�ӱѤD�L�a�`�ơA�j�L�Э��s�ӹL�C");
			XiaoYaoHP = 0;
			this.cancel();
		} else {
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + XiaoYaoHP);
		}
		if (XiaoYaoHP <= 25 && XiaoYaoHP > 0) {
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
		}
	}
}