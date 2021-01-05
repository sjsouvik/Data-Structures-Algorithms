/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Follow up: Can you solve it with time complexity O(height of tree)? 

Example 1:

Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:

Input: root = [], key = 0
Output: []

Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -105 <= Node.val <= 105
    Each node has a unique value.
    root is a valid binary search tree.
    -105 <= key <= 105

*********************************************************************************Solution**********************************************************************************************************/

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
    // time complexity - O(height), aux space complexity - O(height)
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null)
            return null;
        
        if(key < root.val)
            root.left = deleteNode(root.left, key);
            
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        
        else
        {
            if(root.left == null)
                return root.right;

            if(root.right == null)
                return root.left;

            //if the node to be deleted has both the childs then we need to replace it with closest greater node(inorder successor) or closest smaller node(inorder predecessor) node and then delete the node that's being used to replace the deleted node  
            TreeNode node = getInorderSuccessor(root);
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }
        
        return root;
    }        
    
    //this method will return inorder successor of given node where the node has both the childs. 
    //NOTE : It will give correct inorder successor node only for nodes having both the childs
    TreeNode getInorderSuccessor(TreeNode root)
    {
        TreeNode curr = root.right;
        
        while(curr != null && curr.left != null)
            curr = curr.left;
        
        return curr;
    }
}