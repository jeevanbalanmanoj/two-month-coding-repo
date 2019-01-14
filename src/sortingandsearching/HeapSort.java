package sortingandsearching;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {

		int[] numbers = new int[] { 4, 2, 1, 6, 5, 7, 100, 23 };
		heapSort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);

	}

	private static void heapSort(int[] a) {
		heapSort(a, a.length - 1);
	}

	private static void heapSort(int[] a, int size) {

		buildMaxHeap(a, size);
		int temp = 0;
		for (int i = size; i >= 0; i--) {
			temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			maxHeapify(a, 0, i-1);
		}

	}

	private static void buildMaxHeap(int[] a, int size) {
		for (int i =size / 2; i >= 0; i--)
			maxHeapify(a, i, size);
	}

	private static void maxHeapify(int[] a, int i, int size) {

		int l = 2 * i + 1;
		int temp = 0;
		int r = 2 * i + 2;
		int largest = i;
		if (l <= size && a[l] > a[i])
			largest = l;

		if (r <= size && a[r] > a[largest])
			largest = r;

		if (largest != i) {
			temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			maxHeapify(a, largest, size);
		}

	}

}
