package arraysandstrings;

public class MajorityElement {

	public static void main(String[] args) {
		int[] numbers = new int[] {3, 3, 4, 2, 4, 4, 2, 4, 4};
		majorityElement(numbers);
	}

	private static void majorityElement(int[] numbers) {
		int majIndex = 0;
		int count = 1;
		int finalCount = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[majIndex] == numbers[i]) {
				count++;
			} else
				count--;
			if (count == 0) {
				count = 1;
				majIndex = i;
			}

		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[majIndex] == numbers[i])
				finalCount++;
		}
		if (finalCount > numbers.length / 2)
			System.out.println(numbers[majIndex]);
		else
			System.out.println("None");
	}
}
