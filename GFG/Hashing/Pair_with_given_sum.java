/*
Given an array A of N positive integers and another number X. Determine whether or not there exist two elements in A whose sum is exactly X.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and X, N is the size of array. The 
second line of each test case contains N integers representing array elements A[i].

Output:
Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 16
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
Yes
Yes

Explanation:
Testcases 1: 10 and 6 are numbers making a pair whose sum is equal to 16.

**********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	    int n = sc.nextInt();
    	    int k = sc.nextInt();
    	    
    	    int a[] = new int[n];
    	    for(int i=0;i<n;i++)
    	        a[i] = sc.nextInt();
    	    
    	    boolean isExist = pairSum(a, k);
    	    //isExist == true ? System.out.println("Yes"):System.out.println("No");
    	    if(isExist == true)
    	        System.out.println("Yes");
    	    else
    	        System.out.println("No");
    	 }
	 }
	 
	 //We also can solve this using 2 pointer approach and for that we need to sort the array. So, time complexity : O(nlogn)
	 //Using Hashing - Time complexity : O(n), space complexity : O(n) 
	 static boolean pairSum(int a[], int k)
	 {
	     Set<Integer> s = new HashSet<Integer>();
	     
	     for(int i = 0; i < a.length; i++)
	     {
	         if(s.contains(k - a[i])) //checking the pair exists or not
	            return true;
	            
	         s.add(a[i]);  //adding all inputs into a HashSet 
	     }
	     
	     return false;
	 }
	 
}





