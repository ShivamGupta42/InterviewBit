package SubArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class StringHolics {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("ababa");
		arr.add("aba");
		System.out.println(solve(arr));
	}

	public static int solve(ArrayList<String> A) {
		HashMap<Long, Integer> map = new HashMap<Long, Integer>(A.size());

		long curTime = 0;
		for (int i = 0; i < A.size(); i++) {
			curTime = calcTime(A.get(i));
			if (!map.containsKey(curTime)) {
				map.put(curTime, 1);
			} else {
				map.put(curTime, map.get(curTime) + 1);
			}

		}

		int maxFreq = 0;
		curTime = 0;
		for (Entry<Long, Integer> e : map.entrySet()) {
			if (e.getValue() > maxFreq) {
				maxFreq = e.getValue();
				curTime = e.getKey();
			}
		} // end

		return (int) curTime % (10 ^ 9 + 7);
	}

	private static long calcTime(String string) {
		
	}
	
	
}
