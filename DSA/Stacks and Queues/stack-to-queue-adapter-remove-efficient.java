/*
Question:-

1. You are required to complete the code of our StackToQueueAdapter class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
2. Here is the list of functions that are written in the class
    2.1. add -> Accepts new data if there is space available in the underlying array or 
    print "Queue overflow" otherwise.
    2.2. remove -> Removes and returns value according to FIFO, if available or print 
    "Queue underflow" otherwise and return -1.
    2.3. peek -> Returns value according to FIFO, if available or print "Queue 
    underflow" otherwise and return -1.
    2.4. size -> Returns the number of elements available in the queue.
3. Input and Output is managed for you.

Input Format:-

Input is managed for you

Output Format:-

Output is managed for you

Constraints:-

Note -> remove, peek and size should work in constant time. add should work in linear time.

Sample Input:-

add 10
add 20
add 30
add 40
add 50
remove
remove
add 60
add 70
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
quit

Sample Output:--

10
20
30
30
40
40
50
50
60
60
70
70
Queue underflow
Queue underflow

*********************************************************************************Solution*********************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    //We have made the add() operation inefficient and remove() efficient to convert stack into queue. The idea is to add all items from main stack to helper stack before adding the new item to it.Now, add the new item into the main stack and then add all items from helper stack to main stack again - this way the newly added item will be at bottom or end of the main stack which makes it to work like a queue.
    public static class StackToQueueAdapter 
    {
        Stack < Integer > mainS;
        Stack < Integer > helperS;

        public StackToQueueAdapter() 
        {
            mainS = new Stack < > ();
            helperS = new Stack < > ();
        }

        int size() 
        {
            return mainS.size();
        }

        void add(int val) 
        {
            while(!mainS.isEmpty())
                helperS.push(mainS.pop());
            
            mainS.push(val);    
            
            while(helperS.size() > 0)
                mainS.push(helperS.pop());
        }

        int remove() 
        {
            if(mainS.isEmpty())
            {
                System.out.println("Queue underflow");
                return -1;
            }
            
            return mainS.pop();
        }

        int peek() 
        {
            if(mainS.size() == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            }
            
            return mainS.peek();
        }
    }

    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}