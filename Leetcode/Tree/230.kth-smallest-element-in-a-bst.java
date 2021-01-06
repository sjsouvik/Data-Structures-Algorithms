/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 
Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 
Constraints:

    The number of elements of the BST is between 1 to 10^4.
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

********************************************************************************************Solution**************************************************************************************************/

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
    int kthSmallest = -1;
    public int kthSmallest(TreeNode root, int k) 
    {
        inorder(root, k);
        
        return kthSmallest;    
    }
    
    int i = 0;
    void inorder(TreeNode root, int k)
    {
        if(root == null)
            return;
        
        inorder(root.left, k);
        
        if(kthSmallest != -1)
            return;
        
        i++;
        if(i == k)
        {
            kthSmallest = root.val;
            return;
        }
                            
        inorder(root.right, k);        
    }
}