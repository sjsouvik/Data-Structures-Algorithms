/*
Given a BST and a key. Insert a new Node with value equal to that key into the BST. 

Example 1:

Input:
      2
   /    \
  1      3
K = 4
Output: 1 2 3 4
Explanation: After inserting the node 4
Inorder traversal will be 1 2 3 4.

Example 2:

Input:
          2
      /      \
     1        3
               \
               6
K = 4
Output: 1 2 3 4 6
Explanation: After inserting the node 4
Inorder traversal of the above tree
will be 1 2 3 4 6.

Your Task:
You don't need to read input or print anything. Your task is to complete the function insert() which takes the root of the BST and a Key as inputs and 
returns the root of the BST after inserting the Key value into it. The inorder traversal of the tree is printed as output which is taken care by the 
drivers code.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).

Constraints:
1 <= Number of nodes <= 100000
1 <= K <= 1000000

********************************************************************Solution***************************************************************************/

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;

        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException 
    {    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            int key = Integer.parseInt(br.readLine().trim());
            Solution T = new Solution();
            root = T.insert(root,key);
            inorder(root);
            System.out.println();
            t--;
        }
    }
    
    static void inorder(Node root)
    {
        if(root==null)  return;
    
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}


class Solution
{
    //both recursive and iterative solution takes O(h) times to solve but recursive solution also takes O(h) extra space for recursive function call stack, where h = height of BST
    // Recursive solution to insert new node in BST
    Node insert1(Node root, int key)
    {
        if(root == null)
            return new Node(key);
        
        if(key < root.data)
            root.left = insert(root.left, key);
        else if(key > root.data)
            root.right = insert(root.right, key);
            
        return root;    
    }
    
    //Iterative solution to insert new node in BST 
    Node insert(Node root, int key)
    {
        Node newNode = new Node(key);
        
        if(root == null)
            return newNode;
        
        Node parent = null, curr = root;
        
        while(curr != null)
        {
            parent = curr;
            
            if(key < curr.data)
                curr = curr.left;
            else if(key > curr.data)
                curr = curr.right;  
            else //if the key is present in the BST then there's no need to insert again, will just return root
                return root;
        }
        
        if(key < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;
            
        return root;
    }
}






