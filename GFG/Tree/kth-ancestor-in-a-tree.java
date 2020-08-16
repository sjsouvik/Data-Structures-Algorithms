/*
Given a binary tree of size  N, a node and a positive integer K., your task is to complete the function kthAncestor(), the function should return the 
Kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.

Example:

Input:
     K = 2
     Node = 4 
Output: 1
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test the function should return the Kth ancestor of the given Node from the binary tree.

Constraints:
1<=T<=30
1<=N<=104
1<= K <= 100

Example:

Input:
2 
1 3
1 2 3
2 4
1 2 3 4 5

Output:
1
1

Explanation:
Test Case 1: Given Tree is
                           1
                        /       \
                       2         3
K = 1 , given node = 3 , Kth ancestor of 3 is 1.

**********************************************************************Solution*****************************************************************************/

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
	            String arr[] = br.readLine().split(" ");
	            int k = Integer.parseInt(arr[0]);
	            int node = Integer.parseInt(arr[1]);
	            String s = br.readLine();

    	    	    Node root = buildTree(s);
    	    	
                    Tree g = new Tree();
        	    System.out.println(g.kthAncestor(root,k,node));
                    t--;            
        	}
    	}
}


class Tree
{    
    ArrayList<Integer> a = new ArrayList<Integer>();
    
    public int kthAncestor(Node root, int k, int key)
    {
        boolean foundKey = ancestors(root, key);
        
        if(!foundKey || k > a.size() - 1 || k == 0)
            return -1;
        
        int j = 0;
        
        for(int i = a.size() - 2; i >= 0; i--)
        {
            j++;
            
            if(j == k)
                return a.get(i);
        }
        
        return -1;
    }
    
    /* This method will return true if the node is found with the given key value, otherwise it'll return false.
       At the same time, it'll store the ancestors of the given key value if the value is found */
    boolean ancestors(Node root, int key)
    {
        if(root == null)
            return false;
        
        a.add(root.data);
        
        if(root.data == key)
            return true;
            
        boolean left = ancestors(root.left, key); //this will check whether the key value is there in the left subtree or not
        boolean right = ancestors(root.right, key); //this will check whether the key value is there in the right subtree or not
        
        if(left == true || right == true) //if any of the left or right subtree of current node holds the key value then will return true
            return true;
        
        a.remove(a.size() - 1); //it'll remove the node which doesn't contain the node with key value in left or right subtree
        
        return false;    
    }
    
}



