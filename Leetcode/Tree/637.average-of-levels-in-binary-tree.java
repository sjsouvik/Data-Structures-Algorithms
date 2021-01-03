/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:

    The range of node's value is in the range of 32-bit signed integer.

*********************************************************************************Solution*************************************************************************************************************************/

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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.add(root);
        
        List<Double> avgValues = new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int size = q.size(), numberOfNodes = size;
            
            long levelSum = 0;
            while(size-- > 0)
            {
                TreeNode removed = q.poll();
                
                levelSum += removed.val;
                
                if(removed.left != null)
                    q.add(removed.left);
                
                if(removed.right != null)
                    q.add(removed.right);
            }
            
            avgValues.add((double)levelSum / numberOfNodes);
        }
        
        return avgValues;
    }
}
