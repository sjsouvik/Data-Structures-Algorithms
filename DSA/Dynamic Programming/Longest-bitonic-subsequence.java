/*
Question:-

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.

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

7

*************************************************************************************Solution***************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        System.out.println(LBS(a));    
    }
    
    //LBS - Longest Bitonic Subsequence, LIS - Longest Increasing Subsequence, LDS - Longest Decreasing Subsequence
    /* The idea is to store length of LIS for each element ending at that element and length 
    LDS(we'll traverse from right end of the array to get this value for each item) starting at that element. 
    Then, max(length of LIS + length of LDS - 1) will give the length of LBS or no of elements present in the LBS */
    static int LBS(int a[])
    {
        int n = a.length;
        int LIS[] = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            int max = 0;
            
            for(int j = 0; j < i; j++)
            {
                if(a[i] >= a[j])
                    max = Integer.max(max, LIS[j]);
            }
            
            LIS[i] = max + 1;
        }
        
        int LDS[] = new int[n];
        
        for(int i = n - 1; i >= 0; i--)
        {
            int max = 0;
            
            for(int j = n - 1; j > i; j--)
            {
                if(a[i] >= a[j])
                    max = Integer.max(max, LDS[j]);
            }
            
            LDS[i] = max + 1;
        }
        
        int lengthOfLBS = 1;
        for(int i = 0; i < n; i++)
            lengthOfLBS = Integer.max(lengthOfLBS, LIS[i] + LDS[i] - 1);
        
        return lengthOfLBS;
    }
}