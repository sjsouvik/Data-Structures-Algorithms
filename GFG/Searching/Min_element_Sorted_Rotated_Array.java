/*
A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Expected Time Complexity: O(Log n)

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. 
The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, in a new line, print the minimum element in the array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 500
1 ≤ A[i] ≤ 1000

Example:

Input
2
5
4 5 1 2 3
6
10 20 30 40 50 5 7

Output
1
5

*****************************************************************Solution***********************************************************************************/

import java.util.Scanner;
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
    	     
    	     System.out.println(searchSortedRotatedArray(a, 0, n-1));   
    	 }
	 }
	 
	 static int searchSortedRotatedArray(int a[], int l, int r)
	 {
	     int last = a[r];
	     
	     while(l<=r)
	     {
	         int m=l+((r-l)/2);
	         
	         //if the mid element is smaller than its previous element then that's the min elelment of the rotated array
	         if(m > 0 && a[m] < a[m-1])
	            return a[m];
	         //if the mid element is greater than the last elelment then the min element is on the right half   
	         if(a[m] > last)
	            l=m+1;
	         //if the mid element is smaller than the last elelment then the min element is on the left half      
	         else //a[m] < last 
	            r=m-1;
	     }
	     
	     return a[0]; // this is to return the 1st element of the array if the array is not rotated
	 }
}








