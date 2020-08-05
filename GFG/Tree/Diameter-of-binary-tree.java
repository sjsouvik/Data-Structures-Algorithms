/*
Given a Binary Tree, find diameter of it.
+The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter 
nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer 
than nine nodes).

Input Format:

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:
      
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Example 1:

Input:
S = 1 2 3
Output: 3
Explanation: The tree is
      1
    /  \
   2    3
The diameter is of 3 length.

Example 2:

Input:
S = 10 20 30 40 60 
Output: 4
Explanation: The tree is
         10
       /   \
     20    30
   /   \
  40   60
The diameter is of 4 length.

Your Task:
You need to complete the function diameter() that takes node as parameter and returns the diameter.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
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
        left = null;
        right = null;
    }
}

class GfG 
{
    static Node buildTree(String str) 
    {
        if (str.length() == 0 || str.charAt(0) == 'N') 
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
        while (queue.size() > 0 && i < ip.length) 
	{
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) 
	    {
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;

            if (i >= ip.length) 
		break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) 
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
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) 
	{
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}


class Tree 
{
    int diameter = 0;
    
    /* Naive approach which has time complexity of O(n * n) since we are calculating diameter of each node and to calculate diameter we need to caluclate height for each node which takes time complexity of O(n) */
    int diameter1(Node root) 
    {
        if(root == null)
	        return 0;	
	
    	int currDiameter = height1(root.left) + height1(root.right) + 1;
    	
    	diameter = Integer.max(diameter, currDiameter); 
    
    	int dl = diameter1(root.left);
    	int dr = diameter1(root.right);
            	
    	return diameter;
    }
    
    
    int height1(Node root)
    {
        if(root == null)
            return 0;
        
        int heightLeft = height1(root.left);
        int heightRight = height1(root.right);
        
        return Integer.max(heightLeft, heightRight) + 1;
    }
    
    /* This solution has time complexity of O(n) since the height() function calculates diameter while calculating height */
    int diameter(Node root)
    {
        if(root == null)
            return 0;
        
        int height = height(root);
        
        return diameter;
    }
    
    /* this function is returning height of each subtree, also it's calculating diameter of the each subtree while calculating height of it (diameter = heightLeft + heightRight + 1) */
    int height(Node root)
    {
        if(root == null)
            return 0;
        
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        
        /* to calculate height, we need to traverse left and right subtree and find the height of left, right subtree first, so using this left and right subtree's height, we can calculate diameter of each node */
        diameter = Integer.max(diameter, heightLeft + heightRight + 1); 
        
        return Integer.max(heightLeft, heightRight) + 1;
    }
}









