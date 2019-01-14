package sortingandsearching;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void merge(int[] a, int start, int mid, int end) {

		int lA = mid - start + 1;
		int lB = end - mid;
		int[] A = new int[lA];
		int[] B = new int[lB];

		// copy values

		for (int i = 0; i < lA; i++)
			A[i] = a[start + i];
		for (int i = 0; i < lB; i++)
			B[i] = a[mid + 1 + i];

		int i = 0;
		int j = 0;
		int k = start;
		while (i < lA && j < lB) {
			if (A[i] < B[j]) {
				a[k] = A[i];
				i++;
			} else {
				a[k] = B[j];
				j++;
			}
			k++;
		}
		while (i < lA)
			a[k++] = A[i++];
		while (j < lB)
			a[k++] = B[j++];

	}

	public static void mergeSort(int[] a, int start, int end) {

		if (start == end)
			return;
		int mid = (start + end) / 2;
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);
		merge(a, start, mid, end);

	}

	public static void main(String args[]) {

		int[] numbers = new int[] { 4, 2, 1, 6, 5, 7, 100 };
		mergeSort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
	}

}
