/*
Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree

        1
     /      \
   10      39
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case print the count of leaves.
Your Task:
You don't have to take input. Complete the function countLeaves() that takes root node of given tree as parameter and returns the count of leaves in tree . 
The printing is done by the driver code.

Constraints:
1<= T <= 30
1<= N <= 104
Example:
Input:
2
3 4 2 
4 8 10 7 N 5 1 3 
Output:
2
3
Explanation:
Test Case 2:  Given Tree is 
                                 4
                               /     \
                            8       10
                          /          /      \
                       7          5        1
                      /
                     3
Three leaves are 3 , 5 and 1.

**********************************************************************Solution******************************************************************************/

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
        		System.out.println(g.countLeaves(root));
                	t--;            
        	}
        }
}


class Tree
{
    int countLeaves(Node node) 
    {
        int leavesAtLeft = 0, leavesAtRight = 0;
        
        if(node != null)
        {
             if(node.left == null && node.right == null)
                return 1;
             
             leavesAtLeft = countLeaves(node.left); //this will give the count of leave nodes at left
             leavesAtRight = countLeaves(node.right); //this will give the count of leave nodes at right
        }
        
         return (leavesAtLeft + leavesAtRight);
    }
}







