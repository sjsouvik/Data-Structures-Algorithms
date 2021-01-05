/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

You should return this subtree:

      2     
     / \   
    1   3

In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.

********************************************************************************Solution********************************************************************************************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    //Iterative Solution - time complexity : O(n), aux space complexity : O(1)
    public TreeNode searchBST(TreeNode root, int val)
    {
        TreeNode curr = root;
        
        while(curr != null)
        {
            //if the searched value is less than the current node's value then search on left subtree of current node
            if(val < curr.val)
                curr = curr.left;
            
            //if the searched value is greater than the current node's value then search on right subtree of current node
            else if(val > curr.val)
                curr = curr.right;
            
            else //if(val == curr.val)
                return curr;
        }
        
        return null;
    }
    
    //Recursive Solution - time complexity : O(n), aux space complexity : O(height)
    TreeNode searchBST(TreeNode root, int val)
    {
        if(root == null)
            return null;
        
        if(root.val == val)
            return root;
        
        if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}