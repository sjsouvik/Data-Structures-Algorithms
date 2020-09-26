/*
Given a Directed Graph. Count the total number of ways or paths that exist between two vertices in the directed graph. These paths doesn’t contain any 
cycle.

Input:
The first line of input contains an integer T. Then T test cases follow. Each test case contains two integers V and E. In the next line are E space 
separated values u,v denoting an edge from u to v. Next line contains the starting node s and the ending node e. (The vertices start from 1)

Output: For each testcase print the total number of paths that exists between the starting and the ending node.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPaths() which takes the adjcency list of the graph, the source 
vertex (s) and the destination vertex (d) as inputs and returns the number of paths in the graph from the source vertex to the destination vertex.

Expected Time Complexity: O(V!).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
1 <= V <= 100
1 <= E <= (V*(V-1))/2
1 <= u, v, s, e <= V
Graph doesn't contain multiple edges, self loop and cycles.

Example:
Input:
1
5 7
1 2 1 3 1 5 2 4 2 5 3 5 4 3
1 5

Output:
4

Explanation:
Testcase 1 :  
                       There are 4 paths from 1 to 5.
                       1 -> 5
                       1 -> 2 -> 5
                       1 -> 3 -> 5
                       1 -> 2 -> 4 -> 3 -> 5

*************************************************************************Solution*************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class Graph 
{
    int size;
    Graph(int V) { this.size = V; }
    Graph() {}
    static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        // list.get(v).add(u);
    }
} 

class DriverClass 
{
    public static void main(String[] args) throws IOException 
    {        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) 
	{
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String str[] = read.readLine().trim().split(" ");
            int nov = Integer.parseInt(str[0]);
            int edg = Integer.parseInt(str[1]);

            // int nov = sc.nextInt();
            // int edg = sc.nextInt();

            new Graph(nov);
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            str = read.readLine().trim().split(" ");
            int k = 0;
            for (int i = 1; i <= edg; i++) 
	    {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                new Graph().addEdge(list, u, v);
            }
            str = read.readLine().trim().split(" ");
            int s = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            System.out.println(new Path().countPaths(list, s, d));
        }
    }
}

/*
g : Adjacency list of the graph
s : source node
d : destination node
*/

/*
    The idea is to use the concept of backtracking and DFS.
    That is take a path and start walking. (i.e. perform DFS from the source node)
    Check If it leads to the destination vertex then count the path and backtrack to take another path.
    If the path doesn’t leads to the destination vertex, discard the path.
*/

class Path 
{
    static int count;
    
    static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) 
    {
        boolean visited[] = new boolean[g.size()];
        
        count = 0;    
        paths(g, s, d, visited);
        
        return count;
    }
    
    static void paths(ArrayList<ArrayList<Integer>> adj, int s, int d, boolean visited[])
    {
        if(s == d)
        {
            count++;
            return;
        }
        
        //setting the visited to true for the source vertex and then calling the same DFS method recursively for its adjacents if the adjacent nodes are not yet visited
        visited[s] = true;
        for(int v : adj.get(s))
        {
            if(visited[v] == false)
                paths(adj, v, d, visited);
        }
        
        visited[s] = false; //for any source vertex if we don't get the destination vertex then, setting back the visited to false for that source vertex, this is the backtracking step here
    }
}









