/*
Given a stack with push(), pop(), empty() operations, delete the middle of it without using any additional data structure.
Middle: ceil(size_of_stack/2.0)

Input:
The first line contains an integer T, the number of test cases. For each test case, the first line contains an integer sizeOfStack denoting the stack size. 
The next line contains space-separated integers that will be pushed into the stack.

Output:
For each test case, in a new line, print the stack elements. If stack size if 1 then just print the top element.

Your Task:
This is a function problem. The input is already taken by the driver code. You only need to complete the function deleteMid() which takes 3 
arguments(stack, size of the stack, and current index - initially 0) that returns the modified stack.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= sizeOfStack <= 100

Example:
Input:
3
5
1 2 3 4 5
7
1 2 3 4 5 6 7
4
1 2 3 4
Output:
5 4 2 1
7 6 5 3 2 1
4 3 1

Explanation:
Testcase 1: As the number of elements is 5 , hence the middle element will be the 3rd one so the output will be 5 4 2 1.
Testcase 2: As the number of elements is 7, hence the middle elements will be the 4th one so the output will be 7 6 5 3 2 1.
Testcase 3: As the number of elements is 4, hence the middle elements will be the 2nd one so the output will be 4 3 1.

*************************************************************************Solution*************************************************************************/

import java.io.*;
import java.util.*;

class GFG 
{
	public static void main (String[] args) 
	{	    
	    Scanner sc=new Scanner(System.in);
	    
	    int testcases=sc.nextInt();
	    
	    while(testcases-->0)
	    {
	        int sizeOfStack =sc.nextInt();
	        
	        Stack <Integer> myStack=new Stack<>();
	        
	        for(int i=0;i<sizeOfStack;i++)
	        {
	            int x=sc.nextInt();
	            myStack.push(x);
	            
	        }
	        
	        if(sizeOfStack==1)
	        {
	            System.out.println(myStack.peek());
	        }
	        else
	        {
	            Geeks obj=new Geeks();
	            Stack <Integer> modified=obj.deleteMid(myStack,sizeOfStack,0);
	            
	            while(!modified.isEmpty())
	            {
	                System.out.print(modified.peek()+" ");
	                modified.pop();
	            }
	            System.out.println();
	        }
	    }	    	    
	}
}


class Geeks
{    
    public Stack<Integer> deleteMid(Stack<Integer>s, int sizeOfStack, int current)
    {
        if(sizeOfStack == 1)
            return s;
            
        int k = (sizeOfStack / 2) + 1;
        
        Stack<Integer> st = delete(s, k);
        
        return st;
    } 
    
    Stack<Integer> delete(Stack<Integer> s, int k)
    {
        //Base condition
        if(k == 1)
        {
            int mid = s.pop();
            return s;
        }
        
        int temp = s.pop();
        
        //Hypothesis 
        Stack<Integer> st = delete(s, k - 1);
        
        //Induction step
        st.push(temp);
        
        return st;
    }
}











