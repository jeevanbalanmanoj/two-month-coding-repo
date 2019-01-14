package arraysandstrings;

public class StringCompression {

	public static int getCompressedCount(String input) {

		int count = 0;
		int comCount = 0;
		for (int i = 0; i < input.length(); i++) {
			count++;

			if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
				comCount = 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return comCount;

	}

	public static String compress(String input) {
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			count++;

			if (i >= (input.length() - 1) || input.charAt(i) != input.charAt(i + 1)) {
				compressed.append(input.charAt(i) + "" + count);
				count = 0;
			}
		}

		return compressed.length() < input.length() ? compressed.toString() : input;
	}

	public static void main(String args[]) {
		String input = "aabcccccaaa";

		System.out.println(compress(input));
	}

}
