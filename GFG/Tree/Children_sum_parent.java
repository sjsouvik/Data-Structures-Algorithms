/*
Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

     
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Return 1 if the given tree satisfies the given property else return 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isSumProperty() that takes the root Node of the Binary Tree as input 
and returns 1 if all the nodes in the tree satisfy the following properties. Else, it returns 0.

For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are 
considered to follow the property.

Expected Time Complexiy: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Data on nodes <= 1000

Example:
Input:
2
10 10
1 4 3 5 N
Output:
1
0

Explanation:
Testcase 1: Tree is like:
            10
           /    
        10       

Here, every node is sum of its left and right child.
Testcase 2: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not 
satisfy the given conditions.

*********************************************************************Solution******************************************************************************/

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
		    Tree g=new Tree();
                    System.out.println(g.isSumProperty(root));    	        
	        }
	}
}


class Tree
{
    // Return 1 if all the nodes in the tree satisfy the given property. Else return 0
    public static int isSumProperty(Node root)
    {
        return isCSP(root) == true ? 1 : 0;
    }
    
    static boolean isCSP(Node root)
    {
        int sum = 0;
        
        //this base condition is required to handle the case where root node itself is null
        if(root == null)
            return true;
            
        //this base condition is required to handle the case where node doesn't have any child, if any node doesn't have child that means also that node follows CSP 
        if(root.left == null && root.right == null)
            return true;
            
        if(root.left != null)
            sum += root.left.data;
        
        if(root.right != null)
            sum += root.right.data;
            
        if(sum == root.data && isCSP(root.left) && isCSP(root.right))
            return true;
            
        return false;    
    }
}







