/*
Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Input :
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output :
For each test case, in a new line, print the right view of the binary tree.

Your Task:
This is a function problem. You don't have to take input. Just complete the function rightView() that takes node as parameter and prints the right view. 
The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

Example:
Input:
2
1 3 2
10 20 30 40 60
Output:
1 2
10 30 60

Explanation:
Test case 1: Below is the given tree

           1
         /     \
      3        2
For the above test case the right view is: 1 2
Test case 2: Below is the given tree

            10
         /        \
     20          30
   /      \      
40      60

Right View is: 10 30 60.

**********************************************************************Solution***************************************************************************/

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
		    Tree tree = new Tree();
                    tree.rightView(root);
		    System.out.println();    	        
	        }
	}
}


class Tree
{
    //the idea is to print the data of last node for each level, so need to do level order traversal and print the data of last node in each level  
    void rightView1(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        
        if(node != null)
            q.add(node);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node curr = q.remove();
                
                if(i == size - 1) //this is the condition to print only data of last node in each level
                    System.out.print(curr.data + " ");
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    
    /* Recursive solution - bit tricky like recursive solution of left view of binary tree, 
    the difference of recursive solution of left and right view of binary tree is here 
    we traverse the right subtree before traversing the left subtree, except this everything is same */

    void rightView(Node node)
    {
        printRightView(node, 1);
    }
    
    /*the idea here is to do preorder traversal with some variation where we'll check level, will traverse right subtree before traversing left subtree and print the data of the node if current level > maxLevel, 
    here maxLevel will hold the previous traversed level number just before the current level, so maxLevel will be greater than the current level if it's traversed before */
    
    int maxLevel = 0;
    void printRightView(Node root, int level)
    {
        if(root == null)
            return;
        
        if(level > maxLevel)
        {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        
        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);
    }
}










