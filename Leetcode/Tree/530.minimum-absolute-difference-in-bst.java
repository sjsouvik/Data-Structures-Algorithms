/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3). 

Note:

    There are at least two nodes in this BST.
    This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*************************************************************************************Solution********************************************************************************/

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
    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) 
    {        
        inorder(root);
        
        return diff;        
    }
      
    int prev = -1, current = -1;
    void inorder(TreeNode root)
    {
        if(root == null)
            return;
        
        inorder(root.left);
                
        current = root.val;    
        
        if(prev != -1)
            diff = Integer.min(diff, Math.abs(prev - current));
        
        prev = current;
        
        inorder(root.right);
    }
}
