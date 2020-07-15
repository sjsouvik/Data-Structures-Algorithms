/*
Implement a Queue using an Array. 

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types:
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop element from queue and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the queue is empty else the element poped out from the queue .

Your Task :
You are required to complete the two methods push() which take one argument an integer 'x' to be pushed into the queue and pop() which returns a integer 
poped out from othe queue. If the queue is empty, it should return -1 on a pop operation. 

Expected Time Complexity: O(1) for both push() and pop().
Expected Auxiliary Space: O(1) for both push() and pop().

Constraints:
1 <= T <= 100
1 <= Q <= 105
1 <= x <= 105

Example:
Input:
2
5
1 2 1 3 2 1 4 2
4
1 3 2 2 1 4  
Output:
2 3
3 -1

Explanation:
Testcase 1:In the first test case for query 
1 2    the queue will be {2}
1 3    the queue will be {2 3}
2       poped element will be 2 the queue will be {3}
1 4    the queue will be {3 4}
2       poped element will be 3
Testcase 2: In the second testcase for query 
1 3 the queue will be {3}
2    poped element will be 3 the queue will be empty
2    there is no element in the queue and hence -1
1 4 the queue will be {4}. 

**********************************************************************Solution******************************************************************************/

import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
					System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}


class MyQueue {

    	int front, rear;
	int arr[] = new int[100005];

    	MyQueue()
	{
		front = 0;
		rear = 0;
	}
	
	/* The method push to push element
	   into the queue */
	void push(int x)
	{
	    arr[rear] = x;
	    rear++;
	} 

    /* The method pop which return the 
       element poped out of the queue*/
	int pop()
	{
		if(front == rear) //when there'll be no element, fear will be equal to rear
		{
		    front = rear = 0;
		    return -1;
		}
		
		return arr[front++];    
	} 
}









