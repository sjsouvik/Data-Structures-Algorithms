/*
Given an unsorted array Arr[] and a number N. You need to write a program to find if there exists a pair of elements in the array whose difference is N.

Input:
First line of input contains an integer T which denotes the number of test cases. Then T test cases follows. First line of each test case contains two 
space separated integers L and N where L denotes the length of array or the number of elements in the array and N denotes the difference between two 
elements. Second line of each test case contains L space separated integers which denotes the elements of the array.

Output:
For each test case, in a new line print 1 if the pair is found otherwise print -1 if there does not exist any such pair.

Constraints:
1<=T<=100
1<=L<=104
1<=Arr[i]<=105

Example:
Input:
2
6 78
5 20 3 2 5 80
5 45
90 70 20 80 50
Output:
1
-1

*******************************************************************Solution********************************************************************************/

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
	         
	         k=sc.nextInt();
	         
	         for(int i=0;i<n;i++)
	            a[i]=sc.nextInt();
	         
	         Arrays.sort(a);	         	         
    	     
	         System.out.println(findPair(a, 0, 0, k));
	     }
	 }
	 
	 static int findPair(int a[], int l, int r, int k)
	 {
	     int n=a.length;
	     
	     //for some testcases the a[r] - a[l] could be '0' so that must be handled in the code - trickiest part of the problem
	     while((l <= r) && (r < n))
	     {
	         if(a[r] - a[l] == k)
	            return 1;
	         else if(a[r] - a[l] > k)
	            l++;
	         else 
	            r++;
	     }
	     
	     return -1;
	 }
	 
}





