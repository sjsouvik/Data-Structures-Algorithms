/*
Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line 
of each test case contains an Integer N denoting size of array and the second line contains N space separated 0 and 1.

Output:
For each test case, in a new line, print the count of required sub arrays in new line

Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubarrWithEqualZeroAndOne() which takes the array arr[] and the 
size of the array as inputs and returns the number of subarrays with equal number of 0s and 1s.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 106
0 <= A[i] <= 1

Example:
Input:
2
7
1 0 0 1 0 1 1
5
1 1 1 1 0
Output:
8
1

Explanation:
Testcase 1: The index range for the 8 sub-arrays are:
(0, 1), (2, 3), (0, 3), (3, 4), (4, 5)
(2, 5), (0, 5), (1, 6)
Testcase 2: The index range for the subarray is (3,4).

*********************************************************************Solution***************************************************************************/

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] a = new int[n];
	       for(int i=0;i<n;i++) {
	           a[i] = in.nextInt();
	       }
	       System.out.println(new countsubArray().countSubarrWithEqualZeroAndOne(a, n));
	   }
	 }
}


class countsubArray
{    
    static int countSubarrWithEqualZeroAndOne(int a[], int n)
    {
        for(int i = 0; i < n; i++) //replace all 0s in the array as -1 and this question will turn into count subarrays with zero sum 
        {
            if(a[i] == 0)
                a[i] -= 1;
        }
        
	//rest of the code is same as to count subarrays with zero sum 
        int prefixSum = 0, c = 0;
        
        Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        
        m.put(0, new ArrayList<Integer>());
        m.get(0).add(-1);
        
        for(int i = 0; i < n; i++)
        {
            prefixSum += a[i];
            
            ArrayList<Integer> l = new ArrayList<Integer>();
            
            if(m.containsKey(prefixSum))
            {
                l = m.get(prefixSum);
                
                for(Integer v : l)
                {
                    c++;
                    //System.out.println(v+1+"..."+i); //this is to print the start and end index of the subarray
                }
            }
            
            l.add(prefixSum);
            m.put(prefixSum, l);
        }
        
        return c;
    }
}



