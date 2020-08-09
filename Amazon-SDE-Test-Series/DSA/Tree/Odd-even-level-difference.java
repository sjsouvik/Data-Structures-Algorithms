/*
Given a Binary Tree. Find the difference between the sum of node values at even levels and the sum of node values at the odd levels.
       2
     /    \
    3     5
For the above tree the odd level sum is 2 and even level sum is 8 thus the difference is 2-8=-6

Input:

First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should return an integer denoting the difference between the sum of nodes at odd level and the sum of nodes at even level

Your Task:
This is a function problem. You don't have to take input. Just complete the function getLevelDiff() that takes root as parameter and returns the answer. 
The printing is done by the driver code only.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <=T<= 30
1 <= Number of nodes<= 105

Example:
Input
2
1 2 3
10 20 30 40 60
Output
-4
60

The first case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2. 

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
		    System.out.println(g.getLevelDiff(root));
	        }
	}
}


class Tree
{
    int oddSum = 0, evenSum = 0;
    
	int getLevelDiff(Node root)
	{
	    getDiff(root, 1);
	    
	    return oddSum - evenSum;
	}
	
	void getDiff(Node root, int level)
	{
	    if(root == null)
	        return;
	        
	    if(level % 2 == 0)
	        evenSum += root.data;
	    else
	        oddSum += root.data;
	    
	    getDiff(root.left, level + 1);
	    getDiff(root.right, level + 1);
	}
}











