/*
Given a sorted array A of size N. The array is rotated 'K' times. Find the value of 'K'. The array may contain duplicate elements.

Input:
The first line contains an integer T, depicting total number of test cases. T testcases follow. Each testcase contains two lines of input. The first line 
contains an integer N depicting the size of array. The next line contains elements of the array separated by spaces.

Output:
For each testcase, print the value of K.

Constraints:
1 <= T <= 100
1 <= N <=107
0 <= Ai <= 1018

Example:
Input
2
5
5 1 2 3 4
5
1 2 3 4 5
Output
1
0

Explanation:
Testcase1: 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.

*******************************************************************Solution*********************************************************************************/

import java.util.Scanner;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     long a[]=new long[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextLong();
    	        
    	     System.out.println(findNoOfRotation(a, n));   
    	 }
	 }
	 
	 static int findNoOfRotation(long a[], int n)
	 {
	     for(int i=0;i<n-1;i++)
	     {
	         if(a[i] > a[i+1])
	            return (i+1);
	     }
	     return 0;
	 }
	 
	 //Binary Search approach won't work if array contains duplicates, however we can use the below binary search approach if the array contains distinct elements 
	 /*static int findNoOfRotation(int a[], int l, int r)
	 {
	     int lastElement = a[r];
	     
	     while(l<=r)
	     {
	         int m=l+((r-l)/2);
	         
	         if(m > 0 && a[m] < a[m-1])
	            return m;
	         else if(m < (a.length - 1) && a[m] > a[m+1])
	            return m+1;   
	         else if(a[m] > lastElement)
	            l=m+1;
	         else //if(a[m] <= lastElement)
	            r=m-1;
	     }
	     
	     return 0;
	 }*/
	 
}



