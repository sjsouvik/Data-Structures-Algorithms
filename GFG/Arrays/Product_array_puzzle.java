/*
Given an array A of size N, construct a Product Array P (of same size) such that P is equal to the product of all the elements of A except A[i].

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first 
line is N. The second line contains N elements separated by spaces.

Output:
For each testcase, print the Product array P.

Constraints:
1 <= T <= 10
1 <= N <= 1000
1 <= Ai <= 20

Example:
Input:
2
5
10 3 5 6 2
2
12 20
Output:
180 600 360 300 900
20 12

Explanation:
Testcase1: For the product array P, at i=0 we have 3*5*6*2. At i=1 10*5*6*2. At i=2 we have 10*3*6*2. At i=3 we have 10*3*5*2. At i=4 we have 10*3*5*6
So P is 180 600 360 300 900

********************************************************************Solution******************************************************************************/

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
	        
	         //productPuzzle(a, n);
	         productPuzzle2(a, n);
    	 }
	 }
	 
	 //Without using '/'' operator
	 static void productPuzzle2(long a[], int n)
	 {
	     long left[]=new long[n];
	     long right[]=new long[n];
	     
	     left[0]=1;
	     
	     //this is to store product of all elements in the subarray[0...i-1]
	     for(int i=1;i<n;i++)
	        left[i]=left[i-1] * a[i-1];
	        
	     //this is to store product of all elements in the subarray[i+1...n-1]
	     right[n-1]=1;     
	     for(int i=n-2;i>=0;i--)
	        right[i]=right[i+1] * a[i+1];
	        
	     for(int i=0;i<n;i++)
	     {
	         a[i]=left[i] * right[i];
	         System.out.print(a[i] + " ");
	     }
	     
	     System.out.println();   
	 }
	 
	 //using '/' operator
	 static void productPuzzle(long a[], int n)
	 {
	     long p=1;
	     
	     for(int i=0;i<n;i++)
    	    p*=a[i];
    	     
	     for(int i=0;i<n;i++)
	     {
	        a[i]=p/a[i];
	        System.out.print(a[i]+" ");
	     }
	     
	     System.out.println();
	 }
	 
}








