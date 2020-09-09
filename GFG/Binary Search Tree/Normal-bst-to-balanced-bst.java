/*
Given a Binary Search Tree of size N, that may be unbalanced. Your task is to complete the function buildBalancedTree(), that convert the given BST into 
a balanced BST that has minimum possible height.

Examples :

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30

Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4 


Input:
The function takes a single argument as input, the reference pointer to the root of the Binary Search Tree.
There are T, test cases and for each test case the function will be called separately.

Output:
For each test case output will be the new height of the BST.

Constraints:
1<=T<=100
1<=N<=200

Example:
Input:
2
3
30 20 10
5
10 8 7 6 5
Output:
2
3

*********************************************************************Solution******************************************************************************/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    static Node insert(Node node, int data)
    {
        if (node == null)
        {
            return (new Node(data));
        } 
	else 
        {             
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data)
            {
                node.left = insert(node.left, data);
            } 
	    else 
            {
                node.right = insert(node.right, data);
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }
    
    }
    
    int height(Node node) 
    {
        if (node==null) return 0;
        else
        {
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            if (lDepth > rDepth)
                return(lDepth+1);
            else 
                return(rDepth+1);
       }
    } 
    
         public static void main (String[] args) 
         {
             Scanner sc = new Scanner(System.in);
             int t = sc.nextInt();
        
             while(t-- > 0)
             {
                 int n = sc.nextInt();
                 Node root = null;
            
                 while(n-- > 0)
                 {
                     int data = sc.nextInt();
                     root = insert(root, data);
                 }
           
                 GfG gfg = new GfG();
             
                 root =  gfg.buildBalancedTree(root);            
                 BinarySearchTree bst = new BinarySearchTree();
                 System.out.println(bst.height(root));
             }
    	 }
    
     void preOrder(Node node) 
     {
         if (node == null)
             return;
         System.out.print(node.data + " ");
         preOrder(node.left);
         preOrder(node.right);
     }
}

class GfG
{
    /* The idea is to store inorder traversal of the BST into an arraylist and then build the BST from the arraylist to get balanced BST. 
    Time complexity : O(n) and space complexity : O(n) since we are using ArrayList to store the inorder traversal of the given BST */
    //It could be optimized more to reduce the space complexity, refer to this link for more optimized solution : https://www.techiedelight.com/construct-height-balanced-bst-from-unbalanced-bst/ 
    Node buildBalancedTree(Node root) 
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        inorder(root, al);
        
        return constructBST(al, 0, al.size() - 1);
    }
    
    void inorder(Node root, ArrayList<Integer> a)
    {
        if(root == null)
            return;
        
        inorder(root.left, a);
        a.add(root.data);
        inorder(root.right, a);
    }
    
    Node constructBST(ArrayList<Integer> a, int l, int h)
    {
        if(l > h)
            return null;
            
        int mid = l + ((h - l) / 2);
        
        Node root = new Node(a.get(mid));
        root.left = constructBST(a, l, mid - 1);
        root.left = constructBST(a, mid + 1, h);
        
        return root;
    }
}








