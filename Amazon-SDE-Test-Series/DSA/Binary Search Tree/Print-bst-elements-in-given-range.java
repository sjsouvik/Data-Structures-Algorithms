/*
Given a Binary Search Tree and a range. Find all the numbers in the BST that lie in the given range.
Note: Element greater than or equal to root go to the right side.

Example 1:

Input:
       17
     /    \
    4     18
  /   \
 2     9 
l = 4, h = 24
Output: 4 9 17 18 

Example 2:

Input:
       16
     /    \
    7     20
  /   \
 1    10
l = 13, h = 23
Output: 16 20 

Your Task:
You don't need to read input or print anything. Your task is to complete the function printNearNodes() which takes the root Node of the BST and the range 
elements low and high as inputs and returns an array that contains the BST elements in the given range low to high (inclusive) in non-decreasing order.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 104
1 <= l < h < 105

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

    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws Exception
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            
	        while(t > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
		    x = Integer.parseInt(arr[0]);
		    y = Integer.parseInt(arr[1]);
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = g.printNearNodes(root,x,y);
		    for(int i = 0;i<res.size();i++)
	            System.out.print(res.get(i) + " " );
		    System.out.println();
                    t--;            
        	}
    	}  
}


class Solution
{   
	public static ArrayList<Integer> printNearNodes(Node root, int low, int high)
	{
	    ArrayList<Integer> al = new ArrayList<Integer>();
	    print(root, low, high, al);
	    return al;
        }
    
    static void print(Node root, int l, int h, ArrayList<Integer> a)
    {
        if(root == null)
            return;
            
        if(root.data < l)
        {
            print(root.right, l, h, a);
            return;
        }
        if(root.data > h)
        {
            print(root.left, l, h, a);
            return;
        }
        
        print(root.left, l, h, a);
        a.add(root.data);
        print(root.right, l, h, a);
    }
}





