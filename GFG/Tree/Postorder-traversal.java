/*
Given a binary tree, find the Postorder Traversal of it.
For Example, the postorder traversal of the following tree is:  5 10 39 1

        1
     /     \
   10     39
  /
5

Example 1:

Input:
        19
     /     \
    10      8
  /    \
 11    13
Output: 11 13 10 8 19

Example 2:

Input:
          11
         /
       15
      /
     7
Output: 7 15 11

Your Task:
You don't need to read input or print anything. Your task is to complete the function postOrder() that takes root node as input and returns an array 
containing the postorder traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

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

                    ArrayList<Integer> res = g.postOrder(root);

                    for (int i = 0; i < res.size (); i++)
                        System.out.print (res.get (i) + " ");

                    System.out.print("\n");
                    t--;
        	}
    	}
}


class Tree
{
    ArrayList<Integer> res = new ArrayList<Integer>();
    
    // Recursive solution to do postorder traversal
    ArrayList<Integer> postOrder1(Node root)
    {
        if(root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            res.add(root.data);
        }
        
        return res;
    }
    
    // Iterative solution to do postorder traversal
    ArrayList<Integer> postOrder(Node root)
    {
        Stack<Node> s = new Stack<Node>();
        
        if(root != null)
            s.push(root);
        
        Stack<Node> output = new Stack<Node>();
        
        while(!s.isEmpty())
        {
            Node popped = s.pop();
            
            output.push(popped);
            
            /* will be pushing left node of current popped(root) node first, then right node, so that at the time of popping from output stack we get in left, right and then root node */
            if(popped.left != null)
                s.push(popped.left);
            
            if(popped.right != null)
                s.push(popped.right);
        }
                
        while(!output.isEmpty())
            res.add(output.pop().data);    
            
        return res;
    }
}






