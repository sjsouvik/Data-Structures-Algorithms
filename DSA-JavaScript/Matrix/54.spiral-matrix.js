/*

Given an m x n matrix, return all elements of the matrix in spiral order.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*****************************************************************Solution**********************************************************/

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    const res = [], r = matrix.length, c = matrix[0].length;
    let top = 0, right = c - 1, bottom = r - 1, left = 0;
    
    while(top <= bottom && left <= right){
        // top row - left to right
        for(let j = left; j <= right; j++){
            res.push(matrix[top][j]);            
        }
        
        top++;
        
        // right column - top to bottom
        for(let i = top; i <= bottom; i++){
            res.push(matrix[i][right]);
        }
        
        right--;
        
        if(top <= bottom){
            // bottom row - right to left
            for(let j = right; j >= left; j--){
                res.push(matrix[bottom][j]);
            }

            bottom--;
        }        
        
        if(left <= right){
            // left column - bottom to top
            for(let i = bottom; i >= top; i--){
                res.push(matrix[i][left]);
            }

            left++;
        }        
    }
    
    return res;
};