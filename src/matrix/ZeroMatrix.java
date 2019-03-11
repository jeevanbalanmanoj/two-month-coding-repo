package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroMatrix {

	public static void setZeroes(List<ArrayList<Integer>> a) {

		boolean rowHasZero = false;
		boolean colHasZero = false;

		for (Integer i : a.get(0)) {
			if (i == 0) {
				rowHasZero = true;
				break;
			}
		}

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).get(0) == 0) {
				colHasZero = true;
				break;
			}
		}

		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(0).size(); j++) {
				if (a.get(i).get(j) == 0) {
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);
				}
			}
		}

		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(0).size(); j++) {
				if (a.get(0).get(j) == 0 || a.get(i).get(0) == 0) {
					a.get(i).set(j, 0);
				}
			}
		}
		if (rowHasZero) {
			for (int j = 0; j < a.get(0).size(); j++)
				a.get(0).set(j, 0);
		}
		if (colHasZero) {
			for (int i = 0; i < a.size(); i++)
				a.get(i).set(0, 0);

		}

	}

	public static void main(String[] args) {

		Integer[][] twoDArray = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		ArrayList<ArrayList<Integer>> list = new ArrayList();
		for (Integer[] array : twoDArray) {
			// This will add int[] object into the list, and not the int values.
			list.add(new ArrayList<>(Arrays.asList(array)));
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(0).size(); j++) {
				System.out.print(list.get(i).get(j) + "\t");
			}
			System.out.println("");
		}

		setZeroes(list);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(0).size(); j++) {
				System.out.print(list.get(i).get(j) + "\t");
			}
			System.out.println("");
		}

	}

}
