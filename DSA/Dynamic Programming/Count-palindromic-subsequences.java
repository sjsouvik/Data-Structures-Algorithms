/*
Question:-

1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.

Input Format:-

A string str

Output Format:-

A number representing the count of palindromic subsequences in string str.

Constraints:-

0 <= str.length <= 10

Sample Input:-

ccbbgd

Sample Output:-

8

*******************************************************************************************Solution*******************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(countPalindromicSubsequences(s));
    }

    /* Count(c1mc2) - c1 == c2 ? count(c1m) + count(mc2) + 1 : count(c1m) + count(mc2) - count(m) 
    --> watch pepcoding's video for better understanding. c1, c2 = 1st and last character of the input string, 
    m = middle characters of the string */

    //String with single character would be considered as palindrome
    //gap = substring's end index - substring's first index, number of characters in a substring = gap + 1
    //traversing array 'dp' diagonally where row indicates starting index and column indicates ending index of substrings
    static int countPalindromicSubsequences(String s) {
        int length = s.length();
        int dp[][] = new int[length][length];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp[0].length; i++, j++) {
                //Gap = 0 means String contains single character
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? (dp[i][j - 1] + dp[i + 1][j] + 1) : (dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]);
                }
            }
        }

        return dp[0][length - 1]; //this cell contains the answer for the entire input string
    }
}