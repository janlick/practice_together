package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A5_2 {

	public static void main(String A[]) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(isr);
		int n1, n2, usr, n = 1, level = 1, count = 3;

		do {
			n1 = (int) (Math.random() * 10 + 1);
			n2 = (int) (Math.random() * 10 + 1);
			switch (level) {
			case 1:
				System.out.print("��" + n + "�D:" + n1 + "+" + n2 + "=");
				String s1 = buf.readLine();
				usr = Integer.parseInt(s1);
				if (usr == n1 + n2) {
					System.out.println("���ߵ���!");
					level = level + 1;
					count = 3;
				} else
					System.out.println("��p����!");
				break;
			case 2:
				System.out.print("��" + n + "�D:" + n1 + "-" + n2 + "=");
				s1 = buf.readLine();
				usr = Integer.parseInt(s1);
				if (usr == n1 - n2) {
					System.out.println("���ߵ���!");
					level = level + 1;
					count = 3;
				} else {
					count = count - 1;
					System.out.println("��p����!��" + count + "�����|");
					if (count == 0) {
						level = level - 1;
						count = 3;
					}
				}
				break;
			case 3:
				System.out.print("��" + n + "�D:" + n1 + "*" + n2 + "=");
				s1 = buf.readLine();
				usr = Integer.parseInt(s1);
				if (usr == n1 * n2) {
					System.out.println("���ߵ���!");
					level = level + 1;
					count = 3;
				} else {
					count = count - 1;
					System.out.println("��p����!��" + count + "�����|");
					if (count == 0) {
						level = level - 1;
						count = 3;
					}
				}
				break;
			case 4:
				System.out.print("��" + n + "�D:" + n1 + "/" + n2 + "=");
				s1 = buf.readLine();
				usr = Integer.parseInt(s1);
				if (usr == n1 / n2) {
					System.out.println("���ߵ���!");
					level = level + 1;
					count = 3;
				} else {
					count = count - 1;
					System.out.println("��p����!��" + count + "�����|");
					if (count == 0) {
						level = level - 1;
						count = 3;
					}
				}
				break;
			}
			n++;
		} while (level != 5);
		System.out.println("�{������....");
	}
}