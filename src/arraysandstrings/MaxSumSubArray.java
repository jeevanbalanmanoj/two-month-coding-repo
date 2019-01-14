package arraysandstrings;

import java.util.Arrays;

public class MaxSumSubArray {

	public static void maxSum(int[] a) {
		int j = 0;
		int currSum = 0;
		int maxSum = a[0];
		int start=0;
		int maxEnd = 0;
		int maxStart = 0;
		

		for (int i = 0; i < a.length; i++) {
			currSum += a[i];
			if (currSum < 0) {
				currSum = 0;
				start=i+1;
				
			}
			if (currSum > maxSum) {
				maxStart=start;
				maxSum = currSum;
				maxEnd=i;
			}
		}
		System.out.println(maxSum+" start : "+maxStart+" end : " +maxEnd);
	}

	public static void main(String args[]) {

		int[] numbers = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		maxSum(numbers);
	}

}
