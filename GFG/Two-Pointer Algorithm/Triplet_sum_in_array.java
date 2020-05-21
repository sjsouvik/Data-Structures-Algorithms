/*
Given an array A[] of N numbers and another number x, determine whether or not there exist three elements in A[] whose sum is exactly x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains n and x. Next line contains array elements.

Output:
Print 1 if there exist three elements in A whose sum is exactly x, else 0.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 13
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
1
1

Explanation:
Testcase 1: There is one triplet with sum 13 in the array. Triplet elements are 1, 4, 8, whose sum is 13.

************************************************************************Solution****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 //code
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, x;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     x=sc.nextInt();
    	     int f=0;
    	     
    	     int a[]=new int[n];
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     Arrays.sort(a);
    	     
    	     for(int i=0;i<n-2;i++)
    	     {
    	         if(findPair(a, i+1, n-1, x-a[i]))
    	         {
    	             f=1;
    	            System.out.println(1);
    	            break;
    	         }
    	     }
    	     
    	     if(f==0)
    	        System.out.println(0);
    	 }
    	 
	 }
	 
	 static boolean findPair(int a[], int l, int r, int k)
	 {
	     while(l<r)
	     {
	         if(a[l]+a[r]==k)
	            return true;
	         else if(a[l]+a[r] < k)
	            l++;
	         else
	            r--;
	     }
	     
	     return false;
	 }
	 
}



