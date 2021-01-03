/*
 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 

****************************************************************************Solution*************************************************************************************************************/

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

// diameter = number of nodes on the longest path between two end nodes = leftHeight + rightHeight + 1
// here, we are counting number of edges on the longest path between two end nodes, that's why we won't add 1 with left and right subtree's height 
class Solution {
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        int heightOfTheTree = height(root);
        
        return diameter;
    }
    
    int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        diameter = Integer.max(diameter, leftHeight + rightHeight);
        
        return Integer.max(leftHeight, rightHeight) + 1;
    }
}