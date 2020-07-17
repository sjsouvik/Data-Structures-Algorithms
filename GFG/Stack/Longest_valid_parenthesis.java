/*
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

Input:
First line contains number of test cases T.  Each test case have one line string S of character '(' and ')' of length  N.

Constraints:
1 <= T <= 500
1 <= N <= 105

Example:
Input:
2
((()
)()())

Output:
2
4

Explanation:
Testcase 1: Longest valid balanced parantheses is () and its length is 2.

********************************************************************Solution*******************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     String s = sc.next();
    	     
    	     System.out.println(lenOfLongestValidParenthesis(s));   
    	 }
	 }
	 
	 static int lenOfLongestValidParenthesis(String s)
	 {
	     int len = 0;
	     
	     Stack<Integer> st = new Stack<Integer>();
	     st.push(-1); //this is required to calculate the length of 1st valid parenthesis
	     
	     for(int i = 0; i < s.length(); i++)
	     {
	         char c = s.charAt(i); 
	         
	         if(c == '(')
	            st.push(i); //pushing index of opening parenthesis
	            
	         else //found closing parenthesis ')'
	         {
	             if(st.peek() != -1) //st.peek() != -1 means index of some characters are in the stack
	             {
	                 /* now we need to check whether the current character is matching with the character at peek, 
	                 if it matches that means we have opening parenthesis's index at peek and will take the length of valid parenthesis 
	                 by calculating difference of current index and peek index of the stack after popping opening parenthesis's index*/
    	             if(s.charAt(st.peek()) == '(' && c == ')')
    	             {
    	                 st.pop();
    	                 len = Integer.max(len, i - st.peek());
    	                 continue;
    	             }
	             }
	             
	             /* flow will come to this part of the code if we get closing parenthesis at beginning or, after a set of valid parenthesis, 
	             we need the index of closing parenthesis in this case to get the length of valid parenthesis later if there's any*/
                 st.push(i); //this is to store the index of closing parenthesis 
	         }
	     }
	     
	     return len;
	 }
}







