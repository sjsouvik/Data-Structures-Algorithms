/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*****************************************************************************************Solution*************************************************************************************************/

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
    //from sorted array or inorder traversal of BST to BST as inorder traversal of BST gives elements in ascending order
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return constructBST(nums, 0, nums.length - 1);
    }
    
    TreeNode constructBST(int a[], int l, int h)
    {
        if(l > h)
            return null;
        
        int mid = l + ((h - l) / 2);
        
        TreeNode root = new TreeNode(a[mid]);
        
        root.left = constructBST(a, l, mid - 1);
        root.right = constructBST(a, mid + 1, h);
        
        return root;
    }
}