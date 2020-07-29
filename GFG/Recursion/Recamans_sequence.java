/*
Given an integer n. Print first n elements of Recaman’s sequence.
It is basically a function with domain and co-domain as natural numbers and 0. It is recursively defined as below:
Specifically, let a(n) denote the (n+1)-th term. (0 being already there).
The rule says:

a(0) = 0,
if n > 0 and the number is not 
   already included in the sequence,
     a(n) = a(n - 1) - n 
else 
     a(n) = a(n-1) + n. 

Examples:

Input : n = 6
Output : 0, 1, 3, 6, 2, 7

Input  : n = 17
Output : 0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 
         11, 22, 10, 23, 9, 24, 8


Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case in a new line print the space separated values of the first n elements of the Recaman's series.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
3
6
Output:
0 1 3
0 1 3 6 2 7

******************************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	     Scanner sc = new Scanner(System.in);
    	 
    	     int t, n;
    	 
    	     t = sc.nextInt();
    	 
    	     while(t-- > 0)
    	     {
    	         n = sc.nextInt();
    	     
    	         HashSet<Integer> set = new HashSet<Integer>();
    	     
    	         int a = recamansSequence(n, set);  
    	         System.out.println();
    	     }
	 }
	 
	 
	 static int recamansSequence(int n, HashSet<Integer> set)
	 {
	     if(n == 1)
	     {
	        System.out.print(0 + " ");
	        set.add(0);
	        return 0;
	     }
	     
             int a = recamansSequence(n - 1, set);
         
             int ans = a - (n - 1);
         
             //if ans > 0 and not already in the sequence then will take it as ans, otherwise will recalculate ans
	     if(ans > 0 && !set.contains(ans))
	     {
	        System.out.print(ans + " ");
	        set.add(ans);
	        return ans;
	     }
	     else
	     {
	        ans = a + (n - 1);
	         
	        System.out.print(ans + " ");
	        set.add(ans);
	        return ans;
	     }
	 }
}







