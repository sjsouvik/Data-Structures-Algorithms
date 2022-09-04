/*

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

******************************************************Solution************************************************/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
const buildTree = function(preorder, inorder) {
    let index = 0;
    
    const inorderMap = new Map();
    
    for(let i = 0; i < inorder.length; i++){
        inorderMap.set(inorder[i], i);
    }
    
    const findIndexInInorder = (start, end, value) => {        
        for(let i = start; i <= end; i++){
            if(inorder[i] === value){
                return i;                
            }
        }
        
        return -1;
    }
    
    const utilBuildTree = (start, end) => {
        if(start > end){
            return null;
        }
        
        const value = preorder[index++];
        
        const root = new TreeNode(value);
        
        // const position = findIndexInInorder(start, end, value); // this would take O(n) time for each node and overall complexity becomes O(n^2). A map can be used to reduce the search time to O(1) and overall complexity to O(n).
        
        const position = inorderMap.get(value);
        
        root.left = utilBuildTree(start, position - 1);
        root.right = utilBuildTree(position + 1, end);
        
        return root;
    }
    
    return utilBuildTree(0, preorder.length - 1);
};