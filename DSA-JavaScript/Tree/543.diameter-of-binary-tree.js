/*

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 
Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

**************************************************************Solution*******************************************************/

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
 * @return {number}
 */

/* diameter = number of nodes on the longest path between two end nodes = leftHeight + rightHeight + 1.

Now, we need to calculate the number of edges on the longest path between two end nodes, 
that's why we won't add 1 to the total sum of left and right height */

const diameterOfBinaryTree = function (root) {
  let diameter = 0;

  const findHeight = (root) => {
    if (root === null) {
      return 0;
    }

    const leftHeight = findHeight(root.left);
    const rightHeight = findHeight(root.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return Math.max(leftHeight, rightHeight) + 1;
  };

  findHeight(root);
  return diameter;
};
