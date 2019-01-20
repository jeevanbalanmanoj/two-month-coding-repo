package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class StairsWithSteps {

	public static ArrayList<ArrayList<Integer>> ways(int n) {
		return fib(n + 1);
	}

	public static ArrayList<ArrayList<Integer>> fib(int n) {

		ArrayList<ArrayList<Integer>> memo = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			memo.add(new ArrayList<>());
		}
		// int memo[] = new int[n + 1];
		// memo[0] = 0;
		// memo[1] = 1;
		// return fibImpl(n, memo);
		memo.get(0).add(0);
		memo.get(1).add(1);
		fibImpl(n, memo);
		return memo;

	}

	private static int fibImpl(int n, ArrayList<ArrayList<Integer>> memo) {
		int fib = memo.get(n).size();
		if (n != 0 && fib == 0) {
			fib = fibImpl(n - 1, memo) + fibImpl(n - 2, memo);
			memo.get(n).addAll(memo.get(n-1));
			memo.get(n).addAll(memo.get(n-2));
			memo.get(n).add(n);

		}
		return fib;
	}

	public static void main(String[] args) {

		for (ArrayList<Integer> arrayList : ways(2)) {
			for (Integer i : arrayList)
				System.out.print(i + " \t");
			System.out.println("");
		}
	}

}
