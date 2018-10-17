package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lottery20181012 {
	public static void main(String[] args) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		System.out.print("請問要幾組：");
		String amount = reader.readLine();
		int AmountToNum = Integer.parseInt(amount);

		int[][] array = new int[AmountToNum][6];
		int i, j=0;
		for (int k = 0; k < AmountToNum; k++) {
			for (i = 0; i < array[0].length; ) {
				array[k][i] = (int) (Math.random() * 6 + 1);
				for (j = 0; j < i; j++) {
					if(array[k][i]==array[k][j])
					{
					    break ;
					}
				}
				if(j==i)
				{
					System.out.print(array[k][i]+" ");
					i++;
				}
			}
			System.out.println("");
		}
	}
}