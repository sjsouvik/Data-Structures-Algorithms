/*
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much 
water can be trapped in between blocks after raining.

Structure is like below:
| |
|_|

We can trap 2 units of water in the middle gap.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an 
integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.

*********************************************************************Solution*****************************************************************************/

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
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
    	        
    	     System.out.println(trappingWater2(a, n));   
    	 }
	 }
	 
	 ////time : O(n), space : O(1)
	 static int trappingWater2(int a[], int n)
	 {
	     int left=0, right=n-1, maxLeft=a[left], maxRight=a[right], water=0;
	     
	     while(left < right)
	     {
	         if(a[left] <= a[right])
	         {
	             left++;
	             maxLeft=Integer.max(maxLeft, a[left]);
	             water+=(maxLeft - a[left]);
	         }
	         else
	         {
	             right--;
	             maxRight=Integer.max(maxRight, a[right]);
	             water+=(maxRight - a[right]);
	         }
	     }
	     
	     return water;
	 }
	 
	 
	 //time : O(n), space : O(n)
	 static int trappingWater(int a[], int n)
	 {
	     int water=0;
	     
	     int maxLeft[] = new int[n]; //this is to store max left bar's height for each element
	     
	     maxLeft[0]=-1; //for the 1st element, there's no left bar
	     
	     for(int i=1;i<n;i++)
	     {
	         maxLeft[i] = Integer.max(maxLeft[i-1], a[i-1]);
	     }
	     
	     int maxRight=-1; //this is to store max right bar's height for each element and for the last element, there's no right bar
	     
	     for(int i=n-2;i>=1;i--)
	     {
	         maxRight=Integer.max(maxRight, a[i+1]);
	         
	         if(Integer.min(maxLeft[i], maxRight) > a[i])
	            water+=(Integer.min(maxLeft[i], maxRight) - a[i]);
	     }
	     
	     return water;
	 }
}




