/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First 
line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

*****************************************************************Solution**********************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {    	 
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, c;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     Arrays.sort(a);
    	     
    	     c=0;
    	     
    	     for(int i=n-1;i > 1;i--)
    	     {
    	         if(findPair(a, 0, i-1, a[i]) > 0)    	         
    	             c+=findPair(a, 0, i-1, a[i]);    	         
    	     }
    	     
    	     if(c > 0)
    	        System.out.println(c);
    	     else
    	        System.out.println(-1);
    	 }
    	 
	 }
	 
	 static int findPair(int a[], int l, int r, int k)
	 {
	     int c=0;
	     
	     while(l<r)
	     {
	         if(a[l]+a[r]==k)
	         {
	            c++;
	            l++;
	            r--;
	         }
	         else if(a[l]+a[r] < k)
	            l++;
	         else
	            r--;
	     }
	     
	     return c;
	 }
	 
}



