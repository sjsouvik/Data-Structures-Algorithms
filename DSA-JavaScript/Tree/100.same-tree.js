/*

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

************************************************************Solution*********************************************************/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
const isSameTree = (p, q) => {
    // 1st, checking if both root nodes are null, in that case both are identical
    if(!p && !q){
        return true;
    }
    
    // 2nd, if both are not null or, data of both root nodes are not equal, then trees are not identical
    if(!p || !q || p.val !== q.val){
        return false;
    }
    
    // if data of both root nodes are same then should check for the same in case of left, right subtree
    const leftIdentical = isSameTree(p.left, q.left);
    const rightIdentical = isSameTree(p.right, q.right);        
    
    return leftIdentical && rightIdentical;
};

