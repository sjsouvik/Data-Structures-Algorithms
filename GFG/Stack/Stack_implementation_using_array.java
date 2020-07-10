/*
Implement a Stack using Array. Your task is to complete the functions below.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types:
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack .

Your Task:
You are required to complete two methods push which take one argument an integer 'x' to be pushed into the stack  and pop which returns a integer poped out 
from the stack.

Expected Time Complexity : O(1) for both push() and pop().
Expected Auixilliary Space : O(1) for both push() and pop().

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
4
5
1 2 1 3 2 1 4 2
4
2 1 4 1 5 2   
20
2 2 1 40 2 1 68 2 1 28 1 85 1 21 1 23 2 1 82 1 85 1 73 1 51 2 2 1 100 1 43 1 14
9
1 43 1 97 2 1 12 1 16 2 1 33 1 51 2
Output:
3 4
-1 5
-1 -1 40 68 23 51 73
97 16 51

Explanation:
Testcase 1:In the first test case for query 
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4
Testcase 2: In the second testcase looking on to the position of 1 and 2 and then after performing all the push and pop operation , outptut will be -1 5.
Testcase 3: According to the given input , firstly no elements were there so after performing pop operation output will be -1 -1 and after performing all 
the push and pop operation , output wil be -1 -1 40 68 23 51 73.
Testcase 4: According to the given input , only 3 pop operations has to be performed and the output will be 97 16 51.

*********************************************************************Solution******************************************************************************/


import java.util.*;
import java.io.*;
import java.lang.*;

class GfG {

	public static void main(String args[])throws IOException
	{
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(read.readLine());
         
		 while(t>0)
		 {
			MyStack obj = new MyStack();
			int Q = Integer.parseInt(read.readLine());
			int k = 0;
			String str[] = read.readLine().trim().split(" ");
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = Integer.parseInt(str[k++]);
				if(QueryType == 1)
				{
					int a = Integer.parseInt(str[k++]);
					
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


class MyStack{

        int top;
	int arr[] = new int[1000];

    	MyStack()
	{
		top = -1;
	}
	
	/* The method push to push element
	    into the stack */
    	void push(int a)
	{
	    // Your code here
	    top++;
	    arr[top] = a;
	} 
	
    /* The method pop which return 
      the element poped out of the stack*/
	int pop()
	{        
        if(top == -1) //to check if there's no element
            return -1;
        return arr[top--];
	}
}
	




