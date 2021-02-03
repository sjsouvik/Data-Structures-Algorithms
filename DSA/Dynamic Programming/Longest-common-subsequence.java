/*
Question:-

1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.

Input Format:-

A string str1
A string str2

Output Format:-

A number representing the length of longest common subsequence of two strings.

Constraints:-

0 <= str1.length <= 10
0 <= str2.length <= 10

Sample Input:-

abcd
aebd

Sample Output:-

3

***********************************************************************************Solution************************************************************************************/

import java.io.*;
import java.util.*;

//Refer Aditya Verma's videos and pepcodings videos for DP and this problem to have better more clarity on DP concepts
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        
        String a, b;
        a = sc.next();
        b = sc.next();
        
        // System.out.println(LCSRecursive(a, b, a.length(), b.length())); //Recursive solution
        
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        
        System.out.println(LCSTabulation(a, b, dp)); //Tabulation solution
        
        //to fill the 2D array with -1 as will use this to store answer of sub-problems in memization
        // for(int i = 0; i < dp.length; i++)
        //     Arrays.fill(dp[i], - 1);
        
        // System.out.println(LCSMemoized(a, b, a.length(), b.length(), dp)); //Memoized solution
    }

    //LCS - Longest Common Subsequence
    //Recursive solution
    /* We are traversing both the strings from end and checking whether characters are matching or not. If it matches then we'll check for the next character from end, else we'll make recursive calls one with entire 1st string and 2nd string leaving the last checked character and the other recursive call with entire 2nd string and 1st string leaving the last checked character */
    static int LCSRecursive(String a, String b, int m, int n)
    {
        if(m == 0 || n == 0)
            return 0;
            
        if(a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + LCSRecursive(a, b, m - 1, n - 1);
        else
            return Integer.max(LCSRecursive(a, b, m - 1, n), LCSRecursive(a, b, m, n - 1));
    }
    
    //Memoized / Top-down solution
    static int LCSMemoized(String a, String b, int m, int n, int dp[][])
    {
        if(m == 0 || n == 0)
            return 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
            
        if(a.charAt(m - 1) == b.charAt(n - 1))        
            dp[m][n] = 1 + LCSMemoized(a, b, m - 1, n - 1, dp);        
            
        else        
            dp[m][n] = Integer.max(LCSMemoized(a, b, m - 1, n, dp), LCSMemoized(a, b, m, n - 1, dp));        
        
        return dp[m][n];
    }
    
    //Tabulation / Bottom-up solution
    static int LCSTabulation(String a, String b, int dp[][])
    {
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Integer.max(dp[i -1][j], dp[i][j - 1]);
            }
        }
        
        return dp[dp.length - 1][dp[0]. length - 1];
    }
}
