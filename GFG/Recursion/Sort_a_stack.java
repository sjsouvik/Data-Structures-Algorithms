/*
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer N denoting 
the size of the stack. Then in the next line are N space separated values which are pushed to the the stack. 

Output:
For each test case output will be the popped elements from the sorted stack.

Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack.

Expected Time Complexity : O(N*N)
Expected Auixilliary Space : O(N) recursive.

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input:
2
3
3 2 1
5
11 2 32 3 41

Output:
3 2 1
41 32 11 3 2

Explanation:
For first test case stack will be
1
2
3
After sorting 
3
2 
1

When elements  popped : 3 2 1

*******************************************************************Solution******************************************************************************/

import java.util.Scanner;
import java.util.Stack;

class SortedStack
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		while(t-->0)
		{
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);

			while(!a.empty())
			{
				System.out.print(a.peek()+" ");
				a.pop();
			}

			System.out.println();
		}
	}
}


class GfG
{
     //time complexity : O(n * n) since for eachh element we perform 2 operations sort() and insert()
     //space complexity : O(n)
     public Stack<Integer> sort(Stack<Integer> s)
     {
	  if(s.isEmpty())
          {
               return s;
          }

          int temp = s.pop();

          Stack<Integer> st = sort(s);
        
          Stack<Integer> stack = insert(st, temp);
        
          return stack;
     }


    Stack<Integer> insert(Stack<Integer> s, int temp)
    {

        if(s.isEmpty() || temp >= s.peek())
        {
            s.push(temp);
            return s;
        }

        int popped = s.pop();

        Stack<Integer> st = insert(s, temp);

        st.push(popped);

        return st;
    }
}




