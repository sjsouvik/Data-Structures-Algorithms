/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test case contains an 
integer Q denoting the number of queries.

A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out  or min element from the stack.

User Task:
You are required to complete the three methods push() which take one argument an integer 'x' to be pushed into the stack, pop() which returns a integer 
poped out from the stack and getMin() which returns the min element from the stack.

Expected Time Complexity : O(1) for all the 3 methods.
Expected Auixilliary Space : O(1) for all the 3 methods.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
1
6
1 2 1 3 2 3 1 1 3   

Output:
3 2 1

Explanation:
Testcase 1:
In the first test case for query 
1 2  the stack will be {2}
1 3  the stack will be {2 3}
2 poped element will be 3 the stack will be {2}
3 min element will be 2 
1 1 the stack will be {2 1}
3 min element will be 1 and

*********************************************************************Solution***************************************************************************/

/************************************************************Solution 1 : Uisng O(n) extra space ********************************************************

import java.util.*;

class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);					
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
				q--;
			}
			System.out.println();
			T--;
		}
		
	}
}


//this solution requires O(n) extra space to store the min elements
class GfG
{
    int minEle;
    Stack<Integer> ms = new Stack<Integer>(); //this is the main stack where all elements will be pushed 
    Stack<Integer> as = new Stack<Integer>(); //this is to keep track of min elements 

    /*returns min element from stack*/
    int getMin()
    {    	
    	if(as.isEmpty())
    	    return -1;
    	    
    	return as.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {    	
    	if(ms.isEmpty())
    	    return -1;
    	
    	/*if the popped element matches with the peek element of the auxiliary stack 
    	then only will be popping from aux stack,it happens only when we are about to delete the current minimum element*/
    	else if(ms.peek() == as.peek()) 
            as.pop();
    	
    	return ms.pop(); //will be popping from main stack always
    }

    /*push element x into the stack*/
    void push(int x)
    {
    	ms.push(x); //pushing all elements into main stack
    	
    	if(as.isEmpty() || x <= as.peek()) //will be pushing into auxiliary stack in 2 cases : i) if the aux. stack is empty or, ii) the current element is less or equal to the peek element of the aux stack
    	    as.push(x);
    }	
}

**************************** Solution 2 : O(1) extra space, O(n) extra space is required for the above solution  ******************************************/

import java.util.*;

class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);					
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
				q--;
			}
			System.out.println();
			T--;
		}
		
	}
}


//this solution requires O(1) extra space 
class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<Integer>(); //this is the main stack where all elements will be pushed

    /*returns min element from stack*/
    int getMin()
    {
    	if(s.isEmpty())
            return -1;
        
        return minEle;    
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        int popped;
        
        if(s.isEmpty())
            return -1;
        
        /* peek element of the stack can't be less than minEle unless the peek has the encrypted value for the current min. element as minEle will contain the min. element of the stack always 
        so, if the peek element of the stack is less than the current minEle that means current minEle is about to be popped so need to update the minEle with the previous min. element using ((2 * minEle) - s.peek())*/
    	if(s.peek() < minEle)
    	{
    	    popped = minEle;
    	    minEle = (2 * minEle) - s.peek();
    	    s.pop();
    	}
    	else
    	    popped = s.pop();
    	    
    	return popped;    
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(s.isEmpty()) //if the stack is empty then the 1st pushed element will be the current min. element
        {
            minEle = x;
            s.push(x);
        }
        else
        {
            //Trickiest part of the solution to do it in O(1) extra space
            /* if the stack is not empty and current element(x) is less than the current min. element then will be pushing (2*x - minEle) - this is an encrypted value we can say for the current element 
            that needs to be pushed instead of the real current element as it'll help to get back the previous min. element after popping the current min. element and update the min. elemnt as current element, 
            will follow the reverse process to get back the previous min. element while popping*/
            if(x < minEle) 
            {
                s.push(2 * x - minEle);
                minEle = x;
            }
            else
                s.push(x);    
        }
    }	
}













