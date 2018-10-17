package Test;

public class Bingo20181015v3 {
	public static void main(String[] args) {

		int[][] Q = new int[1][4];
		int[][] A = new int[1000][4];
		int[][] All =new int [10000][4];
		for(int i=0;i<10000;i++)
		{
			All[i][0]=i/1000;
			All[i][1]=(i/100)%10;
			All[i][2]=(i/10)%10;
			All[i][3]=i%10;
		}
		int i, j, k = 0, l = 0, temp = 0;

		// 題目Q
		for (i = 0; i < 4; i++) {
			Q[0][i] = (int) (Math.random() * 10);
			for (j = 0; j < i; j++) {
				if (Q[0][i] == Q[0][j]) {
					i--;
					break;
				}
			}
		}
		System.out.print("Q=");
		for (i = 0; i < 4; i++)
			System.out.print(Q[0][i]);
		System.out.println("");

		// 產生答案A，若正確數字的數量=4，則跳出程序
		do {
			if (Q[0][k] != A[l][k] || A[l][k] == 0) {
				// 於A產生一組隨機數字，存於A的第l個一維陣列，l依次++
				for (i = k; i < 4; i++) {
					A[l][i] = (int) (Math.random() * 10);

					for (j = 0; j < i; j++) {
						if (A[l][i] == A[l][j]) {
							i--;
							break;
						}
					}
					// 檢查現在正在檢查的錯誤數字是否已產生過，若有則從這一位數字開始重新產生
					// temp是每出現一個正確數字後，從0起算的次數
					for (j = 1; j < temp + 1; j++) {
						if (A[l][k] == A[l - j][k]) {
							i--;
						}
					}
				}
			}
			// 檢查A的四個數字是否等於Q的四個數字，若有則跳出程序
			// 若沒有，檢查前三個數字是否等於，若有則下一次隨機數字從第四位開始產生
			// 若沒有，檢查兩個數字是否等於，若有則下一次隨機數字從後兩位開始產生
			// 若沒有，檢查是否有一個數字相等，若有則下一次隨機數字從後一位開始產生
			// 若沒有，重新任意產生一組隨機數字

			if (Q[0][0] == A[l][0] && Q[0][1] == A[l][1] && Q[0][2] == A[l][2] && Q[0][3] == A[l][3]) {
				k = 4;
				System.out.println("");
				System.out.println("right=" + k);
			}

			else if (Q[0][k] == A[l][k] && Q[0][k + 1] == A[l][k + 1] && Q[0][k + 2] == A[l][k + 2]) {
				k += 3;
				temp = 0;
				System.out.println("");
				System.out.println("right=" + k);
			}

			else if (Q[0][k] == A[l][k] && Q[0][k + 1] == A[l][k + 1]) {
				k += 2;
				temp = 0;
				System.out.println("");
				System.out.println("right=" + k);
			} else if (Q[0][k] == A[l][k]) {
				k++;
				temp = 0;
				System.out.println("");
				System.out.println("right=" + k);
			} else if (l == 0) {
				System.out.println("");
				System.out.println("right=" + k);
			}
			for (i = 0; i < k; i++) {
				A[l + 1][i] = A[l][i];
			}

			System.out.print("第" + (l + 1) + "次，");
			System.out.print("A=");
			for (i = 0; i < 4; i++)
				System.out.print(A[l][i]);
			// System.out.print("A[" + l + "][" + i + "]=" + A[l][i] + " ");
			System.out.println("");
			temp++;
			l++;

		} while (k < 4);
	}
}