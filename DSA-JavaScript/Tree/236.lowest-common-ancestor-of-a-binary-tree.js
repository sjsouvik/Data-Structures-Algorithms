/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two 
nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to 
be a descendant of itself).”


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 10^5].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.

****************************************************Solution***********************************************/


function lowestCommonAncestor(root, p, q) {
    function findPath(rootNode, node, path) {
        if (rootNode === null) {
            return false
        }

        path.push(rootNode)

        if (rootNode.val === node.val || findPath(rootNode.left, node, path) === true || findPath(rootNode.right, node, path) === true) {
            return true
        }

        path.pop()
        return false
    }

    /* The idea is to find the paths from root node to the given node p and q. 
    Then, iterate through the paths to find out the last common node in the path
    - that's known as the LCA of the given nodes */
    const path1 = [], path2 = []
    if (findPath(root, p, path1) === false || findPath(root, q, path2) === false) {
        return null
    }

    let possibleLca = null, i = 0
    while (i < path1.length && i < path2.length) {
        if (path1[i].val === path2[i].val) {
            possibleLca = path1[i]
            i++
        } else {
            break
        }
    }

    return possibleLca
};
