/*
Question:-

1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.

Input Format:-

A string str

Output Format:-

A number representing the length of longest palindromic subsequence of string str.

Constraints:-

0 <= str.length <= 10

Sample Input:-

abcgackbc

Sample Output:-

5

*******************************************************************************************Solution***********************************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    /* The idea is to use the idea of Longest Common Subsequence(LCS) but as we know we need to have 
    2 strings to get common subsequence in both and we have one string to find Longest Palindromic 
    Subsequence(LPS). So, we can reverse the given string and use as the 2nd string to get length of 
    LCS which will be length of LPS as well (Watch Aditya Verma's video on this) */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        /* String is immutable and it doesn't have any method like reverse() in it. So, need to convert it 
        into StringBuilder or StringBuffer, reverse it and convert it back to String */
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverse = sb.toString();

        System.out.println(LPS(s, reverse, s.length(), reverse.length()));
    }

    static int LPS(String s, String r, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (s.charAt(m - 1) == r.charAt(n - 1))
            return 1 + LPS(s, r, m - 1, n - 1);
        else
            return Integer.max(LPS(s, r, m, n - 1), LPS(s, r, m - 1, n));
    }
}