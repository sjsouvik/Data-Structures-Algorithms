/*
Given a Directed Graph. Check whether it contains any cycle or not.

Input: The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of 
two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'M'  which denotes the no of vertices 
and no of edges respectively. The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is an uni-directed  edge 
from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and the number of vertices and 
inputs and returns true if the given directed graph contains a cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 1000
1<= N,M <= 1000
0 <= u,v <= N-1

Example:
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
4 3
0 1 2 3 3 2
Output:
1
0
1

Explanation:
Testcase 1: In the above graph there are 2 vertices. The edges are as such among the vertices.

From graph it is clear that it contains cycle.

********************************************************************Solution**************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

/*
ArrayList<ArrayList<Integer>> adj: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/

class DetectCycle
{
    /*
        The idea is to simply use Kahn’s algorithm (BFS based solution) for Topological Sorting

        Steps involved in detecting cycle in a directed graph using BFS.
        
        Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the graph and initialize the count of visited nodes as 0.
        
        Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
        
        Step-3: Remove a vertex from the queue (Dequeue operation) and then.
        
                1. Increment count of visited nodes by 1.
                2. Decrease in-degree by 1 for all its neighboring nodes.
                3. If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
        
        Step 4: Repeat Step 3 until the queue is empty.
        
        Step 5: If count of visited nodes is not equal to the number of nodes in the graph has cycle, otherwise not.
    */
    static boolean isCyclic1(ArrayList<ArrayList<Integer>> adj, int V)
    {
        int inDegree[] = new int[V]; //by default, all array items are initialized to 0 in Java 
        
        //to calculate indegree of all vertices
        for(int u = 0; u < V; u++)
        {
            for(int v : adj.get(u))
            {
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        //adding all 0 indegree vertices to queue
        for(int i = 0; i < V; i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty())
        {
            int u = q.poll();
            count++;
            
            for(int v : adj.get(u))
            {
                inDegree[v]--;
                
                if(inDegree[v] == 0)
                    q.add(v);
            }
        }
        
        return count == V ? false : true;
    }
    
    /* DFS based solution :
       Perform DFS traversal of the graph. There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
       To detect a back edge, we need to keep track of vertices currently in recursion stack of function for DFS traversal. If we reach a vertex that is already visited and in the recursion stack, then there is a cycle in the tree. The edge that connects current vertex to the vertex in the recursion stack is a back edge.
    */
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                if(isCyclicUtil(adj, i, visited, recStack))
                    return true;
            }
        }
        
        return false;
    }
    
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], boolean recStack[])
    {
        visited[u] = true;
        recStack[u] = true;
        
        for(int v : adj.get(u))
        {
            if(visited[v] == false)
            {
                if(isCyclicUtil(adj, v, visited, recStack)) 
                    return true;
            }
            else if(recStack[v] == true)
                return true;
        }
        
        recStack[u] = false;
        return false;
    }
}





