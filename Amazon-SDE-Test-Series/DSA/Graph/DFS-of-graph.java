/*
Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. 
Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges 
respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the nodes while doing DFS starting from node 0.

Your task:
You don't need to read input or print anything. Your task is to complete the function dfs() which takes the Graph and the number of vertices as inputs and 
returns a list containing the DFS Traversal of the graph starting from the 0th node.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= E <= (N*(N-1))/2
Graph doesn't contain multiple edges and self loops.

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3   
0 1 2 3

Explanation:
Testcase 1:
0 is connected to 1 , 2 , 3
1 is connected to 0
2 is connected to 0 and 4
3 is connected to 0
4 is connected to 2
so starting from 0 , dfs will be 0 1 2 4 3.

*********************************************************************Solution***************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            
            ArrayList<Integer> res = new Traversal().dfs(list, nov);
            for (int i = 0; i < res.size (); i++) 
                System.out.print (res.get(i) + " ");
            System.out.println();
        }
    }
}

/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal
{
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        boolean visited[] = new boolean[N]; //by default this boolean array elements are initialized to false in Java
        
        /* for each vertex, the dfsRecursive function needs to be called if the graph is disconnected in nature, 
	   otherwise we can start traversing from the given source node to get all nodes present in the graph */

        /*
        for(int i = 0; i < N; i++)
        {
            if(visited[i] == false)
                dfsRecursive(g, visited, N, i, res);
        } */
        
        dfsRecursive(g, visited, N, 0, res); //the given graph is connected here where source is node 0
        
        return res;
    }
    
    /* The idea of DFS is to start with source node, set visisted to true for that node and add that to result.Then, for all adjacent nodes of source, 
    check whether the adjacent node is visited or not, if the node is not visited then only call 'dfsRecursive' function with adjacent node as source node */
    static void dfsRecursive(ArrayList<ArrayList<Integer>> adj, boolean visited[], int n, int s, ArrayList<Integer> res)
    {
        visited[s] = true;
        res.add(s);
        
        for(int u : adj.get(s))
        {
            if(visited[u] == false)
                dfsRecursive(adj, visited, n, u, res);
        }
        
        return;
    }
}





