/*
Question:-

1. You are required to complete the code of our MinStack class. 
2. As data members you've one stack and a min element available in the class. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
      3.1. push -> Should accept new data in LIFO manner.
      3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
       "Stack underflow" and return -1.
      3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
      underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
     3.5. min -> Should return the smallest element available in the stack. If not 
     available, print "Stack underflow" and return -1.
4. Input and Output is managed for you.

Note -> The judge maynot be able to check if all your functions are O(1) in time, but that is what the expectation is. Also, you can only use constant space.r

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

*******************************************************************************************Solution*********************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static class MinStack 
    {
        Stack < Integer > data;
        int min; //min will hold the minimum element of the stack

        public MinStack() 
        {
            data = new Stack < > (); //initialization
        }

        int size() 
        {
            return data.size();
        }
        
        //Tricky part
        //whenever the current item will be less than the current min item, we need to update min as well as push that into data stack but we will modify the value using the previous min and current item which will be less than the current item's value. This modification will help us to detect min value update later while popping or returning peek of the stack.
        void push(int val) 
        {
            if(size() == 0)
            {
                data.push(val);
                min = val;
            }
            else if(val >= min)
                data.push(val);
            else
            {
                data.push(2 * val - min); //modified value = 2 * current value - min , same equation could be used to get back the previous min value
                min = val;
            }
        }

        //while popping, if we get peek of the stack is less than the current min value then, need to update the min's value to its previous value
        int pop() 
        {
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek() >= min)
                return data.pop();
            else
            {
                int popped = min;
                min = (2 * min) - data.pop(); //min = 2 * current value - modified value
                return popped;
            }
        }

        int top() 
        {
            if(size() == 0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            
            if(data.peek() >= min)
                return data.peek();
                
            return min; //if we get peek of the stack is less than the current min then peek contains the modified value and min has the original value     
        }

        int min() 
        {
            return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
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