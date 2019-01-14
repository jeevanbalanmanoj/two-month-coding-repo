package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public static int LIS(int[] a) {

		int[] table = new int[a.length];
		for (int i = 0; i < table.length; i++)
			table[i] = 1;
		int max = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					table[i] = Math.max(table[i], table[j] + 1);
					max = Math.max(max, table[i]);
				}
			}

		}
		return max;
	}

	public static void main(String args[]) {

		int[] numbers = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(LIS(numbers));
	}

}
