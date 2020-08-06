/*
Given a Binary Tree of size N. Find the sum of all the leaf nodes that are left child of their parent of the given binary tree.
Example:

Input : 
         1
        /  \
       2    3
     /  \     \
    4    5     8 
  /  \        /  \
 7    2      6    9
Output :
sum = 6 + 7 = 13

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL 
child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should return the sum of all the left leaf nodes of the binary tree.

Your Task:
You don't need to read input or print anything. Your task is to complete the function leftLeavesSum() which takes the root node of the tree as input and 
returns the sum of all the left leaf nodes present in the given binary tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=T<=50
1<=N<=105

Example:
Input:
2
1 2 3
10 20 30 40 60 90
Output:
2
130

**************************************************************************Solution*************************************************************************/

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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
                  // Create the right child for the curr node
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
            
            Solution T = new Solution();
            System.out.println(T.leftLeavesSum(root));
            
            t--;
        }
    }
}


class Solution
{
    public int leftLeavesSum(Node root) 
    { 
        if(root == null)
            return 0;
        
        /* this condition will check from current root node that whether the left node is leaf or not 
           if this condition satisfies that means we have found the left node of current root node as leaf node, 
           so before returning leaf node's data, we need to check the right subtree of current node as it might have some left leaf nodes */
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.data + leftLeavesSum(root.right);
            
        int leaf1 = leftLeavesSum(root.left); //this will return sum of left leaf nodes in left subtree
        int leaf2 = leftLeavesSum(root.right); //this will return sum of left leaf nodes in right subtree
        
        return leaf1 + leaf2;
    } 

}











