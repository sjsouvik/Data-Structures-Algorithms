/*
Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1

Input:

The first line of input contains the number of test cases T. For each test case, there will be 2 lines of input. The first line of each test case will be 
a string representing the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

The second line of the test case holds the data of the key node.

Output:
For each test print all the ancestors of the target value in the order of their hierarchy.

User Task:
Your task is to complete the function printAncestors() that prints all the ancestors of the key in the given binary tree. A new line is added automatically.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= T <= 1000
1 <= N <= 1000
1<= data of node <= 10000

Example:
Input:
2
1 2 3
2
1 2 3 4 5 6 8 7
7
Output:
1
4 2 1

***********************************************************************Solution**************************************************************************/

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

class Main
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
        
        while(t-- > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target=Integer.parseInt(br.readLine());
            
            GfG g = new GfG();
            g.printAncestors(root, target);
            System.out.println();
        }
    }
}


class GfG
{
    public static boolean printAncestors(Node node, int x)
    {
        if(node == null)
            return false;
        
        if(node.data == x)
            return true;
        
        boolean left = printAncestors(node.left, x); //this will check whether the left subtree contains the key or not
        boolean right = printAncestors(node.right, x); //this will check whether the right subtree contains the key or not
        
        //if any of the subtrees returns true that means root is one of the ancestors, so will print and return true 
        if(left == true || right == true)
        {
            System.out.print(node.data + " ");
            return true;
        }
        
        return false; //if any of the subtrees doesn't return true that means root node doesn't contain the key, so will return false in that case
    }
}




