/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
************************************************************************Solution*********************************************************************************/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        
        boolean reverse = false;
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {                        
            int size = q.size();
            
            List<Integer> nodesAtLevel = new ArrayList<>();  //this will hold the nodes placed in same level
            
            while(size-- > 0)
            {
                TreeNode removed = q.poll();
                                
                if(reverse)                
                    s.push(removed);                                                   
                else
                    nodesAtLevel.add(removed.val);
                                                               
                if(removed.left != null)
                    q.add(removed.left);

                if(removed.right != null)
                    q.add(removed.right);                
            }
            
            //stack will have data if the reverse is true
            if(reverse)
            {
                while(!s.isEmpty())
                    nodesAtLevel.add(s.pop().val);
            }
            
            reverse = !reverse;            
            
            nodes.add(nodesAtLevel);            
        }
        
        return nodes;
    }
}