/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.

Example 1:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.

Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=100

********************************************************************************************Solution******************************************************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    LCS obj = new LCS();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}


class LCS
{
    static int lcs(int p, int q, String s1, String s2)
    {
        int dp[][] = new int[p + 1][q + 1];
        
        //Tabulation - Flow should be a) write recursive code, b) add required lines to make that recursive code to memoized, c) write tabulation code from the memoized code
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Integer.max(dp[i -1][j], dp[i][j - 1]);
            }
        }
        
        return dp[p][q];  
        
        //for memoization method
        // for(int i = 0; i < dp.length; i++)
        //     Arrays.fill(dp[i], -1);
        // return LCS(p, q, s1, s2, dp);
    }
    
    //DP - Memoization
    /* We are traversing both the strings from end and checking whether characters are matching or not. 
    If it matches then we'll check for the next character from end, else we'll make recursive calls 
    one with entire 1st string and 2nd string leaving the last checked character and the other recursive 
    call with entire 2nd string and 1st string leaving the last checked character */
    static int LCS(int p, int q, String s1, String s2, int dp[][])
    {
        if(p == 0 || q == 0)
            return 0;
        
        if(dp[p][q] != -1)
            return dp[p][q];
            
        if(s1.charAt(p - 1) == s2.charAt(q - 1))
        {
            dp[p][q] = 1 + lcs(p - 1, q - 1, s1, s2);
            return dp[p][q];
        }
        else
        {
            dp[p][q] = Integer.max(lcs(p - 1, q, s1, s2), lcs(p, q - 1, s1, s2));
            return dp[p][q];
        }
    }
}