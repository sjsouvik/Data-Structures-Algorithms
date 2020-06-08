/*
Given an array of integers and a number K. Write a program to find the maximum sum of a subarray of size K.

Input:
First line of input contains a single integer T which denotes the number of test cases. Then T test cases follows. First line of each test case contains 
two space separated integers N and K where N denotes the number of elements. Second line of each test case contains N space separated integers which 
denotes the elements of the array.

Output:
For each test case print the maximum sum of a subarray of size K.

Constraints:
1<=T<=100
1<=N<=105
1<=K<=N

Example:
Input:
2
4 2
100 200 300 400
9 4
1 4 2 10 23 3 1 0 20
Output:
700
39

*********************************************************************Solution*******************************************************************************/

import java.util.Scanner;

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
    	     k=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     System.out.println(maxSum(a, n, k));   
    	 }
    	 
	 }
	 
	 static int maxSum(int a[], int n, int k)
	 {
	     int max=0, s=0;
	     
	     //Sum of 1st window of size 'k'
	     for(int i=0;i<k;i++)
	        s+=a[i];
	     
	     max = s;
	     
	     for(int i=k;i<n;i++)
	     {
	         //Sliding window technique : sums of remaining windows by removing first element of previous window and adding last element of current window
	         s=(s-a[i-k])+a[i];
	         
	         if(s > max)
	            max = s;
	     }
	      
	     return max;
	 }
	 
}




