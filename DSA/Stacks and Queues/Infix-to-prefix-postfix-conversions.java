/*
Question:-

1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.

Input Format:-

Input is managed for you

Output Format:-

postfix
prefix

Constraints:-

1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

Sample Input:-

a*(b-c+d)/e

Sample Output:-

abc-d+*e/
/*a+-bcde

******************************************************************************************Solution********************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // Pre-requisite - the previous problem - Infix evaluation
        //stacks to store operands or digits for prefix and postfix
        Stack<String> stPrefix = new Stack<>();
        Stack<String> stPostfix = new Stack<>();
        //stack to store operators and brackets
        Stack<Character> stOperator = new Stack<>(); 
        
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            
             //if any opeining bracket('(') is encountered then simply push into the stack for brackets and operators   
            if(ch == '(')
                stOperator.push(ch);
                
            //if any digit or operand is found then simply push into the stack of prefix and postfix for operands or digits    
            else if(Character.isLetterOrDigit(ch))
            {
                stPrefix.push(ch + ""); //ch + "" - to convert char to String
                stPostfix.push(ch + "");
            }  
            
            //if any closing bracket(')') is encountered then follow the process until we get a opening bracket('('). At last, pop that opening bracket as well.
            else if(ch == ')')
            {
                while(stOperator.peek() != '(')
                    process(stOperator, stPrefix, stPostfix);
                
                stOperator.pop();
            }
            
             //if any operator is found then follow the process until we get a opening bracket('(') or, an operator with low precedence. At last, push the current operator into the stack for operators.
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(!stOperator.isEmpty() && stOperator.peek() != '(' && precedence(ch) <= precedence(stOperator.peek()))
                {
                    process(stOperator, stPrefix, stPostfix);
                }
                
                stOperator.push(ch);
            }
        }
        
        //after processing the entire expression, if there's any operators left in the stOperator stack then there're some operations need to be completed to get the result of the entire expression
        while(!stOperator.isEmpty())
            process(stOperator, stPrefix, stPostfix);
        
        System.out.println(stPostfix.peek()); //will give postfix expression
        System.out.println(stPrefix.peek()); //will give prefix expression
    }
    
    //this method will return precedence of each operator
    static int precedence(char ch)
    {
        if(ch == '*' || ch == '/')
            return 2;
        else if(ch == '+' || ch == '-')
            return 1;
            
        return 0;    
    }
    
    //This method pops 1 operator from stack for operators with 2 operands or digits from stack for operands, perform the operation and push the result back to the stack of prefix and postfix for operands or digits.
    static void process(Stack<Character> stOperator, Stack<String> stPrefix, Stack<String> stPostfix)
    {
        char op = stOperator.pop();
                    
        String b = stPrefix.pop();
        String a = stPrefix.pop();
        stPrefix.push(op + a + b);
        
        b = stPostfix.pop();
        a = stPostfix.pop();
        stPostfix.push(a + b + op);
    }
}
