/*
Given a Binary Tree, convert it into its mirror.

Example 1:

Input:
      1
    /  \
   2    3
Output: 2 1 3
Explanation: The tree is
   1    (mirror)  1
 /  \    =>      /  \
3    2          2    3
The inorder of mirror is 2 1 3

Example 2:

Input:
      10
     /  \
    20   30
   /  \
  40  60
Output: 30 10 60 20 40
Explanation: The tree is
      10               10
    /    \  (mirror) /    \
   20    30    =>   30    20
  /  \                   /   \
 40  60                 60   40
The inroder traversal of mirror is
30 10 60 20 40.

Your Task:
Just complete the function mirror() that takes node as paramter  and convert it into its mirror. The printing is done by the driver code only.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

********************************************************************Solution******************************************************************************/
        
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


    void inOrder(Node node) 
    {
        if (node == null) 
	{
            return;
        }
 
        inOrder(node.left);

        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
                    Tree obj = new Tree();
                    Tree g = new Tree(); 
                    g.mirror(root);
                    GfG mt = new GfG();
		    mt.inOrder(root);
		    System.out.println();    	        
	        }
	}
}


class Tree
{
    /*  Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged */
    void mirror(Node node)
    {
        Node root = convertTOMirror(node);
    }
    
    //this method will interchange left and right children of all non-leaf nodes of the given tree recursively
    Node convertTOMirror(Node root)
    {
        if(root == null)
            return null;
        
        Node left = convertTOMirror(root.left);    
        Node right = convertTOMirror(root.right);  
        
        if(left != null || right != null)
        {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        return root;
    }
}




