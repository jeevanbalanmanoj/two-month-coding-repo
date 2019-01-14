package dynamicprogramming;

public class LongestPalSubStr {

	public static void main(String[] args) {

		findLongestPalSubString("aamalayalamsd");
	}

	private static void findLongestPalSubString(String s) {

		char[] str = s.toCharArray();
		int len = s.length();
		int max = Integer.MIN_VALUE;
		int start = 0;
		boolean isPal[][] = new boolean[len][len];
		for (int i = 0; i < len; i++)
			isPal[i][i] = true;
		max = 1;
		for (int i = 0; i < len - 1; i++) {
			if (str[i] == str[i + 1]) {
				max = 2;
				isPal[i][i + 1] = true;
				start = i;
			}
		}
		for (int k = 3; k <= len; k++) {
			for (int i = 0; i < len - k + 1; i++) {
				int j = i + k - 1;
				if (str[i] == str[j] && isPal[i + 1][j - 1]) {
					isPal[i][j] = true;
					start = i;
					max = k;
				}
			}
		}
		for (int i = start; i < start + max; i++) {
			System.out.print(str[i]);
		}
	}

}
