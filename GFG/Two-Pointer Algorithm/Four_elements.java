/*
Given an array A of N integers, find a combination of four elements in the array whose sum is equal to a given value X.

Input:
First line consists of T test cases. First line of every test case consists of an integer N, denoting the number of elements in an array. Second line 
consists of N spaced array elements. Third line of every test case X.

Output:
Single line output, print 1 if combination is found else 0.

Constraints:
1 <= T <= 100
1 <= N <= 106

Example:
Input:
1
6
1 5 1 0 6 0
7
Output:
1

Explantion:
Testcase 1: 1, 5, 1, 0 are the four elements which makes sum 7.

*********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    
	    int t, n, x, f;
	    
	    t=sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        n=sc.nextInt();
	        
	        int a[]=new int[n];
	        
	        for(int i=0;i<n;i++)
	            a[i]=sc.nextInt();
	        
	        x=sc.nextInt();
	            
	        Arrays.sort(a);    
	        
	        f=0;
	        for(int i=0;i<n-3;i++)
	        {
	            for(int j=i+1;j<n-2;j++)
	            {
	                if(findPair(a, j+1, n-1, x-(a[i]+a[j])))
	                {
	                    f=1;
	                    break;
	                }
	            }
	        }
	        
	        System.out.println(f);
	    }
	    
	 }
	 
	 static boolean findPair(int a[], int l, int r, int k)
	 {
	     while(l<r)
	     {
	         if(a[l]+a[r]==k)
	            return true;
	         else if(a[l]+a[r] > k)
	            r--;
	         else
	            l++;
	     }
	     
	     return false;
	 }
	 
}



