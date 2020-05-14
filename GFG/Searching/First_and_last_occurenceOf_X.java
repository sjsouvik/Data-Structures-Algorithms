/*
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array just print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case contains two integers n and x. The second line contains 
n spaced integers.

Output:
Print index of the first and last occurrences of the number x with a space in between.

Constraints: 
1<=T<=100
1<=n,a[i]<=1000

Example:
Input:
2
9 5
1 3 5 5 5 5 67 123 125
9 7
1 3 5 5 5 5 7 123 125

Output:
2 5
6 6

******************************************************************Solution***********************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
    	 //code
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, k, l, r;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     k=sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	   
    	     l = leftMostIndex(a, 0, n-1, k);
    	     
    	     if(l==-1)
    	        System.out.println(-1);
    	     else if(a[l+1]!=k)
    	        System.out.println(l+" "+l);
    	     else
    	     {
    	         r = rightMostIndex(a, l, n-1, k, n);
    	         System.out.println(l+" "+r);
    	     }
    	   }
	 }
	 
	 static int leftMostIndex(int a[], int l, int r, int k)
	 {
	     while(l<=r)
	     {
	         int m = l+((r-l)/2);
    	     if(a[m]==k && (a[m-1]!=k || m==0))
    	        return m;
    	     else if(a[m] >= k)
    	        r = m-1;
    	     else //if(a[m] < k)
    	        l=m+1;
	     }
	     
	     return -1;
	 }
	 
	 static int rightMostIndex(int a[], int l, int r, int k, int n)
	 {
	     while(l<=r)
	     {
	         int m = l+((r-l)/2);
    	     if(a[m]==k && (a[m+1]!=k || m==n-1))
    	        return m;
    	     else if(a[m] > k)
    	        r = m-1;
    	     else //if(a[m] <= k)
    	        l=m+1;
	     }
	     
	     return -1;
	 }
}















