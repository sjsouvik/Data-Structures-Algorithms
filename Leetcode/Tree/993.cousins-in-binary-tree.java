/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 
Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Constraints:

    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.

*********************************************************************************Solution**************************************************************************************/

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
class NodeInfo
{
    TreeNode parent;
    int val, level;
    
    NodeInfo(int n, int l, TreeNode p)
    {
        val = n;
        level = l;
        parent = p;
    }
}

class Solution 
{    
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        if(root == null)
            return false;
        
        //this will store level as 1 and parent as null initially for node x and y, will assign correct level and parent details while doing inorder traversal
        NodeInfo nodeX = new NodeInfo(x, 1, null); 
        NodeInfo nodeY = new NodeInfo(y, 1, null);
        
        inorder(root, null, 1, nodeX, nodeY);
        
        return (nodeX.level == nodeY.level) && (nodeX.parent != nodeY.parent); //x and y has to be in same level where parents of x, y will be different
    }
    
    void inorder(TreeNode root, TreeNode parent, int level, NodeInfo x, NodeInfo y)
    {
        if(root == null)
            return;
        
        inorder(root.left, root, level + 1, x, y);
        
        //if x is found in the tree then store its level and parent info
        if(root.val == x.val)
        {
            x.parent = parent;
            x.level = level;
        }
           
        //if y is found in the tree then store its level and parent info
        if(root.val == y.val)
        {
            y.parent = parent;
            y.level = level;
        }
                    
        inorder(root.right, root, level + 1, x, y);
    }
}