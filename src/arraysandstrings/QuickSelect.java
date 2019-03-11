package arraysandstrings;

public class QuickSelect {

	private static int parititon(int a[], int start, int end) {

		int pivot = a[start];
		int wall = start + 1, temp = 0;
		for (int i = start + 1; i <= end; i++) {
			if (a[i] < pivot) {
				temp = a[i];
				a[i] = a[wall];
				a[wall] = temp;
				wall++;
			}
		}
		wall--;
		a[start] = a[wall];
		a[wall] = pivot;
		return wall;

	}

	private static int kthSmallest(int a[], int k) {
		if (k > a.length)
			throw new RuntimeException("invalid input");
		k--;
		int i = 0;
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			i = parititon(a, start, end);
			if (i == k)
				return a[i];
			if (i < k)
				start = i + 1;
			else
				end = i - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		int n = 3;
		System.out.println(kthSmallest(new int[] { 10, 4, 5, 8, 6, 11, 26 }, n));
	}

}
