package arraymath;

import java.util.ArrayList;

public class FlipBinString {

	public ArrayList<Integer> flip(String A) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		char[] c = A.toCharArray();
		int n = c.length;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			if (Character.getNumericValue(c[i]) == 0) {
				a[i] = -1;
			} else {
				a[i] = 1;
			}
			;
		}

		int sum = 0;
		int[] diffSum = new int[2 * n + 1];
		int startIndex = -1;
		int endIndex = -1;
		int minValue = Integer.MAX_VALUE;
		int[] preSum = new int[n];

		for (int i = 0; i < n; i++) {
			sum += a[i];
			preSum[i] = sum;

			if (sum < minValue) {
				minValue = sum;
				endIndex = i;
			}
		}

		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < endIndex; i++) {
			sum += a[i];
			if (sum > maxValue) {
				maxValue = sum;
				startIndex = i;
			}
		}

		for (int i = startIndex; i <= endIndex; i++) {
			arr.add(a[i]);
		}
		
		return arr;

	}
}
