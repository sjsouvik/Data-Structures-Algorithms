/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
 
Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([)]"
Output: false

Example 5:

Input: s = "{[]}"
Output: true
 
Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

*****************************************************************************************Solution************************************************************************************/

class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            
            //if we get closing bracket while traversing then need to check whether it matches with the peek of the stack or opening bracket, if it matches then pop it else return false. If the stack is empty when we got closing bracket, then return false
            else
            {
                if(st.isEmpty() || !isMatched(st.peek(), ch))
                    return false;
                
                st.pop(); //if closing parenthesis matches with the opening one then pop it
            }
        }
        
        return st.isEmpty();
    }
    
    boolean isMatched(char a, char b)
    {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}