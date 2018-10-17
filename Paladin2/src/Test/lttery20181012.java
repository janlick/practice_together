package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lttery20181012 {
	public static void main(String[] args) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		System.out.print("請問要幾組：");
		String amount = reader.readLine();
		int AmountToNum = Integer.parseInt(amount);

		int[] array = new int[6];
		int i, j;

		for (int k = 0; k < AmountToNum; k++) {

			for (i = 0; i < array.length; i++) {
				array[i] = (int) (Math.random() * 49 + 1);
			}

			for (j = 0; j < array.length; j++) {
				for (i = 0; i < j; i++) {
					while (array[i] == array[j])
						array[j] = (int) (Math.random() * 49 + 1);
				}
				System.out.print(array[j] + " ");
			}
			System.out.println("");
		}
	}
}