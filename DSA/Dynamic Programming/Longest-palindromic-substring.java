/*
Question:-

1. You are given a string str.
2. You are required to print the length of longest of palindromic substrings in string str.

Input Format:-

A string str

Output Format:-

A number representing the length of longest of palindromic substrings in string str.

Constraints:-

0 <= str.length <= 10

Sample Input:-

abccbc

Sample Output:-

4

***************************************************************************************Solution***********************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(LPS(s));
    }

    //LPS - Longest Palindromic Substring
    //Pre-requisite - Count of LPS    
    static int LPS(String s) {
        int length = s.length();
        boolean dp[][] = new boolean[length][length];
        int lengthOfLPS = 0;

        for (int gap = 0; gap < length; gap++) {
            for (int i = 0, j = gap; j < length; i++, j++) {
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }

                if (dp[i][j])
                    lengthOfLPS = Integer.max(lengthOfLPS, gap + 1);
            }
        }

        return lengthOfLPS;
    }
}