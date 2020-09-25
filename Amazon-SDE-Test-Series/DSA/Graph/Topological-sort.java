/*
Given a Directed Graph. Find any Topological Sorting of that Graph.

Input:
The first line of input takes the number of test cases then T test cases follow . Each test case contains two lines. The first  line of each test case  
contains two integers E and V representing no of edges and the number of vertices. Then in the next line are E  pairs of integers u, v representing an 
edge from u to v in the graph.

Output:
For each test case output will be 1 if the topological sort is done correctly else it will be 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort() which takes the adjacency list of the Graph and the 
number of vertices (N) as inputs are returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, 
you may return any of them.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= V <= 104
1 <= E <= (N*(N-1))/2
0 <= u, v <= N-1
Graph doesn't contain multiple edges, self loops and cycles.
Graph may be disconnected.

Example:
Input
2
6 6
5 0 5 2 2 3 4 0 4 1 1 3
3 4
3 0 1 0 2 0

Output:
1
1

Explanation:
Testcase 1: The output 1 denotes that the order is valid.  So, if you have implemented your function correctly, then output would be 1 for all test cases.

*********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) 
	{
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) 
	    {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSort().topoSort(list, nov);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) 
    {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) 
	{
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) 
	{
            for (int v : list.get(i)) 
	    {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort 
{
    //Topological sorting works for Directed Acyclic Graph only
    /* In topological sorting, we consider each vertex as job and the directed edges as dependency. So, if there's any directed edge from vertex 'u' to 'v' that means job 'u' must finish first before job 'v' */
    /* DFS based solution where we call DFS recursively for each vertex and whenever for one vertex 'u', all adjacent vertices 'v' are processed for DFS recursively, we'll push that vertex 'u' into stack */
    static int[] topoSort1(ArrayList<ArrayList<Integer>> adj, int N) 
    {
        int res[] = new int[N];
        Stack<Integer> s = new Stack<Integer>();
        
        boolean visited[] = new boolean[N];
        
        for(int i = 0; i < N; i++)
        {
            if(visited[i] == false)
                topoUtil(adj, i, visited, s);    
        }
        
        int i = 0;
        while(!s.isEmpty())
            res[i++] = s.pop();
        
        return res;
    }
    
    static void topoUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], Stack<Integer> s)
    {
        visited[u] = true;
        
        for(int v : adj.get(u))
        {
            if(visited[v] == false)
                topoUtil(adj, v, visited, s);
        }
        
        s.push(u);
        return;
    }
    
    /*
    Kahn's Algorithm (BFS based solution):
    
    Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.

    Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

    Step-3: Remove a vertex from the queue (Dequeue operation) and then.

            1. Decrease in-degree by 1 for all its neighboring nodes.
            2. If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.

    Step 4: Repeat Step 3 until the queue is empty.
    
    */
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) 
    {
        int res[] = new int[N];
        
        int inDegree[] = new int[N]; //by default, all array items are initialized to 0 in Java 
        
        //to calculate indegree of all vertices
        for(int u = 0; u < N; u++)
        {
            for(int v : adj.get(u))
            {
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        //adding all 0 indegree vertices to queue
        for(int i = 0; i < N; i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
        }
        
        int i = 0;
        while(!q.isEmpty())
        {
            int u = q.poll();
            res[i++] = u;
            
            for(int v : adj.get(u))
            {
                inDegree[v]--;
                
                if(inDegree[v] == 0)
                    q.add(v);
            }
        }
        
        return res;
    }
    
}





