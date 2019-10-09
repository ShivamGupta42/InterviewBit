package SubArrays;

public class AmazingSubArray {

	public int solve(String A) {
		if(A==null) return -1;
		char[] c = A.toLowerCase().toCharArray();
		int n = c.length;
        
		int count=0;
		for (int i = 0; i < n; i++) {
			if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
			count+=(n-i);
			}
		}

		return count%10003;
	}

}
