package arraymath;

import java.util.ArrayList;


public class AddOneRecursive {

      static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
            if(A==null||A.size()==0) return null;
            
            int n = A.size();
            
            for(int i=0;i<n-1;i++) {
                if(A.get(i)==0) {
                    A.remove(i);
                    i--;
                    n--;
                } else {
                    break;
                }
            }
            A = add(A, n-1);
            return A;
        }
     
     
     static ArrayList<Integer> add(ArrayList<Integer> A, int a) {
         int k = A.get(a)+1;
        
         if(k>9) {
             A.set(a, k-10);
             
             if(a!=0) {
               return add(A,a-1);
             } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(1);
                temp.addAll(A);
                return temp;
             }
         }
         
         else{
             A.set(a,k);
             return A;
         }
         
     }
     
     public static void main(String[] args) {
	   ArrayList<Integer> arr = new ArrayList<Integer>();
	   arr.add(9);
	   arr.add(9);
	   arr.add(9);
    	 
	   for(int i: plusOne(arr)) {
		   System.out.println(i);
	   }
	}

    
}
