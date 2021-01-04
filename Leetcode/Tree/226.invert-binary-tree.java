/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*******************************************************************************Solution**********************************************************************/

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
    //DFS based solution - preorder based
    public TreeNode invertTree(TreeNode root) 
    {
        if(root == null)
            return null;
        
        invertUtil(root);
        return root;
    }
    
    void invertUtil(TreeNode root)
    {
        //swapping the left and right subtree of current root node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
    }
    
    //BFS solution
//     public TreeNode invertTree(TreeNode root) 
//     {
//         Queue<TreeNode> q = new LinkedList<>();
//         if(root != null)
//             q.add(root);
        
//         while(!q.isEmpty())
//         {
//             TreeNode removed = q.poll();
            
//             //swapping the left and right subtree of current removed node
//             TreeNode temp = removed.left;
//             removed.left = removed.right;
//             removed.right = temp;
            
//             if(removed.left != null)
//                 q.add(removed.left);
            
//             if(removed.right != null)
//                 q.add(removed.right);
//         }
        
//         return root;
//     }    
}