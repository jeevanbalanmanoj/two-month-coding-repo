package stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
	private static ArrayList<Integer> nearestSmaller(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		for (Integer a : A) {

			while (!stack.isEmpty() && stack.peek() >= a)
				stack.pop();
			if (stack.empty())
				result.add(-1);
			else
				result.add(stack.peek());
			stack.push(a);

		}

		return result;

	}

	public static void main(String args[]) {

		nearestSmaller(new ArrayList(Arrays.asList(new Integer[] { 4, 5, 2, 10, 8 }))).forEach(System.out::println);

	}

}
