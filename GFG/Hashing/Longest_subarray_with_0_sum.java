/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. Each test case consists of 2 lines. The first 
line of each test case contains a number denoting the size of the array A. Then in the next line are space-separated values of the array A.

Output:
For each test case, the output will be the length of the largest subarray which has sum 0.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function maxLen() which takes two arguments an array 
A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 104
-1000 <= A[i] <= 1000, for each valid i

Example:
Input
1
8
15 -2 2 -8 1 7 10 23

Output
5

Explanation
Testcase 1: In the above test case the largest subarray with sum 0 will be -2 2 -8 1 7.

******************************************************************Solution**********************************************************************************/

import java.util.*;

class MaxLenZeroSumSub
{  
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}


class GfG
{
    int maxLen(int a[], int n)
    {
        int c = 0, prefixSum = 0;
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; i++)
        {
            prefixSum += a[i];
            
            if(prefixSum == 0) //this is to handle the edge cases where prefixSum == givenSum, here given sum == 0
                c = i + 1;
            else if(! m.containsKey(prefixSum)) //will add the left most prefixSum if there are duplicates of prefixSum as we need the longest subarray
                m.put(prefixSum, i);
            else if(m.containsKey(prefixSum)) //checking if the current (prefixSum - givenSum) exists in the map and if exists, we need the difference of index, here, givenSum == 0    
                c = Integer.max(c, i - m.get(prefixSum));
        }
        
        
        return c;
    }
}




