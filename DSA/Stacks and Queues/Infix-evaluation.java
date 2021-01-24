/*
Question:-

1. You are given an infix expression.
2. You are required to evaluate and print it's value.

Input Format :-

Input is managed for you
Output Format
Value of infix expression

Constraints:-

1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Sample Input:-

2 + 6 * 4 / 8 - 3

Sample Output:-

2

*****************************************************************************************Solution***************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        //stack to store operators and brackets
        Stack<Character> stOperator = new Stack<>();
        //stack to store operands or digits
        Stack<Integer> stOperand = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            
            //if any opeining bracket('(') is encountered then simply push into the stack for brackets and operators     
            if(ch == '(')
                stOperator.push(ch);
                
            //if any digit is encountered then simply push into the stack for operands or digits     
            else if(Character.isDigit(ch))
                stOperand.push(ch - '0'); //ch - '0' - to convert char to int
            
            //if any closing bracket(')') is encountered then pop 1 operator from stack for operators with 2 operands or digits from stack for operands, perform the operation and push the result back to the stack for operands or digits. Follow the same until we get a opening bracket('('). At last, pop that opening bracket as well. 
            else if(ch == ')')
            {
                while(stOperator.peek() != '(')
                {
                    char op = stOperator.pop();
                    int b = stOperand.pop();
                    int a = stOperand.pop();
                    
                    int res = operation(a, b, op);
                    stOperand.push(res);
                }
                stOperator.pop();
            }
            
            //if any operator is encountered then pop 1 operator from stack for operators with 2 operands or digits from stack for operands, perform the operation and push the result back to the stack for operands or digits. Follow the same until we get a opening bracket('(') or, an operator with low precedence. At last, push the current operator into the stack for operators.
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(stOperator.size() > 0 && stOperator.peek() != '(' && precedence(ch) <= precedence(stOperator.peek()))
                {
                    char op = stOperator.pop();
                    int b = stOperand.pop();
                    int a = stOperand.pop();
                    
                    int res = operation(a, b, op);
                    stOperand.push(res);
                }
                
                stOperator.push(ch);
            }
        }
        
        //after processing the entire expression, if there's any operators left in the stOperator stack then there're some operations need to be completed to get the result of the entire expression
        while(!stOperator.isEmpty())
        {
            char op = stOperator.pop();
            int b = stOperand.pop();
            int a = stOperand.pop();
            
            int res = operation(a, b, op);
            stOperand.push(res);
        }
        
        System.out.println(stOperand.peek());
    }
    
    //this method will return precedence of each operator
    static int precedence(char ch)
    {
        if(ch == '+' || ch == '-')
            return 1;
        //else if (ch == '*' || ch == '/')
            return 2;    
    }
    
    //this method will return result after doing the operation with oprands and operator
    static int operation(int a, int b, char op)
    {
        if(op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else if(op == '*')
            return a * b;
        //else if(op == '/')
            return a / b;    
    }
    
}