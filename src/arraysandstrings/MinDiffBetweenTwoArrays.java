package arraysandstrings;

import java.util.Arrays;

public class MinDiffBetweenTwoArrays {

	public static int findMin(int[] a, int[] b) {

		Arrays.sort(a);
		Arrays.sort(b);
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int dif = 0;
		while (i < a.length && j < b.length) {
			dif = Math.abs(a[i] - b[j]);
			if (dif < min) {
				min = dif;
			}
			if (a[i] >= b[j]) {
				j++;
			} else
				i++;
		}
		return min;
	}

	public static void main(String args[]) {

		int[] a = new int[] { 1, 3, 15, 11, 2 };
		int[] b = new int[] { 23, 127, 235, 19, 8 };

		System.out.println(findMin(a, b));
	}

}
