/*
Your task is to implement  2 stacks in one array efficiently .

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 4 Types
(i)    1 1 x    (a query of this type means  pushing 'x' into the stack 1)
(ii)   1 2      (a query of this type means to pop element from stack1  and print the poped element)
(iii)  2 1 x  (a query of this type means pushing 'x' into the stack 2)
(iv)  2 2     (a query of this type means to pop element from stack2 and print the poped element)
The second line of each test case contains Q queries seperated by space.Output:
The output for each test case will be space separated integers having -1 if the stack is empty else the element poped out from the stack. 

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided functions. You are required to complete the 4 methods push1, 
push2 which takes one argument an integer 'x' to be pushed into the stack one and two and pop1, pop2 which returns the integer poped out from stack one 
and two.

Expected Time Complexity: O(1) for all the four methods.
Expected Auxiliary Space: O(1) for all the four methods.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input
2
6
1 1 2 1 1 3 2 1 4 1 2 2 2 2 2
4
1 1 2 2 2 1 2 2 2
Output
3 4 -1
-1 2 -1

Explanation:
Testcase1:
1 1 2    the stack1 will be {2}
1 1 3    the stack1 will be {2,3}
2 1 4   the stack2 will be {4}
1 2      the poped element will be 3 from stack1 and stack1 will be {2}
2 2      the poped element will be 4 from stack2 and now stack2 is empty
2 2      the stack2 is now empty hence -1 .
Testcase 2:
1 1 2 the stack1 will be {2}
2 2 the stack2 is now empty hence -1
1 2 the poped element from stack1 will be 2
2 2 the stack2 is still empty and hence -1
Hence, the output will be -1 2 -1.

*********************************************************************Solution******************************************************************************/

import java.util.*;

class TwoStack
{
	
	int size;
	int top1,top2;	
	int arr[] = new int[100]; 
	
	TwoStack()
	{
		int n =100;
		size = n;		
		top1 = -1;
		top2 = size;
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T>0)
		{
			TwoStack sq = new TwoStack();
			
			int Q = sc.nextInt();
			while(Q>0)
			{
				int stack_no = sc.nextInt();
				int QueryType = sc.nextInt();
				
				Stacks g = new Stacks();
				
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					if(stack_no == 1)
					 g.push1(a,sq);
					else if(stack_no ==2)
					 g.push2(a,sq);
				}else if(QueryType == 2)
				{
					if(stack_no==1)
					System.out.print(g.pop1(sq)+" ");
					else if(stack_no==2)
					System.out.print(g.pop2(sq)+" ");
				}
			
				Q--;
			}
				System.out.println();
		  		T--;
		}
	}
}


class Stacks
{
    /* The method push to push element into the stack 1 */
    void push1(int x, TwoStack sq)
    {
        //Stack1 will start from index 0 and Stack2 will start from index (arrSize - 1), top1 points to the top element of stack1 whereas top2 points to the top element of stack2
        if(sq.top1 < sq.top2 - 1) //this is to check if there's any empty space to push a new element
        {
            sq.top1++;
            sq.arr[sq.top1] = x;
        }
    }

    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
        if(sq.top1 < sq.top2 - 1)
        {
            sq.top2--;
            sq.arr[sq.top2] = x;
        }
    }

    /* The method pop to pop element from the stack 1 */
    //Return the popped element
    int pop1(TwoStack sq)
    {
        if(sq.top1 > -1) //this is to check if there's any element to be popped else we can return -1 
            return sq.arr[sq.top1--];
            
        return -1;    
    }

    /* The method pop to pop element from the stack 2 */
    //Return the popper element
    int pop2(TwoStack sq)
    {
        if(sq.top2 < sq.size)
            return sq.arr[sq.top2++];
            
        return -1; 
    }
}






