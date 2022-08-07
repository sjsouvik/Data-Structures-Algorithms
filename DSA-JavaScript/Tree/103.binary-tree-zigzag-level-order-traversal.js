/*

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

*****************************************************************Solution****************************************************/

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
 * @return {number[][]}
 */
function zigzagLevelOrder(root) {
    const stack1 = [], stack2 = [], res = [];
    
    if(!root){
        return res;        
    }
    
    stack1.push(root);
    
    /* the idea is to use 2 stacks to put items of alternate levels in alternate stacks 
        i.e. if I put items of level 0 in stack 1, will put items of next level in the other stack.
        The other thing to keep in mind is if we need to traverse left to right for the next level, 
        put the right node 1st into the stack and then the left node so that you can access 
        left node first from the stack */
    
    while(stack1.length || stack2.length){
        let nodesPerLevel = [];
        let removedNode;
        
        while(stack1.length){
            removedNode = stack1.pop();
            nodesPerLevel.push(removedNode.val);
            
            if(removedNode.left){
                stack2.push(removedNode.left);
            }
            
            if(removedNode.right){
                stack2.push(removedNode.right);
            }                        
        }
        
        res.push(nodesPerLevel);
        nodesPerLevel = [];
                
        while(stack2.length){            
            removedNode = stack2.pop();
            nodesPerLevel.push(removedNode.val);
            
            if(removedNode.right){
                stack1.push(removedNode.right);
            }
            
            if(removedNode.left){
                stack1.push(removedNode.left);
            }
        }
        
        if(nodesPerLevel.length){
            res.push(nodesPerLevel);    
        }        
    }
    
    return res;
}
