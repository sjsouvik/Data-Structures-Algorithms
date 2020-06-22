/*
Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contigious subarray sum.

Input:
First line of input contains a single integer T which denotes the number of test cases. First line of each test case contains a single integer N which 
denotes the total number of elements. Second line of each test case contains N space separated integers denoting the elements of the array.

Output:
For each test case print the maximum sum obtained by adding the consecutive elements.

Constraints:
1 <= T <= 101
1 <= N <= 106
-106 <= Arr[i] <= 106

Example:
Input:
3
7
8 -8 9 -9 10 -11 12
8
10 -3 -4 7 6 5 -4 -1
8
-1 40 -14 7 6 5 -4 -1

Output:
22
23
52

Explanation:
Testcase 1: Starting from last element of the array, i.e, 12, and moving in circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which 
gives maximum sum as 22.

*************************************************************************Solution************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     System.out.println(maxCircularSubarraySum(a, n));   
    	 }
	 }
	 
	 
	 static boolean allNegatives(int a[], int n)
	 {
	     for(int i=0;i<n;i++)
	     {
	         if(a[i] > 0)
	            return false;
	     }
	     
	     return true;
	 }
	 
	 static int kadane(int a[], int n)
	 {
	     int max_till_here = 0, max_so_far = Integer.MIN_VALUE;
	     
	     for(int i=0;i<n;i++)
	     {
	         max_till_here+=a[i];
	         
	         if(max_till_here > max_so_far)
	            max_so_far = max_till_here;
	         
	         //since negative value will always decrease the total sum if we add any +/- value to it and we're trying to get the max subarray sum that's why we reset it to 0 
	         if(max_till_here < 0)
	            max_till_here = 0;
	     }
	     
	     return max_so_far;
	 }
	 
	 
	 static int maxCircularSubarraySum(int a[], int n)
	 {
	     int max, maxNegCircular, sum=0;
	     
	     //case 1 : get the maximum sum using standard kadane's algorithm 
	     max=kadane(a, n);
	     
	     /*if all elements are -ve then we simply use standard kadane's algo to find the max circular sum 
	     as the rest of the algo will return 0 always if all elements are -ve, why 0?? just follow the rest algo 
	     we'll understand why it'll return 0 always if all elements are -ve*/
	     if(allNegatives(a, n))
    	    return max;
	     
	     //case 2 : to find the maximum sum that includes corner elements. 
	     
	     //to get the sum of all elements, can also use loop for the same
	     sum=Arrays.stream(a).sum();
	     
	     //to negate(change the sign of all elements, invert array) all elements, can also use loop for the same 
	     Arrays.setAll(a, i -> -a[i]);
	     
	     /*
	     for(int i=0;i<n;i++)
	     {
	         sum+=a[i]; //to get the sum of all elements using loop
	         a[i]=-a[i]; //to negate all elements(change the sign of all elements, invert array) using loop
	     }
	     */
	     
	     
	     // max sum with corner elements will be: array-sum - (-max subarray sum of inverted array) 
	     // The maximum circular sum will be maximum of two sums
	     return Integer.max(max, sum - (-kadane(a, n)));
	 }
	 
}




