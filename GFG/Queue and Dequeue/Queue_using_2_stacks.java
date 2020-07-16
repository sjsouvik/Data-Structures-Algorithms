/*
Implement a Queue using 2 stacks s1 and s2 .

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types
(i) 1 x (a query of this type means  pushing 'x' into the queue)
(ii) 2   (a query of this type means to pop element from queue and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each pop query will be the space separated integers having -1 if the queue is empty else the element poped out from the queue .

Your Task:
Since this is a function problem, you don't need to take inputs. You are required to complete the two methods push which take one argument an integer 'x' 
to be pushed into the queue and pop which returns a integer poped out from other queue. The printing is done automatically by the driver code.

Expected Time Complexity : O(1) for both push() and O(N) for pop().
Expected Auxilliary Space : O(N).

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
2
5
1 2 1 3 2 1 4 2
4
1 2 2 2 1 4
Output:
2 3
2 -1

Explanation:
Testcase1: In the first testcase
1 2    the queue will be {2}
1 3    the queue will be {2 3}
2       poped element will be 2 the queue will be {3}
1 4    the queue will be {3 4}
2       poped element will be 3.
Testcase 2: In the second testcase 
1 2    the queue will be {2}
2       poped element will be 2 and then the queue will be empty
2       the queue is empty and hence -1
1 4    the queue will be {4}.

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a 
function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

*****************************************************************Solution********************************************************************************/

import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

class GfG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			StackQueue g = new StackQueue();
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryTyoe = sc.nextInt();
				if(QueryTyoe == 1)
				{
					int a = sc.nextInt();
					g.Push(a);
				}else
				if(QueryTyoe == 2)
				System.out.print(g.Pop()+" ");
				q--;				
			}
			System.out.println();
			t--;
		}
	}
}


class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* making the push operation costly to get the solution by i) pushing all items from s1 to s2 first, then ii) adding the new item into s2, iii) now, will add all items from s2 to s1 again */
    void Push2(int x)
    {
        while(!s1.isEmpty())
            s2.push(s1.pop());
            
        s2.push(x);
        
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }
	
    
    /* The method remove which return the
      element popped out of the queue*/
    int Pop2()
    {
	    if(s1.isEmpty())
	        return -1;
	   
	    return s1.pop(); 
    }
    
    /**********Another approach where pop() operation is costly*********/
    void Push(int x)
    {
        s1.push(x);
    }
    
    /* making the pop() operation costly to get the solution by i) pushing all items from s1 to s2 first, then ii) popping from s2, iii) now, will add all items from s2 to s1 again */
    int Pop()
    {
        if(s1.isEmpty())
            return -1;
            
        while(!s1.isEmpty())
            s2.push(s1.pop());
        
        int popped = s2.pop();
        
        while(!s2.isEmpty())
            s1.push(s2.pop());
        
        return popped;    
    }
}




