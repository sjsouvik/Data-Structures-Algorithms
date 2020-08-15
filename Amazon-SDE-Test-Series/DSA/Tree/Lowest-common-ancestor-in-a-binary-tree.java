/*
Given a Binary Tree with all unique values and two nodes value n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may 
assume that either both n1 and n2 are present in the tree or none of them is present. 

Example 1:

Input:
n1 = 2 , n2 =  3

     1
   /  \
  2    3
Output: 1

Example 2:

Input:
n1 = 3 , n2 = 4

         5
        /
       2
     /  \
    3    4
Output: 2

Your Task:
 Just complete the function lca() that takes nodes, n1, and n2 as parameters and returns LCA node as output.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

***********************************************************************Solution***********************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
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
	            String input[] = br.readLine().trim().split(" ");
                    int a = Integer.parseInt(input[0]);
                    int b = Integer.parseInt(input[1]);
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
                    Tree g = new Tree();
                    Node k = g.lca(root,a,b);
    		    System.out.println(k.data);    	        
	        }
	}
}


class Tree1
{
        ArrayList<Node> ancestorsOfN1 = new ArrayList<Node>(); //this will hold ancestor nodes of n1
	ArrayList<Node> ancestorsOfN2 = new ArrayList<Node>(); //this will hold ancestor nodes of n2
	
	/* the idea is find the list of ancestor nodes of n1, n2 then traverse both of the lists until nodes don't match with each other, the last equal node of both the lists is known as Lowest Common Ancestor(LCA). 
	   It requires 2 times traversals of the tree to get the ancestor lists of n1, n2, so time complexity - O(n), it requires extra space to store the ances nodes for n1, n2, also, it takes aux. space of O(height of the tree) as it's required by function call stack */    
	Node lca(Node root, int n1,int n2)
	{
	    if(root == null)
	        return new Node(-1);
	    
		boolean a = ancestors(root, n1, ancestorsOfN1);
		
		//if n1 is not found in the tree then return node with data -1 as we need to have n1 and n2 in the tree to find out the Lowest Common Ancestor(LCA)
		if(a == false)
		    return new Node(-1);    
		
		boolean b = ancestors(root, n2, ancestorsOfN2);
		
		//if n2 is not found in the tree then return node with data -1 as we need to have n1 and n2 in the tree to find out the Lowest Common Ancestor(LCA)
		if(b == false)
		    return new Node(-1);  
		
		//traverse both the lists till nodes are equal in both the ancestor lists, the last common node of the lists is known as LCA
		for(int i = 0; i < ancestorsOfN1.size() - 1 && i < ancestorsOfN2.size() - 1; i++)
		{
		    if(ancestorsOfN1.get(i + 1) != ancestorsOfN2.get(i + 1))
		        return ancestorsOfN1.get(i);
		    
		    if(i + 1 == ancestorsOfN1.size() - 1 || i + 1 == ancestorsOfN2.size() - 1)    
		        return ancestorsOfN1.get(i + 1);
		}
		
		return root;    
	}
	
	/* this method will return boolean values depending on whether the given 'n' value is found or not in the tree.
	   At the same time, it'll add the ancestor nodes of the given node value 'n' into an arraylist if n is found */
	boolean ancestors(Node root, int n, ArrayList<Node> a)
	{
	    if(root == null)
	        return false;
	    
	    a.add(root);
	    
	    if(root.data == n)
	        return true;
	        
	    boolean left = ancestors(root.left, n, a);
	    boolean right = ancestors(root.right, n, a);
	    
	    
	    if(left == true || right == true)
	        return true;
	    
	    a.remove(a.size() - 1); //if any root doesn't contain the given node value 'n' then remove that node from ancestors list
	    
	    return false; 
	}
}


/* This is more optimized solution where only one tree traversal is required to get the LCA. In this solution, we assume that both n1, n2 are present in the tree or none of them is present. If one of n1, n2 is present in the tree then it'll return wrong answer as LCA, in that case it'll return the available node.
   
   There could be 4 cases for LCA of n1, n2 : 
   
   case 1 : if both n1, n2 are present in the left or right subtree of current root node then return current node as LCA
   case 2 : if one of current node's subtree contains n1 and other contains n2 then return the current node as LCA
   case 3 : if current node is same as n1 or n2 then return the current node as LCA
   case 4 : if none of current node's subtrees contain any of n1, n2 then return null
   
   */
class Tree
{
    Node lca(Node root, int n1,int n2)
    {
        if(root == null)
            return null;
        
        if(root.data == n1 || root.data == n2)
            return root;
        
        Node lca1 = lca(root.left, n1, n2);
        Node lca2 = lca(root.right, n1, n2);
        
        if(lca1 != null && lca2 != null)
        {
            return root;
        }
        
        if(lca1 != null)
            return lca1;
        else
            return lca2;
    }
}








