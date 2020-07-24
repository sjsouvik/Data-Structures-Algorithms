/*
Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each testcase, in a new line, print 0 or 1 accordingly.

Your Task:
You don't need to take input. Just complete the function isBalanced() that takes root node as parameter and returns true, if the tree is balanced else 
returns false.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 105
0 <= Data of a node <= 106

Expected time complexity: O(N)
Expected auxiliary space: O(h) , where h = height of tree

Example:
Input:
3
1 2 N N 3
10 20 30 40 60 N N
4 6 6
Output:
0
1
1
Explanation:
Testcase1: The tree is
        1
     /    
   2
      \
       3 
The max difference in height of left subtree and right subtree is 2, which is greater than 1. Hence unbalanced.
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
The max difference in height of left subtree and right subtree is 1. Hence balanced.
Testcase 3: The tree is 
                                      10
                        /        \
                      6          6
The maximum difference in height of left subtree and right subtree is 0. Hence balanced.

******************************************************************Solution*********************************************************************************/

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
			
	            if(g.isBalanced(root) == true)
    	            	System.out.println(1);
    		    else 
    		    	System.out.println(0);
                    t--;            
        	}
    	}  
}


class Tree
{
    /* This solution takes O(n * n) since for every node we are calculating height of its left and right subtree and also checking whether it's balanced or not */
    boolean isBalanced1(Node root)
    {
        if(root == null)
            return true;
        
    	int leftHeight = heightOfTree(root.left); //this will give the height of left subtree
    	int rightHeight = heightOfTree(root.right); //this will give the height of right subtree
    	
    	if(Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) //condition to be height balanced
    	    return true;
    	
    	return false;    
    }
    
    int heightOfTree(Node root)
    {
        if(root == null)
            return 0;
        
        int heightLeft = heightOfTree(root.left);
        int heightRight = heightOfTree(root.right);
        
        return 1 + Integer.max(heightLeft, heightRight);
    }
    
    //Optimized solution - takes O(n) 
    boolean isBalanced(Node root)
    {
        if(heightIfBalanced(root) == -1)
            return false;
        
        return true;    
    }
    
    
    //this method will return -1 if the tree is not balanced else will return height of the tree
    int heightIfBalanced(Node root)
    {
        if(root == null)
            return 0;
            
        int leftHeight = heightIfBalanced(root.left); //this will give -1 if left subtree is not balanced otherwise will give height of left subtree
        
        if(leftHeight == -1)
            return -1;
            
        int rightHeight = heightIfBalanced(root.right); //this will give -1 if right subtree is not balanced otherwise will give height of right subtree
        
        if(rightHeight == -1)
            return -1;
            
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        
        return 1 + (Integer.max(leftHeight, rightHeight)); //if left and right subtrees are balanced then will return the height of the entire tree   
    }
}













