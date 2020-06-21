/*
Given an array A of integers. The task is to complete the function which returns an integer denoting the length of the longest sub-sequence such that 
elements in the sub-sequence are consecutive integers, the consecutive numbers can be in any order.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N. Then in the 
next line are N space separated values of the array A.

Output:
For each test case in a new line output will be the length of the longest consecutive increasing sub-sequence present in the array A[ ].

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai <= 108

Example(To be used only for expected output):
Input:
2
7
1 9 3 10 4 20 2
11
36 41 56 35 44 33 34 92 43 32 42
Output:
4
5

Explanation:
Testcase 1: Logest consecutive subsequence is 1, 2, 3, 4 of length 4.

*************************************************************************Solution***************************************************************************/

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class FindLongestSubsequence
{    
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
		    // Making object of GfG	
			GfG g = new GfG();
			
			System.out.println(g.findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}


class GfG
{    
    int findLongestConseqSubseq(int a[], int n)
    {	    
	    Arrays.sort(a);
	    
	    int c=1, ans=1;
	    
	    for(int i=0;i<n;i++)
	    {
	        if(i < n-1 && a[i+1] - a[i] == 1)
	        {
	            c++;
	            ans = Integer.max(ans, c);
	        }
	        else if(i < n-1 && a[i+1] - a[i] > 1)
	            c=1;
	    }
	    
	    return ans;
    }
}










