/*
You are given a string. You need to print the lexicographically sorted power-set of the string.
Note: The string s contains lowercase letter of alphabet.

Example 1:

Input:
s = a
Output: a
Explanation: empty string and a 
are only sets.

Example 2:

Input:
s = abc
Output: a ab abc ac b bc c
Explanation: empty string, 
a, ab, abc, ac, b, bc, c 
are the sets.

Your Task:
You don't need to read input or print anything. You only need to complete the function powerSet that takes string s as parameter and returns a list of 
subsets. The lexicographic-sorting and printing is done automatically by the driver code.

Expected Time Complexity: O(2|s|).
Expected Auxiliary Space: O(|s|). 

Constraints:
1 <= |s| <= 10

**********************************************************************Solution***************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            ArrayList<String> ans = new LexSort().powerSet(st);
            Collections.sort(ans);
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


class LexSort
{
    static ArrayList<String> powerSet(String input)
    {
        ArrayList<String> ps = new ArrayList<String>();
        
        String output = "";
        
        subSequence(input, output, ps);
        
        return ps; //this returned ArrayList will be sorted in main function to get the output lexicographically sorted
    }
        
        
    static void subSequence(String ip, String op, ArrayList<String> ps)
    {
        if(ip.length() == 0)
        {
            ps.add(op);
            return; //don't forget to mention return statement in case of void function since this indicates that the base condition is satisfied and the rest of the execution starts after that, otherwise, we'll get segmentation fault error
        }
        
        /* for each node of the recursive tree, we need to do 2 recursive calls. input will be same for both of the calls at particular level of recursive tree, however input will be modified at each level of recursive tree since it'll be processed at each level to get the required out
        but output will differ for both of the calls based on the problem statement. In this problem, we'll take one character from input at one particular level and will include the character in the current output for 1 call and won't include for the other call */
        String op1, op2;
        
        op1 = op2 = op; 
        
        op2 += ip.charAt(0); //this will be passed as output for 2nd recursive call
        
        ip = ip.substring(1); //this is the new input after processing the given input at current level, here we are removing the 1st characrter from the given input since that character is processed to get the required output
        
        subSequence(ip, op1, ps);
        subSequence(ip, op2, ps);
    }
}

 









