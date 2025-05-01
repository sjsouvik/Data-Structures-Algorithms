/*

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the 
values of the nodes in the tree.


Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4

************************************************************Solution**************************************************/

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
 * @param {number} k
 * @return {number}
 */
const kthSmallest = (root, k) => {
  const nodes = [];

  function util(node = root) {
    if (node === null) {
      return;
    }

    util(node.left);
    nodes.push(node.val);
    util(node.right);
  }

  util();
  return nodes[k - 1];
};
