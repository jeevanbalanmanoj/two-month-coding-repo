package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {
	static final int NO_OF_CHARS = 256;

	static int longestUniqueSubsttr(String str) {
		int n = str.length();
		int start=0;
		int maxStart=0;
		int cur_len = 0; // length of current substring
		int max_len = 0; // result
		int prev_index; // previous index
		int i;
		int visited[] = new int[NO_OF_CHARS];

		/*
		 * Initialize the visited array as -1, -1 is used to indicate that character has
		 * not been visited yet.
		 */
		for (i = 0; i < NO_OF_CHARS; i++) {
			visited[i] = -1;
		}

		for (i = 0; i < n; i++) {
			prev_index = visited[str.charAt(i)];

			/*
			 * If the current character is not present in the already processed substring or
			 * it is not part of the current NRCS, then do cur_len++
			 */
			if (prev_index == -1 || i - cur_len > prev_index) {
				cur_len++;
				if (cur_len > max_len) {
					max_len = cur_len;
					maxStart=start;
				}
			}

			/*
			 * If the current character is present in currently considered NRCS, then update
			 * NRCS to start from the next character of previous instance.
			 */
			else {
				start = prev_index + 1;
				cur_len = i - prev_index;
			}

			// update the index of current character
			visited[str.charAt(i)] = i;
		}
		System.out.println(str.substring(maxStart,maxStart+max_len));
		return max_len;
	}

	public static void main(String[] args) {

		System.out.println(longestUniqueSubsttr("ABABCEBDEF"));
		System.out.println(longest("ABABCEBDEF"));

	}

	private static String longest(String string) {
		char[] s = string.toCharArray();
		int end = 0;
		int start = 0;
		int count = 0;
		int maxStart = 0;
		int maxCount = Integer.MIN_VALUE;
		Set<Character> found = new HashSet<>();
		for (int i = 0; i < s.length; i++) {
			count = 0;
			start = i;
			found.clear();
			for (int j = i; j < s.length; j++) {
				if (found.contains(s[j])) {
					break;
				}
				count++;
				found.add(s[j]);
				if (count > maxCount) {
					maxCount = count;
					maxStart = start;
				}

			}
		}
		return string.substring(maxStart, maxStart + maxCount);
	}

}
