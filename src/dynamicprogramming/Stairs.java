package dynamicprogramming;

public class Stairs {

	public static int ways(int n) {
		return fib(n + 1);
	}

	public static int fib(int n) {

		int memo[] = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		return fibImpl(n, memo);

	}

	private static int fibImpl(int n, int[] memo) {
		int fib = memo[n];
		if (n != 0 && fib == 0) {
			fib = fibImpl(n - 1, memo) + fibImpl(n - 2, memo);
			memo[n] = fib;
		}
		return fib;
	}

	public static void main(String[] args) {

		System.out.println(ways(2));
	}

}
