/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

*************************************************************************Solution*****************************************************************************************/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            List<Integer> nodesAtCurrentLevel = new ArrayList<>();
            
            while(size-- > 0)
            {
                TreeNode removed = q.poll();
                
                nodesAtCurrentLevel.add(removed.val);
                
                if(removed.left != null)
                    q.add(removed.left);
                if(removed.right != null)
                    q.add(removed.right);
            }
            
            nodes.add(nodesAtCurrentLevel);
        }
        
        Collections.reverse(nodes); //reversing the list to get the nodes in bottom-up level order
            
        return nodes;
    }
}