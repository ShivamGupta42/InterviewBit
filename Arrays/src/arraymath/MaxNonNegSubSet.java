package arraymath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MaxNonNegSubSet {

	static ArrayList<Integer> maxset(ArrayList<Integer> A) {

		int n = A.size();
		long sum = 0;
		long maxSum = Integer.MIN_VALUE;
		int startIndex = 0;

		HashMap<Integer, SegInfo> map = new HashMap<Integer, SegInfo>();
        
		// Problem with a code like this is that it is inherently dependent upon
		// the next value for our cutoff
		// If there is no next value then this code doesn't work

		for (int i = 0; i < n; i++) {

			if (A.get(i) < 0) {
				if (maxSum == sum) {
					map.put(startIndex, new SegInfo(maxSum, i - 1));
				}
				sum = 0;
				startIndex = i + 1;
			}

			else {
				sum += A.get(i);
				// I have to do equal to because because i need equal values also
				// I will comparing segmenet lengths if sums are same
				if (sum >= maxSum) {
					maxSum = sum;
				}
			}

		}

		if (maxSum == sum) {
			map.put(startIndex, new SegInfo(maxSum, n - 1));
		}

		if (map.size() == 0) {
			return new ArrayList<Integer>();
		}

		int maxLength = -1;
		int curLength = -1;

		maxSum = Long.MIN_VALUE;
		sum = 0;
		for (Entry<Integer, SegInfo> entry : map.entrySet()) {

			sum = entry.getValue().getMaxSum();

			if (sum > maxSum) {
				maxSum=sum;
				startIndex = entry.getKey();
				maxLength = entry.getValue().getEndIndex() - entry.getKey() + 1;
			}

			else if (sum == maxSum) {
				curLength = entry.getValue().getEndIndex() - entry.getKey() + 1;
				if (curLength > maxLength) {
					startIndex = entry.getKey();
					maxLength = curLength;
				}
			}

		}

		return new ArrayList<Integer>(A.subList(startIndex, startIndex + maxLength));
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		/*
		arr.add(0);
		arr.add(0);
		arr.add(-1);
		arr.add(0);
		*/
		
		//756898537 -1973594324 -2038664370 -184803526 1424268980 
		arr.add(756898537);
		arr.add(-1973594324);
		arr.add(-2038664370);
		arr.add(-184803526);
		arr.add(1424268980);
		
		for (int i : maxset(arr)) {
			System.out.println(i);
		}
	}

	static class SegInfo {
		long maxSum;
		int endIndex;

		public SegInfo(long maxSum, int endIndex) {
			this.endIndex = endIndex;
			this.maxSum = maxSum;
		}

		public long getMaxSum() {
			return maxSum;
		}

		public void setMaxSum(long maxSum) {
			this.maxSum = maxSum;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

	}

}
