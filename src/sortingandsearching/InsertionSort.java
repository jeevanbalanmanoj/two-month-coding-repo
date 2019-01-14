package sortingandsearching;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] a) {
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			int item = a[i];
			for (j = i - 1; j >= 0 && item < a[j]; j--)
				a[j + 1] = a[j];
			a[j + 1] = item;
		}
	}

	public static void main(String args[]) {

		int[] numbers = new int[] { 4, 2, 1, 6, 5, 7, 100, 23 };
		insertionSort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
	}
}
