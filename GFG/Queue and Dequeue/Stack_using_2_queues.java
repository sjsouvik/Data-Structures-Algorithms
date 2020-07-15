/*
Implement a Stack using two queues q1 and q2.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack.

Your Task:
Since this is a function problem, you don't need to take inputs. You are required to complete the two methods push() which takes an integer 'x' as input 
denoting the element to be pushed into the stack and pop() which returns the integer poped out from the stack.

Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
Expected Auxiliary Space: O(1) for both push() and pop().

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
1 2 2 2 1 3
Output:
3 4
2 -1

Explanation:
Testcase1:
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4  
Testcase 2: 
1 2 the stack will be {2}
2    poped element will be 2
2    the stack is empty hence -1
1 3 the stack will be {3}.

*******************************************************************Solution********************************************************************************/

import java.util.*;

class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
				q--;
			}	
			System.out.println();										
			t--;
		}
	}
}


class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    /*The method pop which return the element poped out of the stack*/
    int pop2()
    {
	    if(!q1.isEmpty())
	        return q1.poll();
	    
	    return -1;    
    }
	
    /* Making push() method is costly i) by adding all elements from q1 to q2, then ii) adding the new element to q1, iii) adding all elements from q2 to q1 again  */
    void push2(int a)
    {
        /*poll() removes item from front, it returns null if the queue is empty 
        whereas remove() throws NoSuchElementException if the queue is empty*/
	    while(!q1.isEmpty())
	    {
	        q2.add(q1.poll()); 
	    }
	    
	    q1.add(a);
	    
	    while(!q2.isEmpty())
	    {
	        q1.add(q2.remove());
	    }
    }
    
    /* Making pop() method is costly i) by adding all elements from q1 to q2 except the last item since that needs to be popped, then ii) popping the last element of q1, iii) swapping the names of 2 queues as q2 contains the all elements after popping operation  */
    int pop()
    {
        if(q1.isEmpty())
            return -1;
            
        while(q1.size() > 1)
            q2.add(q1.poll());
        
        int d = q1.poll();
        
        Queue<Integer> q = q2;
        q2 = q1;
        q1 = q;
        
        return d;
    }
    
    void push(int a)
    {
        q1.add(a);
    }
}





