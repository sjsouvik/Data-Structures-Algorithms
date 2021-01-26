/*
Question:-

1. You are required to complete the code of our MinStack class. 
2. As data members you've two stacks available in the class - one for data values and another for minimum values. (This is cryptic - take hint from video)
2. Here is the list of functions that you are supposed to complete
2.1. push -> Should accept new data in LIFO manner
2.2. pop -> Should remove and return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.3. top -> Should return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.4. size -> Should return the number of elements available in the stack
2.5. min -> Should return the smallest element available in the stack. If not available, print "Stack underflow" and return -1.
3. Input and Output is managed for you.

Note -> The judge maynot be able to check if all your functions are O(1) in time, but that is what the expectation is. 

Input Format:-

Input is managed for you

Output Format:-

Output is managed for you

Constraints:-

None

Sample Input:-

push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
quit

Sample Output:-

11
2
11
4
2
4
2
2
2
8
5
8
5
5
5
20
10
20
10
10
10

***************************************************************************************Solution********************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static class MinStack 
    {
        Stack < Integer > allData;
        Stack < Integer > minData;

        public MinStack() 
        {
            allData = new Stack < > ();
            minData = new Stack < > (); //peek of this stack will hold the minimum data so need to update this whenever we get any item which is less than the peek of this stack
        }

        int size() 
        {
            return allData.size(); 
        }

        void push(int val) 
        {
            // all elements will be pushed into allData stack. if the current element is less than or equal to the peek of minData stack or, minData stack is empty then only will push item into stack  
            allData.push(val);
            
            if(minData.size() == 0 || val <= minData.peek())
                minData.push(val);
        }

        int pop() 
        {
            // will definitely pop from allData stack but if peek of both the stacks are same then need to pop from both of the stacks
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
                
            if(allData.peek() == minData.peek())
                minData.pop();
            
            return allData.pop();
        }

        int top() 
        {
            //if allData stack is empty then return -1 else return top/peek of it
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
                
            return allData.peek();
        }

        int min() 
        {
            //if minData stack is empty then return -1 else return top/peek of it
            if(minData.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            }
            
            return minData.peek();
        }
    }

    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) 
        {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}