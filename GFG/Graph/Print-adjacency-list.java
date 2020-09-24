/*
Given number of edges 'E' and vertices 'V' of a bidirectional graph. Your task is to build a graph through adjacency list and print the adjacency list 
for each vertex.

Input:
The first line of input is T denoting the number of testcases.Then first line of each of the T contains two positive integer V and E where 'V' is the 
number of vertex and 'E' is number of edges in graph. Next, 'E' line contains two positive numbers showing that there is an edge between these two vertex.

Output:
For each vertex, print their connected nodes in order you are pushing them inside the list . See the  given  example.

Constraints:
1 <= T <= 200
1 <= V <= 103
1 <= E = V*(V-1)

Example:
Input:
2
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0

Output:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
0-> 1-> 2
1-> 0-> 2
2-> 1-> 0

Explanation:
Testcase 1: Given graph has 5 nodes and 7 edges. After creating adjacency list of given graph, we have list as:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3

*********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
     public static void main (String[] args) throws IOException
     {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, nov, noe;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     nov = sc.nextInt(); //no of vertices
    	     noe = sc.nextInt(); //no of edges
    	     
    	     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(nov);
    	   
    	     for(int i = 0; i < nov; i++)
    	        adj.add(new ArrayList<Integer>());
    	       
    	     //this is to create the adjacency list     
    	     for(int i = 0; i < noe; i++)
    	     {
    	         int u = sc.nextInt();
    	         int v = sc.nextInt();
    	         
    	         adj.get(u).add(v);
    	         adj.get(v).add(u);
    	     }
    	     
    	     //this is to print the adjacency list
    	     for(int u = 0; u < nov; u++)
    	     {
    	         System.out.print(u);
    	         
        	     for(int v : adj.get(u))
        	     {
        	         System.out.print("-> " + v);
        	     }
        	     
        	     System.out.println();
    	     }
    	 }
     }
 }



