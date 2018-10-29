package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bingo20181002 {
	public static void main(String[] args) throws IOException {

		int n1, n2, n3, n4;
		n1 = (int) (Math.random() * 9);

		n2 = (int) (Math.random() * 9);
		while (n2 == n1)
			n2 = (int) (Math.random() * 9);

		n3 = (int) (Math.random() * 9);
		while (n3 == n1 || n3 == n2)
			n3 = (int) (Math.random() * 9);

		n4 = (int) (Math.random() * 9);
		while (n4 == n1 || n4 == n2 || n4 == n3)
			n4 = (int) (Math.random() * 9);

		String string1 = (Integer.toString(n1) + Integer.toString(n2) + Integer.toString(n3) + Integer.toString(n4));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		System.out.println("＊賓果遊戲＊　m(^__^)y");
		System.out.println("遊戲規則：請輸入4位不重複的數字，或輸入help以顯示答案");
		System.out.println("-START-");

		String string2 = reader.readLine();

		int i, j, countA, countB;
		int check = 0;

		while (true) {

			if (string2.equalsIgnoreCase("help")) {
				System.out.print("答案為：" + string1 + "  m(^__^)y");
				break;

			} else if (!string2.equals(string1))
				if (string2.length() == 4&&Bingo20181002.tryParseInt(string2)) {
					for (j = 1; j < string2.length(); j++)
						for (i = 0; i < j; i++)
							if (string2.charAt(i) != string2.charAt(j))
								check = 1;
							else {
								System.out.print("請輸入4位不重複的數字：");
								check = 0;
								string2 = reader.readLine();
								break;
							}
				} else {
					System.out.print("請輸入4位不重複的數字：");
					check = 0;
					string2 = reader.readLine();
					continue;
				}

			else {
				System.out.println("Bingo!");
				break;
			}

			while (check == 1 && string2.length() == 4) {
				countA = 0;
				countB = 0;

				if (string2.equalsIgnoreCase("help")) {
					break;
				}
				for (i = 0; i < string2.length(); i++) {
					if (string1.charAt(i) == string2.charAt(i)) {
						countA++;
					}
				}
				for (i = 0; i < string2.length(); i++) {
					for (j = 0; j < string2.length(); j++)
						if (string1.charAt(i) == string2.charAt(j)) {
							countB++;
						}
				}
				countB = countB - countA;
				if (countA == 4)
					break;
				else {
					System.out.println(string2 + " " + countA + "A" + countB + "B");
					string2 = reader.readLine();
					check = 0;
					continue;
				}
			}
		}
	}
	static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}