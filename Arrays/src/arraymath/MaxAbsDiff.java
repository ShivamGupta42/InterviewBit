package arraymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAbsDiff {

	public int maxArr(ArrayList<Integer> A) {
		if(A==null||A.size()==0) {
			return -1;
		}
		
		int n = A.size();
		int maxFunc=-1;
		int curFunc=-1;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				curFunc=Math.abs(A.get(j)-A.get(i))+j-i;
				if(curFunc>maxFunc) {
					maxFunc=curFunc;
				}
			}
		}

		return maxFunc;
	}
	
	
	static int maxArr2(List<Integer> A) {
		if(A==null||A.size()==0) {
			return -1;
		}
		
		int n = A.size();
		int maxFunc=-1;
		int curFunc=-1;
		
		int max=Integer.MIN_VALUE;
		int maxIndex=-1;
		
		for(int i=0;i<n;i++) {
			if(Math.abs(A.get(i))>max) {
				max=A.get(i);
				maxIndex=i;
			}
			else if(A.get(i)==max) {
				maxIndex=i;
			}
		}
		
		for(int i=0;i<n;i++) {
			A.set(i, Math.abs(max-A.get(i))+Math.abs(i-maxIndex));
		}
		
		

		return A.parallelStream().max((a,b)->a-b).get();
	}
	
	public static void main(String[] args) {
		System.out.println(maxArr2(Arrays.asList(64, -11, 79, -4, -87, -38, 26, -96, 23, 29 )));
	}

	
	
}
