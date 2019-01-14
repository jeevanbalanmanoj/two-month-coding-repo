package dynamicprogramming;

public class LongestCommonSubString {

	public static String LCS(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int maxRow = 0;
		int max = Integer.MIN_VALUE;
		int[][] table = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					table[i][j] = (i == 0 || j == 0) ? 1 : table[i - 1][j - 1] + 1;
					if (table[i][j] > max) {
						max = table[i][j];
						maxRow = i;
					}
				}
			}
		}
		if (max < 0)
			return "None";

		int i = maxRow;
		
		return s1.substring(i-max+1,i+1);
	}

	public static void main(String[] args) {

		System.out.println(LCS("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
	}

}
