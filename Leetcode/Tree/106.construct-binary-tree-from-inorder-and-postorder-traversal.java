/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*******************************************************************Solution**********************************************************************/

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
    int postorderIndex = -1;
    
    //The idea is to traverse the postorder array to take node one by one, make as root node and find its left and right subtree from the inorder array 
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        postorderIndex = postorder.length - 1;
        
        //this would help to get the index of root node in inorder array in O(1) time
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            m.put(inorder[i], i);
        
        return construct(inorder, postorder, 0, inorder.length - 1, m);
    }
        
    TreeNode construct(int inorder[], int postorder[], int inorderStart, int inorderEnd, Map<Integer, Integer> m)
    {
        //if 1st index of inorder array is greater than the last index of it then, there's no left or right subtree of the root node  
        if(inorderStart > inorderEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        
        int indexOfRootInInorder = -1;
        
        //finding the index of the root node in the inorder array so that can find the nodes at left and right subtree of root node - to get the index of the root node if we traverse the inorder array and find then time complexity of the solution would be O(n^2) since for each node of postorder traversal, we are looping through the inorder array to find the index, we can use HashMap instead to reduce it to O(n). However, space complexity will increase then.  
        // for(int i = inorderStart; i <= inorderEnd; i++)
        // {
        //     if(inorder[i] == root.val)
        //     {
        //         indexOfRootInInorder = i;
        //         break;
        //     }
        // }
        
        indexOfRootInInorder = m.get(root.val);
        
        root.right = construct(inorder, postorder, indexOfRootInInorder + 1, inorderEnd, m);
        root.left = construct(inorder, postorder, inorderStart, indexOfRootInInorder - 1, m);
        
        return root;
    }
}
