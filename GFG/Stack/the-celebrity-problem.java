/*
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
 
Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Your Task:
You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 <= N <= 3000
0 <= M[][] <= 1

*****************************************************************************************Solution*********************************************************************************************************/

import java.io.*;
import java.util.*; 

class GFG
{
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 

/* The idea is to push everyone into a stack. Then, pop 2 elements and check who knows whom, if 1st popped element knows 2nd then 1st item is not celebrity 
and we won't push that item into stack again. If 1st popped item doesn't know 2nd one then 2nd one is not celebrity and we won't push that again into stack. 
        
   Follow the above mentioned process till we have more than 1 items into stack. After that the last left element in the stack might be celebrity, 
   that we need to test by checking its corresponding row and column to confirm it's a celebrity     
*/
class Solution 
{ 
    int celebrity(int arr[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i = 0; i < n; i++)
    	    st.push(i);
    	
    	while(st.size() > 1)
    	{
    	    int a = st.pop();
    	    int b = st.pop();
    	    
    	    //if 'a' knows 'b' then 'a' is not a celebrity
    	    if(arr[a][b] == 1)
    	        st.push(b);
    	    //else, if 'a' doesn't know b then 'b' is not a celebrity         
    	    else
    	        st.push(a);
    	}
    	
    	int possiblyCelebrity = st.pop();
    	
    	for(int i = 0; i < n; i++)
    	{
    	    if(i != possiblyCelebrity)
    	    {
    	        if(arr[possiblyCelebrity][i] == 1 || arr[i][possiblyCelebrity] == 0)
    	            return -1;
    	    }
    	}
    	
    	return possiblyCelebrity;
    }
}
