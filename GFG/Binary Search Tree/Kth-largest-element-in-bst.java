/*
Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary 
Search Tree.


Example 1:

Input:
      4
    /   \
   2     9
k = 2 
Output: 4


Example 2:

Input:
       9
        \ 
          10
K = 1
Output: 10


Your Task:
You don't need to read input or print anything. Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as 
inputs and returns the Kth largest element in the given BST.


Expected Time Complexity: O(H + K).
Expected Auxiliary Space: O(H) , where H is the height of the tree.


Constraints:
1 <= N <= 1000
1 <= K <= N

**********************************************************************Solution**************************************************************************/

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
                
                int k=Integer.parseInt(br.readLine());
                
                Tree g = new Tree();
                System.out.println (g.kthLargest(root,k));
                t--;
            }
        }
}


class Tree
{
    /* 
    Time Complexity: O(H + K).
    Auxiliary Space: O(H) , where H is the height of the tree.
    Note : In inorder traversal(left, root, right), we traverse the nodes in ascending order because of BST property, left node's data < root's data < right node's data 
    The idea is to do reverse inorder traversal(right, root,left) which traverses the nodes in descending order. While traversing, we need to keep track of count of nodes visited nodes so far. When the count is equal to 'k' return the data of current root node. */  
    int i = 0, res = -1;
    public int kthLargest(Node root, int k)
    {
        if(root == null)
            return -1;
            
        int right = kthLargest(root.right, k);
        
        if(res != -1)
            return res;
        
        i++;
        if(i == k)
        {
            res = root.data;
            return res;
        }
        
        int left = kthLargest(root.left, k);
        
        return res;
    }
}






