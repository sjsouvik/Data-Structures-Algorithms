/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

*****************************************************************Solution***************************************************/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

const getHeightIfBalanced = (root) => {
    if(!root){
        return 0;
    }
    
    const leftHeight = getHeightIfBalanced(root.left);
    
    if(leftHeight === -1){
        return -1;
    }
    
    const rightHeight = getHeightIfBalanced(root.right);
    
    if(rightHeight === -1){
        return -1;
    }
    
    if(Math.abs(leftHeight - rightHeight) > 1){
        return -1;
    }
    
    return 1 + Math.max(leftHeight, rightHeight);
}

const isBalanced = (root) => {    
    return getHeightIfBalanced(root) === -1 ? false : true;
};