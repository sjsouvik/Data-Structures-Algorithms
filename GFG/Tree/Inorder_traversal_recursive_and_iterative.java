/*
Given a Binary Tree, find the In-Order Traversal of it.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:
     
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case, in a new line, print the inorder traversal.

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrder() that takes root node of the tree as input and returns a 
list containing the In-Order Traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 30
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

Example:
Input:
2
1 3 2
10 20 30 40 60 50
Output:
3 1 2
40 20 60 10 50 30

Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
So, the in order would be 3 1 2
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \        /
               40       60    50
So, the inorder would be 40 20 60 10 50 30

***********************************************************************Solution***************************************************************************/

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
                ArrayList<Integer> res = g.inOrder(root);
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
    
    // Recursive solution to do inorder traversal
    ArrayList<Integer> inOrder1(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            
            res.add(root.data);
            
            inOrder(root.right);
        }
        
        return res;
    }
    
    //iterative solution to do inorder traversal
    ArrayList<Integer> inOrder(Node root)
    {
        Stack<Node> s = new Stack<Node>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        Node curr = root;
        
        while(curr != null || !s.isEmpty())
        {
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            l.add(curr.data);
            curr = curr.right;
        }
        
        return l;
    }
}





