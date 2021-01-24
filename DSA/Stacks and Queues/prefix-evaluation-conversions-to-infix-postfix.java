/*
Question:-

1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Input Format:-

Input is managed for you

Output Format:-

value, a number
infix
prefix

Constraints:-

1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.

Sample Input:-

-+2/*6483

Sample Output:-

2
((2+((6*4)/8))-3)
264*8/+3-

************************************************************************************************Solution**************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        //The algo is same as the previous question - postfix evaluation and conversions with a slight change - here we're traversing the expression from end 
        
        //stack to store operands so that can get infix expression
        Stack<String> stInfix = new Stack<>();
        //stack to store operands so that can get postfix expression
        Stack<String> stPostfix = new Stack<>();
        //stack to store operands or digits so that can get value of prefix expression
        Stack<Integer> stVal = new Stack<>();
        
        for(int i = exp.length() - 1; i >= 0; i--)
        {
            char ch = exp.charAt(i);
            
            //if operand or digit is found then push into stacks 
            if(Character.isDigit(ch))
            {
                stInfix.push(ch + ""); //ch + "" - to convert char to String
                stPostfix.push(ch + "");
                stVal.push(ch - '0'); //ch - '0' - to convert char to int
            }  
            
            //if any operator is encountered then pop 2 operands or digits from stack for operands, perform the operation and push the result back to the stack for operands or digits.
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                int a = stVal.pop();
                int b = stVal.pop();
                stVal.push(operation(a, b, ch));
                
                String v1 = stInfix.pop();
                String v2 = stInfix.pop();
                stInfix.push('(' + v1 + ch + v2 + ')');
                
                v1 = stPostfix.pop();
                v2 = stPostfix.pop();
                stPostfix.push(v1 + v2 + ch);
            }
        }
        
        System.out.println(stVal.peek()); //will give value of prefix expression
        System.out.println(stInfix.peek()); //will give infix expression
        System.out.println(stPostfix.peek()); //will give postfix expression
    }
    
    
    static int operation(int a, int b, char op)
    {
        if(op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else if(op == '*')
            return a * b;
        else if(op == '/')
            return a / b;
        
        return -1;    
    }
}