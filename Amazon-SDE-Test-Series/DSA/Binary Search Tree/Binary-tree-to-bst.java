/*
Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 

Example 1:

Input:
      1
    /   \
   2     3
Output: 1 2 3


Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of the Binary tree as 
input and returns the root of the BST. The driver code will print inorder traversal of the converted BST.


Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).


Constraints:
1 <= Number of nodes <= 1000

********************************************************************Solution****************************************************************************/

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

class GFG 
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
            String s = br.readLine();
            Node root = buildTree(s);
            GfG g = new GfG();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}

class GfG
{
    /* Note : Inorder traversal of BST given an array in ascending order */
    /* The idea is to traverse the binary tree first and store the node's data into an array. Then, we need to sort the array so that we can use the sorted array as inorder traversal of BST and build the BST from it */
    Node binaryTreeToBST(Node root)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        preorderTraversal(root, al);
        Collections.sort(al);
        return constructBST(al, 0, al.size() - 1);
    }
    
    void preorderTraversal(Node root, ArrayList<Integer> a)
    {
        if(root == null)
            return;
        
        a.add(root.data);
        preorderTraversal(root.left, a);
        preorderTraversal(root.right, a);
    }
    
    Node constructBST(ArrayList<Integer> a, int l , int h)
    {
        if(l > h)
            return null;
            
        int mid = l + ((h - l) / 2);
        Node root = new Node(a.get(mid));
        root.left = constructBST(a, l, mid - 1);
        root.right = constructBST(a, mid + 1, h);
        
        return root;
    }
}
 







