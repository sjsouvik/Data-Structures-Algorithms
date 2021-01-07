/*
You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 
Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 
Constraints:

    The number of nodes in the tree is in the range [2, 1000].
    -231 <= Node.val <= 231 - 1

*****************************************************************************************Solution*******************************************************************************************************/

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
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) 
    {
        inorder(root);
        
        //swapping val part of nodes that were swapped by mistake to get the correct sequence
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
        
    void inorder(TreeNode root)
    {
        if(root == null)
            return;
        
        inorder(root.left);
        
        if(prev != null && root.val < prev.val)
        {
            if(first == null)
                first = prev;
            
            second = root;
        }
        prev = root;
        
        inorder(root.right);
    }
}
