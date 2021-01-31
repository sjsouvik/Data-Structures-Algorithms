/*
Question:-

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Input Format
A number n
.. n more elements

Output Format:-

A number representing the sum of elements of the increasing subsequence with maximum sum for the array.

Constraints:-

0 <= n <= 20
0 <= n1, n2, .. <= 100

Sample Input:-

10
10
22
9
33
21
50
41
60
80
1

Sample Output:-

255

************************************************************************************Solution**********************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println(maxSumIS(a));
    }
    
    /*Pre-requisite:- previous problem, Longest Increasing Subsequence(LIS). In LIS, we were counting 
    length of LIS, here we need to count max sum of LIS. This method will return the max sum of Increasing 
    Subsequence. The idea is to find max sum of increasing subsequence for each element ending at that 
    element. Now, the max of all the sums of increasing subsequences would be the max sum of Increasing Subsequence */
    static int maxSumIS(int a[]) {
        int dp[] = new int[a.length];

        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int max = 0;
            
            /* this part is to find the max sum of increasing subsequence's containing previous elements 
            which are less than or equal to the current element. Then, by adding current element we would 
            get increasing subsequence ending at current element and the sum would be (max sum of increasing 
            subsequence's containing previous elements + current element). */    
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j])
                    max = Integer.max(max, dp[j]);
            }

            dp[i] = max + a[i];

            maxSum = Integer.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}