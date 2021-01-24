/*
Question:-

1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Input Format:-

Input is managed for you

Output Format:-

value, a number
infix
prefix

Constraints:-

1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.

Sample Input:

264*8/+3-

Sample Output:-

2
((2+((6*4)/8))-3)
-+2/*6483

*********************************************************************************************Solution***********************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // stack to store operands so that can get prefix expression
        Stack < String > stPrefix = new Stack < > ();
        // stack to store operands so that can get infix expression
        Stack < String > stInfix = new Stack < > ();
        // stack to store operands or digits so that can get value of postfix expression
        Stack < Integer > stVal = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            //if operand or digit is found then push into stacks 
            if (Character.isDigit(ch)) {
                stInfix.push(ch + ""); //ch + "" - to convert char to String
                stPrefix.push(ch + "");
                stVal.push(ch - '0'); //ch - '0' - to convert char to int
            }

            //if any operator is encountered then pop 2 operands or digits from stack for operands, perform the operation and push the result back to the stack for operands or digits.
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int b = stVal.pop();
                int a = stVal.pop();
                stVal.push(operation(a, b, ch));

                String v2 = stInfix.pop();
                String v1 = stInfix.pop();
                stInfix.push('(' + v1 + ch + v2 + ')');

                v2 = stPrefix.pop();
                v1 = stPrefix.pop();
                stPrefix.push(ch + v1 + v2);
            }
        }

        System.out.println(stVal.peek()); //will give value of postfix expression
        System.out.println(stInfix.peek()); //will give infix expression
        System.out.println(stPrefix.peek()); //will give prefix expression
    }


    static int operation(int a, int b, char op) {
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else if (op == '*')
            return a * b;
        else if (op == '/')
            return a / b;

        return -1;
    }
}