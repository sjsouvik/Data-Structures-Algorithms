/*
Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix. 
Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).

Input:
The first line of input will be the number of testcases T, then T test cases follow. The first line of each testcase contains two space separated 
integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .

Output:
For each testcase in a new line, print the number of islands present.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findIslands() which takes the matrix A and its dimensions N and M 
as inputs and returns the number of islands of connected 1s present in the matrix. A 1 is said to be connected if it has another 1 around it (either of 
the 8 directions).

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).

Constraints:
1 <= T <= 100
1 <= N, M <= 100
0 <= A[i][j] <= 1

Example(To be used only for expected output) :
Input
2
3 3
1 1 0 0 0 1 1 0 1
4 4
1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

Output
2
2

Explanation:
Testcase 1: The graph will look like
1 1 0
0 0 1
1 0 1
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
Second island will be formed by {A[2][0]}.
Testcase 2: The graph will look like
1 1 0 0
0 0 1 0
0 0 0 1
0 1 0 0
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][3]}
Second island will be formed by {A[3][1]}.

*******************************************************************Solution******************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) 
	{
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) 
	    {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) 
	    {
                for (int j = 0; j < M; j++) 
		{
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(new Islands().findIslands(list, N, M));
        }
    }
}

class Islands 
{
    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively     
    //The problem can be easily solved by applying DFS() on each component(disconnected graph is given). In each DFS() call, a component or a sub-graph is visited. We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components.     
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) 
    {
        boolean visited[][] = new boolean[N][M];
        int count = 0;
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(A.get(i).get(j) == 1 && visited[i][j] == false) //will call DFS method if the array value is 1 (since we need to find number of islands of connected 1s) and not yet visited 
                {
                    islandsUtil(A, N, M, i, j, visited);
                    count++;
                }    
            }
        }
        
        return count;
    }
    
    static void islandsUtil(ArrayList<ArrayList<Integer>> a, int N, int M, int i, int j, boolean visited[][])
    {
        if(i < 0 || j < 0 || i == N || j == M || a.get(i).get(j) == 0 || visited[i][j] == true) //if any of these conditins satisfies then won't call DFS recursively 
            return;
        
        visited[i][j] = true;
        
        //recursively calling DFS for 8 adjacents
        islandsUtil(a, N, M, i - 1, j, visited);
        islandsUtil(a, N, M, i - 1, j - 1, visited);
        islandsUtil(a, N, M, i - 1, j + 1, visited);
        islandsUtil(a, N, M, i, j - 1, visited);
        islandsUtil(a, N, M, i, j + 1, visited);
        islandsUtil(a, N, M, i + 1, j - 1, visited);
        islandsUtil(a, N, M, i + 1, j, visited);
        islandsUtil(a, N, M, i + 1, j + 1, visited);
    }
}




