/*
Given an array containing N integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given 
value K.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line 
of each test case contains two Integers N and K and the second line contains N space separated elements of the array.

Output:
For each test case, print the required lenght of the longest Sub-Array in new line. If no such sub array can be formed print 0.

Constraints:
1<=T<=500
1<=N,K<=105
-105<=A[i]<=105

Example:
Input:
3
6 15
10 5 2 7 1 9
6 -5
-5 8 -14 2 4 12
3 6
-1 2 3
Output:
4
5
0
Explanation:
TestCase 1:

Input : arr[] = { 10, 5, 2, 7, 1, 9 }, 
K = 15
Output : 4
The sub-array is {5, 2, 7, 1}.

********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 int t, n, k;
    	 
    	 Scanner sc = new Scanner(System.in);
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     k = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     System.out.println(longestSubarray(a, n, k));   
    	 }
	 }
	 
	 static int longestSubarray(int a[], int n, int k)
	 {
	     Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	     
	     int prefixSum = 0, len = 0;
	     
	     for(int i = 0; i < n; i++)
	     {
	         prefixSum += a[i];
	         
	         if(m.containsKey(prefixSum - k)) //checking if prefixSum - given sum(k) exists in the map, if exists then need the differnce of current index and the index of (prefixSum - given sum) which is stored in the map as value
	             len = Integer.max(len, i - m.get(prefixSum - k));
	             
	         else if(prefixSum == k) //this is to handle the edge case where prefixSum == given sum(k), in this case subarray Sum contains all elements starting from index 0, that's why subarray length will be (cuurent index + 1) 
	             len = i + 1;
	             
	         if(!m.containsKey(prefixSum)) //will add the leftmost and unique prefixSum with index as value in the map since we need the max length of the subarray
	            m.put(prefixSum, i);
	     }
	     
	     return len;
	 }
	 
}




