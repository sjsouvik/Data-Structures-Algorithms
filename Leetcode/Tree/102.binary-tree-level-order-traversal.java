/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
****************************************************************************Solution*************************************************************************************/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            List<Integer> nodesAtLevel = new ArrayList<>();  //this will hold the nodes placed in same level
            
            while(size-- > 0)
            {                                
                TreeNode currentNode = q.poll();                
                
                nodesAtLevel.add(currentNode.val);
                
                if(currentNode.left != null)
                    q.add(currentNode.left);
                
                if(currentNode.right != null)
                    q.add(currentNode.right);
            }
            
            nodes.add(nodesAtLevel);
        }
        
        return nodes;
    }
}