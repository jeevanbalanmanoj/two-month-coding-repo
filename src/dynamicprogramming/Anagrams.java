package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

	private static List<String> getAnagrams(String str) {
		List<String> anagrams = new ArrayList<>();
		if (str.length() == 0) {
			anagrams.add("");
			return anagrams;
		}
		char first = str.charAt(0);
		str = str.substring(1);
		for( String anagram : getAnagrams(str)) {
		for(int i=0;i<=anagram.length() ;i++) {
			anagrams.add(insertCharAtIndex(first, anagram,i));
		}
		}
		return anagrams;
	}

	private static String insertCharAtIndex(char c, String str, int index) {
		String begin = str.substring(0, index);
		String end = str.substring(index);
		return begin + c + end;
	}

	public static void main(String[] args) {
		getAnagrams("jevan").forEach(System.out::println);
	}

}
