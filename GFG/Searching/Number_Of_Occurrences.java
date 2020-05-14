/*
Given a sorted array A of size N and a number X, you need to find the number of occurrences of X in A.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input: The first 
line contains N and X(element whose occurrence needs to be counted). The second line contains the elements of the array separated by spaces.

Output:
For each testcase, print the count of the occurrences of X in the array, if count is zero then print -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 103
1 <= X <= 103

Example:
Input:
2
7 2
1 1 2 2 2 2 3
7 4
1 1 2 2 2 2 3
Output:
4
-1

Explanation:
Testcase 1: 2 occurs 4 times in 1 1 2 2 2 2 3
Testcase 2: 4 is not present in 1 1 2 2 2 2 3

*************************************************************************Solution***************************************************************************/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
    	 //code
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t = sc.nextInt();
    	 while(t-- > 0)
    	 {
    	     int n = sc.nextInt();
    	     int k = sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     for(int i=0;i<n;i++)
    	        a[i] = sc.nextInt();
    	     
    	     int l = leftMostIndex(a, 0, n-1, k);
    	     if(l==-1)
    	     {
    	        System.out.println(-1);
    	     }
    	     else
    	     {
        	     int r = rightMostIndex(a, l, n-1, k, n);
    	         System.out.println((r-l)+1);
    	     }
    	 }
	 }
	 
	 static int leftMostIndex(int a[], int l, int r, int k)
	 {
	     while(l <= r)
	     {
	         int mid = l + (r-l)/2;
	         if((a[mid] == k) && (mid == 0 || a[mid-1]!=k))
	            return mid;
	         else if(a[mid] >= k)
	            return leftMostIndex(a, l, mid-1, k);
	         else 
	            return leftMostIndex(a, mid+1, r, k);
	     }
	     return -1;
	 }
	 
	 static int rightMostIndex(int a[], int l, int r, int k, int n)
	 {
	      while(l <= r)
	     {
	         int mid = l + (r-l)/2;
	         if((a[mid] == k) && (mid == n-1 || a[mid+1]!=k))
	            return mid;
	         else if(a[mid] > k)
	            return rightMostIndex(a, l, mid-1, k, n);
	         else 
	            return rightMostIndex(a, mid+1, r, k, n);
	     }
	     return -1;
	 }
}




