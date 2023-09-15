/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Example 1:

Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:

Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

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
 * @param {TreeNode} root
 * @return {boolean}
 */
const isSymmetric = function (root) {
  const isMirrorImageOfItself = (root, rootImage) => {
    if (root === null && rootImage === null) {
      return true;
    }

    if (root === null || rootImage === null) {
      return false;
    }

    const leftMirror = isMirrorImageOfItself(root.left, rootImage.right);
    const rightMirror = isMirrorImageOfItself(root.right, rootImage.left);
    return leftMirror && rightMirror && root.val === rootImage.val;
  };

  return isMirrorImageOfItself(root, root);
};
