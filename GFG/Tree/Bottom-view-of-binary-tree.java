/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below 
diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
 

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

Thus nodes of the binary tree will be
printed as such 3 1 2.

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30

Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input 
and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

*************************************************************************Solution************************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
		    ArrayList <Integer> res = g.bottomView(root);
		    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


//Note : Concept of horizontal distance has been used here to understand the nodes in the same vertical line, nodes are having same horizontal distance means they are in the same vertical line. horizontal distance of any node = if the node is left node then (horizontal distance of root node - 1), else if the node is right node then (horizontal distance of root node + 1), it starts from root with horizontal distance as 0
/* The solution is very much similar like vertical traversal of binary tree, in case of vertical traversal, we use ArrayList to store data of all nodes having same horizontal distance (same horizontal distance means they are in same vertical line) but in this problem, we need to store only the data of single node having the unique horizontal distance which comes last in level order traversal, so will override the corresponding value whenever the key(Horizontal distance) is found */
class Tree
{
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        if(root != null)
        {
            root.hd = 0;
            q.add(root);
        }
        
        while(!q.isEmpty())
        {
            Node removedNode = q.poll();
            int hd = removedNode.hd;
            
            tm.put(hd, removedNode.data);
                
            if(removedNode.left != null)
            {
                removedNode.left.hd = hd - 1;
                q.add(removedNode.left);
            }
            
            if(removedNode.right != null)
            {
                removedNode.right.hd = hd + 1;
                q.add(removedNode.right);
            }
        }
        
        for(Map.Entry<Integer, Integer> m : tm.entrySet())
            al.add(m.getValue());
        
        return al;    
    }
}




