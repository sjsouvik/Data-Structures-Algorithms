/*

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

*************************************************************Solution******************************************************/

/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
const rotate = function (matrix) {
  /* 

    Since the given matrix is a square matrix, we can find out the transpose in place without using any extra 
    memory by swapping element at index (i, j) with the item at index (j, i).
    
    Reference: https://www.youtube.com/watch?v=pqDZdKd1uLQ&t=31s&ab_channel=Pepcoding 
    
    */
  const transpose = () => {
    const n = matrix.length;

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < i; j++) {
        [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
      }
    }
  };

  /* After getting the transpose of the given matrix, we need to reverse the items of each row to get the 
  rotate image finally */
  const reverse = () => {
    const n = matrix.length;

    for (let i = 0; i < n; i++) {
      let left = 0,
        right = n - 1;

      while (left < right) {
        [matrix[i][left], matrix[i][right]] = [
          matrix[i][right],
          matrix[i][left],
        ];
        left++;
        right--;
      }
    }
  };

  transpose();
  reverse();
};
