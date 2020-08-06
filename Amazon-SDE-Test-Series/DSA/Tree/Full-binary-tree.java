/*
Given a Binary Tree. Check whether the Binary tree is a full binary tree or not.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Single line output, return true if it is a full binary tree else false.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isFullTree() which takes the root node of the tree as input and 
returns True if the given Binary Tree is full. Else, it returns False.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=T<=1000
1<=N<=1000

Example:
Input:
2
1 2 3 4 5
1 2 3 4 N
Output:
1
0

Explanation:
TestCase 1: 
                 1
             /        \
           2           3
        /       \
     4           5
Every node except leaf node has two children so it is a full tree.

TestCase 2:
                 1
              /       \
            2           3
          /
        4
Node 2 has only one child so this is not a full tree.

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

class Tree 
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
    	    	
                    GfG g = new GfG();
        	    if(g.isFullTree(root))
		        System.out.println("1");
		    else
			System.out.println("0"); 
                    t--;
            
                }
        }
}


class GfG
{
	boolean isFullTree(Node node)
    {
        if(node == null)
            return true;
        
        //if this condition satisfies then the tree is not full    
        if((node.left == null && node.right != null) || (node.left != null && node.right == null))
            return false;
        
        boolean left = isFullTree(node.left); //this will give whether the left subtree is full or not
        boolean right = isFullTree(node.right); //this will give whether the right subtree is full or not
        
        return left && right;
    }
}















