/*
Write a function that returns true if the given Binary Tree of size N is SumTree else return false. A SumTree is a Binary Tree in which value of each 
node x is equal to sum of nodes present in its left subtree and right subtree . An empty tree is SumTree and sum of an empty tree can be considered as 0. 
A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /    \
      10      3
    /   \   /   \ 
   4     6  1    2

 

Input:
The first line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing 
the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Print "1" if the given tree is SumTree else print "0".

Your Task:
You don't need to take input. Just complete the function isSumTree() that takes root node as parameter and returns true, if the tree is SumTree 
else returns false.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <=T<=100
1 <= N <= 104
Example:
Input:
2
3 1 2
10 20 30 10 10

Output:
1
0

************************************************************************Solution***************************************************************************/

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
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Tree g = new Tree();
			
		    if(g.isSumTree(root) == true)
    		        System.out.println(1);
    	            else 
    			System.out.println(0);
                    t--;            
        	}
    	}
  
}


class Tree
{
    boolean isSumTree(Node node)
    {
        return sumTree(node) == -1 ? false : true; 
    }
    
	int sumTree(Node node)
	{
	    if(node == null)
	        return 0;
        
            int left = sumTree(node.left); 
            int right = sumTree(node.right); 
        
            if(left == -1 || right == -1)
                return -1;
            
            if(left == 0 && right == 0)
            {
                return node.data;
            }
            else
            {
                int sum = left + right;
                return sum == node.data ? sum + node.data : -1;
            }
	}
}








