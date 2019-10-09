package arraymath;

import java.util.ArrayList;

public class AddOneIterative {

	static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		if (A == null || A.size() == 0)
			return null;

		int n = A.size();

		for (int i = 0; i < n - 1; i++) {
			if (A.get(i) == 0) {
				A.remove(i);
				i--;
				n--;
			} else {
				break;
			}
		}

		n = A.size();
		int k = 0;
		

		for (int i = n - 1; i >= 0; i--) {
			k = A.get(i) +1;

			if (k <= 9) {
				A.set(i, k);
				break;
			}

			else {
               //Carrying
			  	
			  A.set(i, k-10);
			  
			  
			  if(i==0) {
				 A.add(0,1);
				 return A;
			  }
			}

		} // end

		return A;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(9);
		arr.add(9);
		arr.add(9);

		for (int i : plusOne(arr)) {
			System.out.println(i);
		}
	}

}
