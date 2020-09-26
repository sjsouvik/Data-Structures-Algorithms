/*
Given a square matrix filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and 
left. (Check Your Task for more details).

Input:
The first line of input is an integer T denoting the no of testcases. Then T test cases follow. Each test case consists of 2 lines. The first line of each 
test case contains an integer N denoting the size of the square matrix. Then in the next line are N*N space-separated values of the matrix (M).

Output:
Complete isExist function and return 1 if the path exists from source to destination else return 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function is_possible() which takes a square matrix (M) and its size (N) as 
inputs and returns true if there's path possible from the source to destination. Else, it returns false. 
You have to start from the Source, traverse through the blank cells and reach the Destination. You can move Up, Down, Right and Left. The description of 
cells is as follows:

    A value of cell 1 means Source.
    A value of cell 2 means Destination.
    A value of cell 3 means Blank cell.
    A value of cell 0 means Wall.

Note: There are only a single source and a single destination.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
4
3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3 
3
0 3 2 3 0 0 1 0 0

Output:
1
0

Explanation:
Testcase 1: The matrix for the above given input is:
3 0 0 0
0 3 3 0
0 1 0 3
0 2 3 3
From the matrix we can see that there exists a path from to reach destination 2 from source 1.
Testcase 2: The matrix for the above-given input is:
0 3 2
3 0 0
1 0 0
From the matrix, we can see that there does not exist any path to reach destination 2 from source 1.

*******************************************************************Solution********************************************************************************/

import java.io.*;
import java.util.*;

class GFG 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) 
	{
            int n = Integer.parseInt(br.readLine().trim());
            int A[][] = new int[n][n];
            String[] s = br.readLine().trim().split(" ", n * n);
            int k = 0;
            for (int i = 0; i < n; i++) 
	    {
                for (int j = 0; j < n; j++) 
		{
                    A[i][j] = Integer.parseInt(s[k]);
                    k++;
                }
            }

            Solution T = new Solution();
            System.out.println(T.is_possible(A, n));

            t--;
        }
    }
}


class Solution 
{
    // M : input matrix
    // N : size of the matrix
    /* DFS based solution : we are calling DFS for vertices 1, 2, 3 if the vertex is not visited yet. In DFS call, we're setting visited as true for that particular vertex and then recursively calling DFS for its adjacents(up, down, left, right) */
    public static int is_possible(int M[][], int N) 
    {
        boolean visited[][] = new boolean[N][N];
        boolean foundSource = false; 
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(M[i][j] != 0 && visited[i][j] == false)
                {
                    if(whetherExist(M, i, j, N, visited, foundSource))
                        return 1;
                }
            }
        }
        
        return 0;
    }
    
    static boolean whetherExist(int M[][], int i, int j, int N, boolean visited[][], boolean foundSource)
    {
        if(i < 0 || j < 0 || i == N || j == N || M[i][j] == 0 || visited[i][j] == true)
        {
            return false;
        }
           
        if(M[i][j] == 2 && foundSource) //2 is the destination, so, returning true
            return true;    
        
        //this block of code runs once we get source vertex '1' beacuse we want to start checking from vertex '1' to find whether any path exist or not between source '1' and destination '2'
        if(M[i][j] == 1 || (M[i][j] == 3 && foundSource))  
        {
            visited[i][j] = true;
            foundSource = true;
            
            //recursively calling DFS for 4 adjacents(up, down, left, right)
            boolean up = whetherExist(M, i - 1, j, N, visited, foundSource);
            boolean down = whetherExist(M, i + 1, j, N, visited, foundSource);
            boolean right = whetherExist(M, i, j + 1, N, visited, foundSource);
            boolean left = whetherExist(M, i, j - 1, N, visited, foundSource);
            
            return (up || down || left || right);
        }
        
        return false;
    }
}







