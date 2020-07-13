/*
Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() 
which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line 
of input contains an integer n denoting the number of integers in a sequence. In the second line are n space separated integers of the stack.

Output Format:
For each testcase, in a new line, print the minimum integer from the stack. 

Your Task:
Since this is a function problem, you don't need to take inputs. You just have to complete 5 functions, push() which takes an integer x as input and pushes 
it into the stack; pop() which pops out the topmost element from the stack; isEmpty() which returns true/false depending upon whether the stack is empty or
not; isFull() which takes the size of the stack as input and returns true/false depending upon whether the stack is full or not (depending upon the given 
size); getMin() which returns the minimum element of the stack.

Expected Time Complexity: O(1) for all the 5 functions.
Expected Auxiliary Space: O(1) for all the 5 functions.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
1
5
18 19 29 15 16
Output:
15

***********************************************************************Solution*****************************************************************************/

import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}


class GfG{
    int min = Integer.MAX_VALUE;
    
	public void push(int a, Stack<Integer> s)
	{
	    s.push(a);
	    
	    if(a < min)
	        min = a;
	}

	public int pop(Stack<Integer> s)
        {
        	if(s.isEmpty())
            		return -1;
        
        	return s.pop();    
	}

	public int min(Stack<Integer> s)
    	{
        	if(s.isEmpty())
            		return -1;
        
        	return min;    
	}

	public boolean isFull(Stack<Integer>s, int n)
    	{
        	if(s.size() == n)
            		return true;
            
        	return false;    
	}

	public boolean isEmpty(Stack<Integer>s)
    	{
        	return s.isEmpty();
	}
}







