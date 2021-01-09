/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

****************************************************************************************Solution*****************************************************************************************/

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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> paths = new ArrayList<>();
        
        preorder(root, paths, "");
        
        return paths;
    }
    
    void preorder(TreeNode root, List<String> paths, String path)
    {
        if(root == null)
            return;        
        
        if(root.left == null && root.right == null)
        {
            path += root.val;
            paths.add(path);
        }
        else            
            path += root.val +"->";
                        
        preorder(root.left, paths, path);                        
        preorder(root.right, paths, path);
        
        if(path.length() >= 3)
            path.substring(0, path.length() - 3); //backtracking step so that can explore other existing paths, removing node with "->" one by one from end of the path when we got 1 path. 
    }
}