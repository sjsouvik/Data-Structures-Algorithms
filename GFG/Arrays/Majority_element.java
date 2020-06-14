/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than 
N/2 times in the array.

Input:  
The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be 
the elements of the array.

Output: 
For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.

Constraints:
1 <= T<= 100
1 <= N <= 107
0 <= Ai <= 106

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1

Explanation:
Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.

*********************************************************************Solution*******************************************************************************/

import java.util.Scanner;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, m;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
	        
    	     m=findMajority(a, n);
    	     
    	     System.out.println(isMajority(a, m) ? m : -1);
    	 }
	 }
	 
	 //to check whether the returned element from findMajority() is majority or not
	 static boolean isMajority(int a[], int m)
	 {
	     int c=0;
	     
	     for(int i=0;i<a.length;i++)
	     {
	         if(a[i]==m)
	            c++;
	     }
	     
	     return (c > a.length/2 ? true : false);
	 }
	 
	 /*Boyer-Moore's Majority Vote Algo - this will return one element which might be the majority element, 
	 so we need to explicitly check whether it's majority element or not*/
	 static int findMajority(int a[], int n)
	 {
	     int count=0, m=-1;
	     
	     for(int i=0;i<n;i++)
	     {
	         if(count==0)
	         {
	             m=a[i];
	             count=1;
	         }
	         else if(a[i]==m)
	            count++;
	         else
	            count--;
	     }
	     
	     return m;
	 }
	 
}








