package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bingo20181016yiwei {
	int n1, n2, n3, n4;
	String string1;

	public Bingo20181016yiwei() {
		n1 = (int) (Math.random() * 10);// 隨機是0~1之間基本上0跟1不會出現 所以要*10 不然會隨機不到9
		n2 = (int) (Math.random() * 10);
		while (n2 == n1)
			n2 = (int) (Math.random() * 10);
		n3 = (int) (Math.random() * 10);
		while (n3 == n1 || n3 == n2)
			n3 = (int) (Math.random() * 10);
		n4 = (int) (Math.random() * 10);
		while (n4 == n1 || n4 == n2 || n4 == n3)
			n4 = (int) (Math.random() * 10);
		string1 = (Integer.toString(n1) + Integer.toString(n2) + Integer.toString(n3) + Integer.toString(n4));
		System.out.println("答案為：" + string1 + "  m(^__^)y");
	}

	public String guessnumber(String string2) {
		int i, j, countA, countB;
		countA = 0;
		countB = 0;
		if (string2.equalsIgnoreCase("help")) {
			return ("答案為：" + string1 + "  m(^__^)y");
		} else if (!string2.equals(string1)) {
			if (string2.length() == 4 && Bingo20181016yiwei.tryParseInt(string2)) {// 檢查長度 檢查是否為數字
				for (j = 1; j < string2.length(); j++)// 檢查重複
					for (i = 0; i < j; i++)
						if (string2.charAt(i) == string2.charAt(j)) {
							return ("請輸入4位不重複的數字：");
						}
				for (i = 0; i < string2.length(); i++) {// 德錚的檢查A
					if (string1.charAt(i) == string2.charAt(i)) {
						countA++;
					}
				}
				for (i = 0; i < string2.length(); i++) {// 德錚的檢查A+B
					for (j = 0; j < string2.length(); j++)
						if (string1.charAt(i) == string2.charAt(j)) {
							countB++;
						}
				}
				countB = countB - countA;
				return (countA + "A" + countB + "B");
			} else {
				return ("請輸入4位不重複的數字：");
			}
		} else {
			return ("Bingo!");
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println("＊賓果遊戲＊　m(^__^)y");
		System.out.println("遊戲規則：請輸入4位不重複的數字，或輸入help以顯示答案");
		System.out.println("-START-");
	//	InputStreamReader input = new InputStreamReader(System.in);
	//	BufferedReader reader = new BufferedReader(input);
		String string2;
		Bingo20181016yiwei bingo = new Bingo20181016yiwei();
		String respond;
		Guessbingo guess=new Guessbingo();
		int c=0;
		while (true) {
			c++;  //猜了幾次
			string2 = guess.guessone(); //要猜哪個數字
			System.out.print("猜第"+c+"次  guess  "+string2);  
			respond = bingo.guessnumber(string2);//拿到回應
			System.out.println("  answer:"+respond);
			if (respond.equals("Bingo!")) {
				System.out.println(respond);
				break;
			} else {
				guess.respond(string2, respond);  //把回應餵給猜數字的物件
				
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

class Guessbingo {
	boolean[] answer = new boolean[10000];//所有答案數會少於這個數字  也就是舉出所有可能

	public Guessbingo() {
		int k, j, countA, countB;
		countA = 0;
		countB = 0;
		for (int i = 0; i < 10000; i++) {      
			String string2 = String.format("%04d", i);      //把不到四位數的數字補0轉成字串
			for (j = 1; j < string2.length(); j++)          // 先去掉重複的數字
				for (k = 0; k < j; k++)
					if (string2.charAt(k) == string2.charAt(j)) {
						answer[i] = true;                           // 因為boolean預設會是false 所以我把不可能為答案的設成true;
						break;
					}
		}
	}

	public String guessone() {                         //從剩下的所有可能中 選一個出來 我這邊是隨意取第一個
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			if (answer[i] == false) {
				list.add(i);
				//System.out.println(String.format("%04d", i));
				//String returnString=String.format("%04d", i);
				//System.out.println("**"+returnString+"**");
				//return String.format("%04d", i);
			}
		}
		//return "";
		System.out.println(list.size());
		return String.format("%04d",list.get(list.size()-1));
		//return String.format("%04d",list.get(0));
	}

	public String respond(String string2, String respond) {    //得到猜題的回應後 把不可能的答案關掉(設成true)
		int  j, countA, countB;
		for (int k = 0; k < 10000; k++) {
			//System.out.println(k);
			if (answer[k] == false) {
				String string1 = String.format("%04d", k);
				countA = 0;
				countB = 0;
				for (int i = 0; i < string2.length(); i++) {// 德錚的檢查A
					if (string1.charAt(i) == string2.charAt(i)) {
						countA++;
					}
				}
				for (int i = 0; i < string2.length(); i++) {// 德錚的檢查A+B
					for (j = 0; j < string2.length(); j++)
						if (string1.charAt(i) == string2.charAt(j)) {
							countB++;
						}
				}
				countB = countB - countA;
				if (!(countA + "A" + countB + "B").equals(respond)) {
					answer[k] = true;
				}
			}

		}
		return "no answer";
	}

}
