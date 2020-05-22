/*
Given an sorted array A[i] of N positive integers having all the numbers occuring exactly twice, except for one number which will occur only once. Find 
the number occuring only once.

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases
follow. The first line of each test case contains a positive integer N, denoting the size of the array.
The second line of each test case contains a N positive integers, denoting the elements of the
array.


Output
Print out the singly occuring number.


Constraints
1 <= T  <= 100
0 <   N  <= 100
0 <= A[i] <= 100

Examples 

Input
2
5
1 1 2 5 5
7
2 2 5 5 20 30 30


Output
2
20
 

Expected Complexity

Time : O(N)

******************************************************************Solution*********************************************************************************/

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
	            
	         for(int i=0;i<n;i++)
	         {
	             if(i==n-1)
	             {
	                System.out.println(a[i]);
	                break;
	             }

	             if(a[i]!=a[i+1])
	             {
	                System.out.println(a[i]);
	                break;
	             }

	             i++;
	         }
	         
	     }
	    
	 }
}





