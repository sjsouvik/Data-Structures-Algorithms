/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

Input:
The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.

Output:
Print the Sub-array with maximum sum.

Constraints:
1 ≤ T ≤ 40
1 ≤ N ≤ 100
-100 ≤ A[i] ≤ 100

Example:
Input
2
3
1 2 3
2
-1  2
Output
1 2 3
2

********************************************************************Solution*********************************************************************************/

import java.util.*;
import java.io.*;

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
	        
    	     maxSumSubArray(a, n);
    	     System.out.println();
    	 }
	 }
	 
	 static void maxSumSubArray(int a[], int n)
	 {
	     int max_so_far=-1, max_till_here=0, start=0, s=0, end=0, len1=0, len2=0;
	     
	     for(int i=0;i<n;i++)
	     {
	         if(a[i] >= 0)
	            max_till_here+=a[i];
	         else
	         {
	             max_till_here=0;
	             s=i+1;
	         }
	         
	         if(max_till_here > max_so_far)
	         {
	            max_so_far=max_till_here;
	            start=s;
	            end=i;
	            len1=(end-start)+1;
	         }
	         
	         //this is to break the tie
	         if(max_till_here==max_so_far)
	         {
	             len2=(i-s)+1;
	             
	             if(len2 > len1)
	             {
	                 start=s;
	                 end=i;
	             }
	         }
	     }
	     
	     if(start!=end)
	     {
	         for(int i=start;i<=end;i++)
	            System.out.print(a[i]+" ");
	     }
	     else
	        System.out.print(a[start]);
	 }	 	 
}



