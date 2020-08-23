/*
Given a Binary Tree of size N. You have to print the Reverse Level Order Traversal of the given tree , that is first you have to print nodes of last level 
of the tree , then nodes of second last and so on. 
For Example: The Reverse Level Order Traversal of the following Tree is 4 5 2 3 1 .                                 
                                           
Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each testcase , print the reverse level order traversal of tree separated by space.

User task:
You don't need to take input. Just complete the function reversePrint() that accepts root node of the tree as parameter and prints the reverse level order 
traversal of tree .
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
1 3 2
10 20 30 40 60

Output:
3 2 1
40 60 20 30 10

Explanation:
Testcase 1: There are total 3 nodes of tree.

Reverse level order traversal of tree is: 3 2 1.

**********************************************************************Solution***************************************************************************/

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
    
	        while(t > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Tree g = new Tree();
		    g.reversePrint(root);
		    System.out.println();
                    t--;            
        	}
    	}  
}


class Tree
{
	public void reversePrint(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        
        if(node != null)
            q.add(node);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node removed = q.poll();
                s.push(removed);
                
                if(removed.right != null)
                    q.add(removed.right);
                
                if(removed.left != null)
                    q.add(removed.left);
            }
        }
        
        while(!s.isEmpty())
            System.out.print(s.pop().data + " ");
    }
}      
       

