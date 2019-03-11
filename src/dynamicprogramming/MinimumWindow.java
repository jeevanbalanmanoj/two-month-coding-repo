package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumWindow {

	public static String minWindow(String s, String t) {
		int minWindowSize = 0;
		int[] bestEndingHere = new int[s.length()];
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, -1);
		}
		PriorityQueue minHeap=new PriorityQueue();
		int start =-1;
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
			map.put(s.charAt(i), i);	
			}
		}

		return "";

	}

	public static void main(String[] args) {

		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
