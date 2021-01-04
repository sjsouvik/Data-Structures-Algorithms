/*
Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Note:

    1 <= pre.length == post.length <= 30
    pre[] and post[] are both permutations of 1, 2, ..., pre.length.
    It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.

****************************************************************************Solution*****************************************************************************************************/

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) 
    {
        // Map is used to find index of any element in postorder sequence efficiently
        Map<Integer, Integer> postorderMap = new HashMap<>();
        
        for(int i = 0; i < post.length; i++)
            postorderMap.put(post[i], i);
        
        return construct(pre, 0, post.length - 1, postorderMap);
    }
    
    int preorderIndex = 0;
    
    TreeNode construct(int preorder[], int postorderStart, int postorderEnd, Map<Integer, Integer> postorderMap)
    {      
        if(postorderStart > postorderEnd)
            return null;
                
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
                
        if(postorderStart == postorderEnd)
            return root;
        
        // index of next element in postorder sequence to find out the boundary of left and right subtree of the current root node
        int indexOfRootInPostorder = postorderMap.get(preorder[preorderIndex]);        
        
        root.left = construct(preorder, postorderStart, indexOfRootInPostorder, postorderMap);
        root.right = construct(preorder, indexOfRootInPostorder + 1, postorderEnd - 1, postorderMap);
       
        return root;
    }
}