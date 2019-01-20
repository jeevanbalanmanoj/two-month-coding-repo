package numbers;

import java.math.BigInteger;

public class SquareRoot {

	private static int sqrtSlow(int x) {
		int maxRoot = 0;
		long square = 1;
		for (int i = 1; i <= x / 2; i++) {
			square = i * i;
			if (square > x)
				return maxRoot;
			if (square == x)
				return i;
			maxRoot = i;
		}

		return maxRoot;
	}

	private static int sqrt(int a) {
		if (a == 0 || a == 1)
			return a;

		long mid = 0;
		long start = 1;
		long end = a;
		long ans = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid == a)
				return (int) mid;

			if (mid * mid < a) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}
		return (int) ans;

	}

	public static void main(String[] args) {

		System.out.println(sqrt(2147483647));

	}

}
