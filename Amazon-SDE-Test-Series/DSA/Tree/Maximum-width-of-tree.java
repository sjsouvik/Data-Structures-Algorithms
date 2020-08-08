/*
Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes in any level.
For example, maximum width of following tree is 4 as there are 4 nodes at 3rd level.

          1
       /     \
     2        3
   /    \    /    \
  4    5   6    7
    \
      8

Example 1:

Input:
       1
     /    \
    2      3
Output: 2

Example 2:

Input:
        10
      /     \
    20      30
   /    \
  40    60
Output: 2

Your Task:
You don't have to read any input. Just complete the function getMaxWidth() that takes node as parameter and returns the maximum width. The printing is done 
by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= edges <= 1000
1 <= nodes values <= 105

**********************************************************************Solution****************************************************************************/

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

    		    int res = g.getMaxWidth(root);

    		    System.out.println(res);    			
    		    t--;    			
        	}
    	}
}


class Tree
{    
    int getMaxWidth(Node root)
    {
        int maxWidth = 0;
        
        Queue<Node> q = new LinkedList<Node>();
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            if(size > maxWidth)
                maxWidth = size;
                
            while(size-- > 0)
            {
                Node popped = q.poll();
                
                if(popped.left != null)
                    q.add(popped.left);
                    
                if(popped.right != null)
                    q.add(popped.right);    
            }
        }
        
        return maxWidth;
    }		
}












