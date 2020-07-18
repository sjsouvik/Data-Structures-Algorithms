/*
Given a postfix expression, the task is to evaluate the expression and print the final value. Operators will only include the basic arithmetic operators 
like *,/,+ and -.

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.

Output:
For each test case, in a new line, evaluate the postfix expression and print the value.

Your Task:
This is a function problem. You need to complete the function evaluatePostfixExpression() that takes the string denoting the expression as input and 
returns the evaluated value.

Expected Time Complexity : O(n)
Expected Auixilliary Space : O(n)

Constraints:
1 <= T <= 100
1 <= length of expression <= 1000

Example:
Input:
2
231*+9-
123+*8-
Output:
-4
-3

Explanation:
Testcase 1: After solving the given expression, we have -4 as result.
Testcase 2: After solving the given postfix expression , we have -3 as result.

***************************************************************Solution*********************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{    
	public static void main (String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    System.out.println(new solve().evaluatePostFix(br.readLine().trim()));
		}
	}
}


class solve{
    public static int evaluatePostFix(String exp)
    {
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = 0; i < exp.length(); i++)
        {
             char c = exp.charAt(i);
             
             //found number as character so convert it from char to int
             if(Character.isDigit(c)) //isDigit() is an in built method to determine whether a specified character is digit or not
                s.push(Character.getNumericValue(c));
                //s.push(c - '0'); //this an another way to convert character to int
             
             //found operator, then will pop 2 items, perform opeartions with current operator and push the result into stack    
             else
             {
                 int a = s.pop();
                 int b = s.pop();
                 
                 switch(c)
                 {
                     case '+' :
                         s.push(b + a);
                         break;
                         
                     case '-' :
                         s.push(b - a);
                         break;
                     
                     case '*' :
                         s.push(b * a);
                         break;
                     
                     case '/' :
                         s.push(b / a);
                         break;
                 }
             }
        }
        
        return s.pop();
    }
    
}











