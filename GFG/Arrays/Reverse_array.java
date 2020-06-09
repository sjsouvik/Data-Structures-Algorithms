/*
Given an array A of size N, print the reverse of it.

Input:
First line contains an integer denoting the test cases 'T'. T testcases follow. Each testcase contains two lines of input. First line contains N the size 
of the array A. The second line contains the elements of the array.

Output:
For each testcase, in a new line, print the array in reverse order.

Constraints:
1 <= T <= 100
1 <= N <=100
0 <= Ai <= 100

Example:
Input:
1
4
1 2 3 4
Output:
4 3 2 1

************************************************************************Solution*************************************************************************/

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
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     reverseArray(a, n);
    	     System.out.println();
    	 }
	 }
	 
	 static void reverseArray(int a[], int n)
	 {
	     int l=0, r=n-1, temp=0;
	     
	     while(l<=r)
	     {
	         temp=a[l];
	         a[l]=a[r];
	         a[r]=temp;
	         l++;
	         r--;
	     }
	     
	     for(int i=0;i<n;i++)
	        System.out.print(a[i]+" ");
	 }
	 
}







