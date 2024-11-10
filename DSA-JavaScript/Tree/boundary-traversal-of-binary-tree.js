/*

Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could 
reach when you always travel preferring the left subtree over the right subtree. 

Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.

Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node 
is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. 
Exclude the root from this as it was already included in the traversal of left boundary nodes.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:

Input:
        1 
      /   \
     2     3  
    / \   / \ 
   4   5 6   7
      / \
     8   9
   
Output: 1 2 4 8 9 6 7 3

Example 2:

Input:
            1
           /
          2
        /  \
       4    9
     /  \    \
    6    5    3
             /  \
            7     8

Output: 1 2 4 6 5 7 8
 
Your Task:
This is a function problem. You don't have to take input. Just complete the function boundary() that 
takes the root node as input and returns an array containing the boundary values in anti-clockwise.

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^5

******************************************************Solution*****************************************************/

function boundaryTraversal(root) {
  function addLeftBoundary(node) {
    let current = node.left;

    while (current) {
      if (!isLeaf(current)) {
        result.push(current.data);
      }

      if (current.left) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
  }

  function addLeaves(node) {
    if (isLeaf(node)) {
      result.push(node.data);
      return;
    }

    if (node.left) {
      addLeaves(node.left);
    }

    if (node.right) {
      addLeaves(node.right);
    }
  }

  function addRightBoundary(node) {
    let current = node.right;
    const rightNodes = [];

    while (current) {
      if (!isLeaf(current)) {
        rightNodes.push(current.data);
      }

      if (current.right) {
        current = current.right;
      } else {
        current = current.left;
      }
    }

    /* need to reverse the right nodes since we stored the right nodes from top(root) to bottom 
        but we need to traverse the tree anti-clockwise to get the boundary traversal. 
        So, in that case, we'll be traversing the right boundary from bottom to top */
    for (let i = rightNodes.length - 1; i >= 0; i--) {
      result.push(rightNodes[i]);
    }
  }

  const result = [];

  if (root === null) {
    return result;
  }

  if (!isLeaf(root)) {
    result.push(root.data);
  }

  addLeftBoundary(root);
  addLeaves(root);
  addRightBoundary(root);

  return result;
}

function isLeaf(node) {
  if (node.left === null && node.right === null) {
    return true;
  }

  return false;
}
