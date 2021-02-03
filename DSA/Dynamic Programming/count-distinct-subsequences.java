/*
Question:-

1. You are given a string.
2. You have to print the count of distinct and non-empty subsequences of the given string. 

Note -> String contains only lowercase letters.

Input Format:-

A String

Output Format:-

A number

Constraints:-

1 <= length of string <= 60

Sample Input:-

abc

Sample Output:-

7

**************************************************************************************Solution**********************************************************************************************/

import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        // System.out.println(countDistinctSubsequences(str));
        System.out.println(countDistinctNonEmptySubsequences(str)); //more space optimized solution
    }
    
    static long countDistinctSubsequences(String s)
    {
        long dp[] = new long[s.length() + 1];
        dp[0] = 1; //count of subsequences when the given string is empty("")
        
        Map<Character, Integer> m = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++)
        {
            char ch = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1]; /* count of subsequences with current character if the current character is not appeared before. If it has appeared before then need to subtract the count of subsequences the character had made earlier with subsequences containing its previous characters. */
            
            if(m.containsKey(ch))
            {
                int previousIndex = m.get(ch);
                dp[i] -= dp[previousIndex - 1];
            }
            
            m.put(ch, i); /* putting the current character with its index in "dp" array, so that can get the number of subsequences the character had made earlier with subsequences containing its previous characters if it appears again in the given string */
        }
        
        return dp[s.length()] - 1; //subtracting 1 to count only non-empty subsequences
    }
    
    //more optimized solution, we're not using here any array to store solution of subproblems
    static long countDistinctNonEmptySubsequences(String s)
    {
        long previousCount = 1, currentCount = 1;
        Map<Character, Long> m = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            currentCount = 2 * previousCount; /* count of subsequences with current character if the current character is not appeared before. If it has appeared before then need to subtract the count of subsequences the character had made earlier with subsequences containing its previous characters. */
            
            if(m.containsKey(ch))
                currentCount -= m.get(ch);
            
            m.put(ch, previousCount); /* putting the current character with the number of subsequences the character had made earlier with subsequences containing its previous characters */
            previousCount = currentCount;
        }
        
        return currentCount - 1; //subtracting 1 to count only non-empty subsequences
    }
}