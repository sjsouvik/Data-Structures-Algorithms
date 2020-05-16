/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. The task is to find the index of the 
given element K in the array A.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow. Each test case consists of three 
lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated 
integers denoting the elements of the array A. Third line of each test case contains an integer K denoting the element to be searched in the array.

Output:
Corresponding to each test case, output the index of the element found in the array.  If element is not present, then output -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ Ai ≤ 108
1 ≤ K ≤ 108

Example:
Input:
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6

Output:
5
1
-1

Explanation:
Testcase 1: 10 is found at index 5.

********************************************************************Solution*********************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 //code
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, k, pivot, index = -1;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	     
    	     k=sc.nextInt();
    	     
    	     //this is to divide the array into 2 sorted sub-arrays
    	     //this will get the index of the highest element of the 1st sorted sub-array
    	     //in other words, index of highest element of sorted rotated array
    	     pivot = getPivotIndex(a, 0, n-1);
    	     
    	     //if pivot==-1 i.e. there's no pivot element then the array is not rotated, we can perform binary search on the whole array then
    	     if(pivot==-1)
    	        index=binarySearch(a, 0, n-1, k);

    	     //if pivot == k then print the index   
    	     else if(a[pivot] == k)
    	        index=pivot;

    	     else if(k >= a[0])
    	        index=binarySearch(a, 0, pivot, k);
    	     else
    	        index=binarySearch(a, pivot+1, n-1, k);
    	        
    	     System.out.println(index);
    	 }
	 }
	 
	 static int getPivotIndex(int a[], int l, int r)
	 {
	     int last=a[r];
	     int n=r;
	     while(l<=r)
	     {
	         int m=l+((r-l)/2);
	         
	         //return the index of the element where the element is greater than its next element
	         if(m < n-1 && a[m] > a[m+1])
	            return m;
	         else if(a[m] > last)
	            l=m+1;
	         else //a[m] < last
	            r=m-1;
	     }
	     return -1;
	 }
	 
	 static int binarySearch(int a[], int l, int r, int k)
	 {
	     while(l<=r)
	     {
	         int m=l+((r-l)/2);
	         
	         if(a[m]==k)
	            return m;
	         else if(a[m] < k)
	            l=m+1;
	         else 
	            r=m-1;
	     }
	     
	     return -1;
	 }
	 
}













