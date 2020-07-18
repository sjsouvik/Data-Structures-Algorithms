/*
Given an infix expression in the form of string str. Conver this infix expression to postfix expression.

    Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
    Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
    ​Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 

Input:
The first line of input contains an integer T denoting the number of test cases. The next T lines contain an infix expression. The expression contains all 
characters and ^,*,/,+,-. 

Output:
For each testcase, in a new line, output the infix expression to postfix expression.

Your Task:
This is a function problem. You only need to complete the function infixToPostfix() that takes a string as a parameter and returns the postfix expression. 
The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= length of str <= 103

Example:
Input:
2
a+b*(c^d-e)^(f+g*h)-i
A*(B+C)/D
Output:
abcd^e-fgh*+^*+i-
ABC+*D/

Explanation:
Testcase 1: After converting the infix expression into postfix expression , the resultant expression will be abcd^e-fgh*+^*+i-
Testcase 2: After converting the infix expression into postfix expression , the resultant expression will be ABC+*D/

**********************************************************************Solution******************************************************************************/

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
		    System.out.println(new solve().infixToPostfix(br.readLine().trim()));
		}
	}
}


class solve
{
    static int precedence(char c)
    {
        switch(c)
        {
            case '+' :
            case '-' :
                return 1;
            
            case '*' :
            case '/' :
                return 2;
            
            case '^' :
                return 3;    
        }
        
        return -1;
    }
    
    
	public static String infixToPostfix(String exp) 
	{
	    Stack<Character> s = new Stack<Character>();
	    String result = "";
	    
		for(int i = 0; i < exp.length(); i++)
		{
		    char c = exp.charAt(i);
		    
		    //found operand, so will append it to result
		    if(Character.isLetterOrDigit(c))
		        result += c;
		    
		    /* Note : Only operators and opening parenthesis will be pushed into stack - opening parenthesis will be pushed without checking any condition 
		    but in case of operator we need to compare precedence with the peek operator of the stack before pushing it */   
		    
		    //found opening parenthesis, so will push it into stack     
		    else if(c == '(')
		        s.push(c);
		    
		    /*found closing parenthesis, so will pop items from stack and append the popped items to result 
		    until we get an opening parenthesis, afterthat will pop opening parenthesis from stack*/ 
		    else if(c == ')')
		    {
		        while(s.isEmpty() == false && s.peek() != '(')
		            result += s.pop();
		        /*if((!s.isEmpty()) && s.peek() != '(') 
		            return "Invalid expression";*/
		        s.pop();    
		    }
		    
		    /* found operator, so now we need to compare precedence of the current operator with the peek operator of the stack and act accordingly 
		    if the peek operator of the stack has higher or equal precedence than the current operator then will pop until we get a less precedence item 
		    and at last will push the current operator*/
		    else
		    {
		        if((!s.isEmpty()) && precedence(c) <= precedence(s.peek()))
		            result += s.pop();
		        
		        s.push(c);    
		    }
		}
		
		//pop all items from stack and append with the result if still there're some items
		while(!s.isEmpty())
		    result += s.pop();
		
		return result;
	} 
}




