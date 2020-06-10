/*
Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides 
of triangles. 

Input: 
The first line of the input contains T denoting the number of testcases. First line of test case is the length of array N and second line of test case are 
its elements.

Output:
Number of possible triangles are displayed to the user.

Constraints:
1 <= T <= 200
3 <= N <= 107
1 <= arr[i] <= 103

Example:
Input:
2
3
3 5 4
5
6 4 9 7 8

Output:
1
10

***********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, k;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
	        
    	     System.out.println(countTriangles(a, n));
    	 }
	 }
	 
	 static long countTriangles(int a[], int n)
	 {
	     long c=0; 
	     int k=0;
	     
	     Arrays.sort(a);
	     
	     for(int i=0;i<n-2;i++)
	     {
	         k=i+2;
	         
	         for(int j=i+1;j<n-1;j++)
	         {
	             while(k<n && a[i]+a[j] > a[k])
	             {
	                 k++;
	             }
	             
	             k--; // k is decremented as k is incremented one extra in the above while loop
	             
	             if(k > j)
	                c+=k-j;
	         }
	     }
	     
	     return c;
	 }
	 
}





