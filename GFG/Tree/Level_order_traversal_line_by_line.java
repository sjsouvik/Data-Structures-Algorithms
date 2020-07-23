/*
Given a Binary Tree, your task is to print its level order traversal such that each level is separated by $.
For the below tree the output will be 1 $ 2 3 $ 4 5 6 7 $ 8 $.

          1
       /     \
     2        3
   /    \     /   \
  4     5   6    7
    \
     8

Input:
The first line of input contains the number of test cases T. For every test case, the only line of input contains a string representing the tree as 
described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

     
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case, in a new line, print the output in the required format.

Your Task:
This is a function problem. You don't need to read input. Just complete the function levelOrder() that takes nodes as parameter and prints level order 
line-by-line. The newline for every test case is automatically appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T<= 100
1 <= Number of edges <= 1000
1 <= Data of a node <= 100

Example:
Input:
2
1 4 N 4 2 
10 20 30 40 60 N N 
Output:
1 $ 4 $ 4 2 $
10 $ 20 30 $ 40 60 $

Explanation:
Testcase1: The tree is
                    1
                 /
               4
            /     \
         4        2
So, the level order would be 1 $ 4 $ 4 2 $
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
So, the level order would be 10 $ 20 30 $ 40 60 $

********************************************************************Solution********************************************************************************/

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
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Level_Order_Traverse g = new Level_Order_Traverse();
                g.levelOrder(root);
    			System.out.println();
                t--;            
        }
    }   
}


class Level_Order_Traverse
{
    //In this method, we'll add null node into the queue to mark the end of a level, so if we find null node that means we have completed traversing 1 level
    static void levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        
        if(node != null)
        {
            q.add(node);
            q.add(null); //this is to mark the end of level 1
        }
        
        while(q.size() > 1)    //at last level also null node will be there to mark the end that's why if we get queue size as 1 then will stop traversing
        {
            Node curr = q.poll();
            
            /* if we find current node as null that means it's an end of a level so will print "$" to mark the end 
            and will also add null node at the end of queue to mark the end of next level since the left and right child have been added into the queue for the nodes of current level */ 
            if(curr == null)
            {
                System.out.print("$ ");
                q.add(null);
            }
            else
            {
                System.out.print(curr.data+" ");
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        
        System.out.print("$"); //this is to print "$" to mark the end of last level
    }
    
    //Method 2 to solve the problem - better solution
    static void levelOrder2(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        
        //this is to add the root node 
        if(node != null)
            q.add(node);
            
        while(!q.isEmpty())
        {
            int size = q.size(); //this will tell the number of nodes present in a particular level
            
            //then, for each node will add left and right child into the queue after removing the node from queue
            while(size-- > 0)
            {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            System.out.print("$ "); //this is to print "$" sign after traversing each level to mark the end of the level
        }
    }
}








