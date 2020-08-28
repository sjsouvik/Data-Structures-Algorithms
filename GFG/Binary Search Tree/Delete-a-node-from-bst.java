/*
Given a Binary Search Tree and a node value X. Delete the node with the given value X from the BST. If no node with value x exists, then do not make any 
change. 

Example 1:

Input:
      2
    /   \
   1     3
X = 12
Output: 1 2 3
Explanation: In the given input there
is no node with value 12 , so the tree
will remain same.

Example 2:

Input:
            1
             \
              2
                \
                 8 
               /    \
              5      11
            /  \    /  \
           4    7  9   12
X = 9
Output: 1 2 4 5 7 8 11 12
Explanation: In the given input tree after
deleting 9 will be
             1
              \
               2
                 \
                  8
                 /   \
                5     11
               /  \     \
              4    7     12

Your Task:
You don't need to read input or print anything. Your task is to complete the function deleteNode() which takes two arguments. The first being the root 
of the tree, and an integer 'X' denoting the node value to be deleted from the BST. Return the root of the BST after deleting the node with value X. Do 
not make any update if there's no node with value X present in the BST.

Note: The generated output will be the inorder traversal of the modified tree.
 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).
 

Constraints:
1 <= N <= 105

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
    
	public static void main (String[] args) throws Exception
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0)
		{
	            String s = br.readLine();
	            int x = Integer.parseInt(br.readLine());
    	    	    Node root = buildTree(s);
        	    Tree g = new Tree();
		    root = g.deleteNode(root,x);
		    printInorder(root);
		    System.out.println();
                    t--;            
        	}
    	}  
}

class Tree
{
	public static Node deleteNode(Node root, int x)
	{
	    if(root == null)
	        return null;
	        
	    if(x > root.data)
	        root.right = deleteNode(root.right, x);
	    else if(x < root.data)
	        root.left = deleteNode(root.left, x);  
	    else //if(x == root.data)
	    {
	        if(root.left == null) //if the node to be deleted doesn't have any left node then the right node of the deleted node will take place of the deleted node, in case of leaf nodes null will take place of the deleted node
	            return root.right;
	        else if(root.right == null) //if the node to be deleted doesn't have any right node then the left node of the deleted node will take place of the deleted node
	            return root.left; 
	        /* if the node to be deleted has both of the nodes then replace the data of the node with it's closest greater successor node's data and delete the successor node. The closest greater successor node of the deleted node will be in right subtree of the deleted node, for that, we need to go to right then left, left... until we get null */    
	        else
	        {
	            Node successor = getSuccessor(root);
	            root.data = successor.data;
	            root.right = deleteNode(root.right, successor.data);
	        }
	    }
		
	    return root;
	}
	
	static Node getSuccessor(Node root)
	{
	    Node curr = root.right;
	    
	    while(curr != null && curr.left != null)
	        curr = curr.left;
	    
	    return curr;    
	}
}	







