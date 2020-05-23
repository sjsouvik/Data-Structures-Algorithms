/*
Find the missing element from  an ordered array A[ ], consisting of N elements representing an Arithmetic Progression (AP) .
 

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
The first line of each test case contains an integer N, where N is the size of the array A[ ].
The second line of each test case contains N space separated integers of an Arithmetic Progression denoting elements of the array A[ ].
 

Note: The series should have a missing element in between a perfect A.P. with no missing element will not be considered.
 

Output:
Print out the missing element. 
 

Constraints:
1 <= T <= 100
2 <= N <= 10
-50 <= A[i] <=50
 

Examples :

Input:
3
3 
2 10 14 
4 
-28 -21 -7 0 
5 
9 12 15 21 24

Output : 
6
-14
18

*******************************************************************Solution*******************************************************************************/

/****************************************************************Approach 1 : Linear Search**********************************************/

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
    	   
    	     System.out.println(findMissing(a, n));   
    	 }
	 }
	 
	 static int findMissing(int a[], int n)
	 {
	     int d=(a[n-1] - a[0])/n;
	     
	     for(int i=0;i<n-1;i++)
	     {
	         if(a[i+1] - a[i] != d)
	            return (a[i] + d);
	     }
	     
	     return -1;
	 }
	 	 
}


/**********************************************************Approach 2 : Binary Search****************************************************/


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
    	   
    	     System.out.println(findMissing(a, n));   
    	 }
	 }
	 
	 static int findMissing(int a[], int n)
	 {
	     int d, l, r, m;
	     
	     d=(a[n-1] - a[0])/n;
	     
	     l=0;
	     r=n-1;
	     
	     while(l<=r)
	     {
	         m = l+((r-l)/2);
	         
	         if(m < n-1 && a[m+1] - a[m] != d)
	            return (a[m]+d);
	         else if(m > 0 && a[m] - a[m-1] != d)
	            return (a[m-1] + d);
	         else if(a[0] + m*d == a[m])
	            l=m+1;
	         else   //if(a[0] + m*d != a[m])
	            r=m-1;
	     }
	     
	     return -1;
	 }
	 
}





