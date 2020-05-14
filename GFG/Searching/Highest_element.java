/*
Given an array in such a way that the elements stored in array are in increasing order initially and then after reaching to a peak element , elements 
stored are in decreasing order. Find the highest element.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of an integer n. The next line 
consists of n spaced integers. 

Output:
Print the highest number in the array.

Constraints: 
1<=T<=100
1<=n<=200
1<=a[i]<=105

Example:
Input:
2
11
1 2 3 4 5 6 5 4 3 2 1
5
1 2 3 4 5 

Output:
6
5

****************************************************************************Solution***********************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
    	 //code
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	   
    	     System.out.println(highest(a, 0, n-1, n));   
    	 }
	 }
	 
	 static int highest(int a[], int l, int r, int n)
	 {
	     while(l<=r)
	     {
	         int m = l+((r-l)/2);
	         
	         if((m==0 || a[m] >= a[m-1]) && (m==n-1 || a[m] >= a[m+1]))
	            return a[m];
	         // if the middle element is smaller than its left neighbor then the peak element is there in the left half    
	         else if(m > 0 && a[m] < a[m-1])   
	            r=m-1;
	         // if the middle element is smaller than its right neighbor then there is always a peak element in the right half       
	         else // (m < n-1 && a[m] < a[m+1])
	            l=m+1;
	     }
	     
	     return -1;
	 }	 
}










