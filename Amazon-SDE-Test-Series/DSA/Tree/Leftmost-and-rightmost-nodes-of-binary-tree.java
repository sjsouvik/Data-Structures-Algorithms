/*
Given a Binary Tree, Print the corner nodes at each level. The node at the leftmost and the node at the rightmost of each level.

Input:

The first line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing 
the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Print the corner nodes ( nodes at the leftmost and nodes at the rightmost) at each level.

Your Task:
This is a function problem. You don't have to take input. Just complete the function printCorner() that takes a node as parameter and prints the corner. 
The new line is automatically appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of nodes at any level).

Constraints:
1<=T<=30
1<=data of each node<=105
1<=n<=105

Example:
Input:
2
1 3 2
10 20 30 40 60

Output:
1 3 2
10 20 30 40 60

***********************************************************************Solution**************************************************************************/

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

    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
     	            Tree g = new Tree();
    	            g.printCorner(root);
                    System.out.println();
	        }
	}
}


class Tree
{
    public static void printCorner(Node node)
    {
        Queue<Node> q = new LinkedList<Node>();
        
        if(node != null)
            q.add(node);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node removed = q.poll();
                
                if(i == 0 || i == size - 1)
                    System.out.print(removed.data + " ");
                
                if(removed.left != null)
                    q.add(removed.left);
                
                if(removed.right != null)
                    q.add(removed.right);    
            }
        }
    }
    
}







