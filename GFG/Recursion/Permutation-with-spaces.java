/*
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted 
increasing order of strings.

Input:  str[] = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)

Input:
First line contains the test cases T.  1<=T<=10
Each test case have one line string S of characters of length  N.  1<=N<=10

Output:
One line per test case, every string enclosed in ().(See example). Output should be printed in sorted order.

Example:
Input:
2
AB
ABC

Output:
(A B)(AB)
(A B C)(A BC)(AB C)(ABC)

********************************************************************Solution****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    /* here, we have 2 choices whether to include space before each character or not while making recursive tree 
       but for the 1st character of the input, we won't place any space, that's why including 1st character of the input in output before calling the function */  
	public static void main (String[] args) 
	{
    	    Scanner sc = new Scanner(System.in);
    	 
    	    int t = sc.nextInt();
    	 
    	    String input, output;
    	 
    	    while(t-- > 0)
    	    {
    	        input = sc.next();
    	        output = "";
    	     
    	        output += input.charAt(0); //including the 1st character of the input in output as for the 1st character we won't include space while doing permutation
    	        input = input.substring(1); //removing the 1st character since it's processed and included in output
    	     
    	        permutationWithSpaces(input, output);   
    	        System.out.println();
    	    }
	 }
	 
	 
	 static void permutationWithSpaces(String ip, String op)
	 {
	     if(ip.length() == 0)
	     {
	         System.out.print("(" + op + ")");
	         return;
	     }
	     
	     /* for each node of the recursive tree, we'll do 2 recursive calls, input will be changed at each level since one character will be processed at each level, so will remove 1st character from current input before doing recursive calls for nodes at next level 
	        output will also be modified since will include space with 1st character of the current input for one call and won't include space with 1st character of the current input for the other call */       
	     permutationWithSpaces(ip.substring(1), op + " " + ip.charAt(0)); 
	     permutationWithSpaces(ip.substring(1), op + ip.charAt(0)); 
	 }
}










