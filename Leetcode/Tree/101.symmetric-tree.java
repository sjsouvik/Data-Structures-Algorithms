/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

*********************************************************************Solution*************************************************************************/

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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorImageOfItself(root, root);                
    }
    
    boolean isMirrorImageOfItself(TreeNode root, TreeNode rootImage){  
        //base case, if both the root nodes are null or we reach at the last nodes while traversing then the tree is symmetric or mirror image of itself
        if(root == null && rootImage == null) 
            return true;                                             
        
        // if both the root nodes are not null and thay have the same value then we need to check the left and right nodes of it to find whether they are symmetric or not
        if((root != null && rootImage != null) && (root.val == rootImage.val))
        {
            boolean isLeftSymmetric = isMirrorImageOfItself(root.left, rootImage.right);
            boolean isRightSymmetric = isMirrorImageOfItself(root.right, rootImage.left);
            
            return isLeftSymmetric && isRightSymmetric;
        }        
        
        return false;
    }
}