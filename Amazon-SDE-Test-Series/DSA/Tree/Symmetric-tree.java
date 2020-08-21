/*
Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: True
Explanation: Tree is mirror image of
itself i.e. tree is symmetric

Example 2:

Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: False

Your Task:
You don't need to read input or print anything. Your task is to complete the function isMirror() which takes the root of the Binary Tree as its input 
and returns True if the given Binary Tree is a same as the Mirror image of itself. Else, it returns False.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of nodes<=100

********************************************************************Solution*****************************************************************************/

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

        while(queue.size() > 0 && i < ip.length) 
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
                    if(g.isSymmetric(root) == true)
                        System.out.println("True");
                    else
                        System.out.println("False"); 
       	
                    t--;            
        	}
    	}
}


class GfG
{
    // return true/false denoting whether the tree is Symmetric or not i.e. whether the binary tree is a Mirror image of itself or not.
    public static boolean isSymmetric(Node root)
    {
        return areMirror(root, root);
    }
    
    //this method will return true if 2 given trees are mirror, otherwise it'll return false
    static boolean areMirror(Node a, Node b)
    {
        if(a == null && b == null)
            return true;
            
        if(a == null || b == null || a.data != b.data)
            return false;
        
        boolean left = areMirror(a.left, b.right);
        boolean right = areMirror(a.right, b.left);
        
        return left && right;
    }
}




