package dynamicprogramming;

public class BarGraphWater {

	public static int getVolume(int[] bar) {
		int max = 0;
		int[] maxL = new int[bar.length];
		int[] maxR = new int[bar.length];
		int volume = 0;
		// Get the largest bar on the left
		for (int i = 0; i < bar.length; i++) {
			maxL[i] = max;
			max = Math.max(max, bar[i]);
		}
		max = 0;
		// Get the largest bar on the right
		for (int i = bar.length - 1; i >= 0; i--) {
			maxR[i] = max;
			max = Math.max(max, bar[i]);
		}
		// water collected will be (smallest of two maximas - height of the current bar) 
		// or zero if the result is negative )
		for (int i = 0; i < bar.length; i++) {
			int min = Math.min(maxR[i], maxL[i]);
			volume += Math.max(0, min - bar[i]);
		}
		return volume;
	}

	public static void main(String args[]) {

		int bar[] = new int[] { 5, 2, 5 };
		System.out.println(getVolume(bar));
		bar = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(getVolume(bar));
	}

}
