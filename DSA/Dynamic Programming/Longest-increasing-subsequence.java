/*
Question:-

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest increasing subsequence of array.

Input Format:-

A number n
.. n more elements

Output Format:-

A number representing the length of longest increasing subsequence of array.

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

6

*********************************************************************************Solution********************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println(LIS(a));
    }

    //Time complexity - O(n^2)
    /* LIS - Longest Increasing Subsequence. This method will return the length of LIS. The idea is to find 
    length of increasing subsequence for each element ending at that element. Now, the max of all the 
    lengths of increasing subsequence would be the length of LIS. */ 
    static int LIS(int a[]) {
        int dp[] = new int[a.length];
        int lengthOfLIS = 1;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            /* this part is to find the max length of increasing subsequence's containing previous elements 
            which are less than or equal to the current element. Then, by adding current element we would 
            get increasing subsequence ending at current element and the length would be (max length of 
            increasing subsequence's containing previous elements + 1). */
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j])
                    max = Integer.max(max, dp[j]);
            }

            dp[i] = max + 1;
            lengthOfLIS = Integer.max(lengthOfLIS, dp[i]);
        }

        return lengthOfLIS;
    }
}