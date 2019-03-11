package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PowerSet {

	private static List<List<Integer>> powerSet(List<Integer> set, int index) {
		List<List<Integer>> powerSet;
		if (set.size() == index) {
			powerSet = new ArrayList<List<Integer>>();
			powerSet.add(new ArrayList<>());
			return powerSet;
		}
		powerSet = powerSet(set, index + 1);
		Integer value = set.get(index);
		List<List<Integer>> moreSubs = new ArrayList<List<Integer>>();
		for (List<Integer> sub : powerSet) {
			ArrayList<Integer> newSubset = new ArrayList<>();
			newSubset.add(value);
			newSubset.addAll(sub);
			moreSubs.add(newSubset);
		}
		powerSet.addAll(moreSubs);
		return powerSet;

	}

	public static void main(String[] args) {

		List<Integer> set = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 }));
		powerSet(set, 0).forEach(list -> {
			list.forEach(System.out::print);
			System.out.println();

		});
	}

}
