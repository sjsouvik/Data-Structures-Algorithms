/*
Given a Binary Tree of size N and an integer K. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes 
should be printed from left to right. If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6 
     \
      8

Input:
First line of input contains the number of test cases T. For each test case, there will be only two line of input , first line contains integer value K and 
second line contains a string representing the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should print nodes at K distance from root. Nodes should be printed from left to right. If their is no node at distance K you don't need to 
print anything.

Your Task:
You don't have to take input. Complete the function printKdistance() that accepts root node and k as parameter and print the value of the nodes that are at 
a distance k from the root. The new line will be printed by driver code only, you don't need to print a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= T <= 100
1 <= N <= 104
0 <= K <= 30

Example:
Input:
2
0
1 3 2
3
3 2 N N 1 5 3
Output:
1
5 3

**********************************************************************Solution*****************************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG 
{    
    static Node buildTree(String str)
    {        
        if(str.length()==0 || str.charAt(0)=='N')
	{
            return null;
        }
        
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);

        // Starting from the second element        
        int i = 1;

        while(queue.size()>0 && i < ip.length) 
	{            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;

            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0)
		{
	            String X[] = br.readLine().trim().split(" ");
	            int k = Integer.parseInt(X[0]);
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Tree g = new Tree();
	      	    g.printKdistance(root,k);
		    System.out.println();
                    t--;            
        	}
    	}  
}


class Tree
{     
     void printKdistance(Node root, int k)
     {
         printNodes(root, k, 0);
     }
     
     void printNodes(Node root, int k, int level)
     {
         if(root == null)
            return;
         
         if(level == k)
         {
             System.out.print(root.data + " ");
             return;
         }
            
         printNodes(root.left, k, level + 1);
         printNodes(root.right, k, level + 1);
     }
}





