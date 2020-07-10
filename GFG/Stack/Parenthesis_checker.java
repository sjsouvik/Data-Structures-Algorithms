/*
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced

************************************************************************Solution***************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 int t;
    	 
    	 Scanner sc = new Scanner(System.in);
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     String s = sc.next();
    	     
    	     if(isBalanced(s))
    	        System.out.println("balanced");
    	     else
    	        System.out.println("not balanced");
    	 }
	 }
	 
	 static boolean isBalanced(String s)
	 {
	     Stack<Character> st = new Stack<Character>();
	     
	     for(int i = 0; i < s.length(); i++)
	     {
	         char c = s.charAt(i);
	         
	         if(c == '(' || c == '{' || c == '[')
	            st.push(c);
	         else //if(c == ')' || c == '}' || c == ']') //found closing bracket
	         {
	             if(st.isEmpty()) //this is to check whether there's any opening bracket or not, if there's no opening bracket then it's not balanced, example : )(, ))  
	                return false;
	             else if(!isMatched(st.peek(), c)) //if current closing parenthesis type doesn't match with the peek parenthesis type of the stack then it's not balanced
	                return false;
	             
	             st.pop(); //if it passes previous 2 conditions i.e. current closing parenthesis type matched with the peek parenthesis type of the stack, so will delete element from the stack
	         }
	     }
	     
	     return st.isEmpty(); //this is to check whether the stack is empty or not after traversing the entire given input, if it's not empty then it's not balanced
	 }
	 
	 //this is to check whether the current closing parenthesis type matches with the peek parenthesis type of the stack or not
	 static boolean isMatched(char a, char b)
	 {
	     return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
	 }
	 	 
}


