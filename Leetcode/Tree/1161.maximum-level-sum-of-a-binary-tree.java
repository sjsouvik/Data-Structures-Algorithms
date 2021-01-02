/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:

Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -105 <= Node.val <= 105

*******************************************************************Solution***********************************************************************************/

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
    public int maxLevelSum(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.add(root);
        
        int level = 0, maxLevelSum = Integer.MIN_VALUE, levelWithMaxSum = -1;
        while(!q.isEmpty())
        {
            int size = q.size();
            level++;
            
            int levelSum = 0;
            while(size-- > 0)
            {
                TreeNode removed = q.poll();
                
                levelSum += removed.val;
                
                if(removed.left != null)
                    q.add(removed.left);
                
                if(removed.right != null)
                    q.add(removed.right);                
            }
            
            if(levelSum > maxLevelSum)
            {
                maxLevelSum = levelSum;
                levelWithMaxSum = level;
            }
        }
        
        return levelWithMaxSum;
    }
}