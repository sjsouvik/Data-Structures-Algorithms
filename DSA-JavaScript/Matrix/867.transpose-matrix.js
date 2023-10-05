/*

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
-10^9 <= matrix[i][j] <= 10^9

************************************************************Solution********************************************************/

/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
const transpose = function (matrix) {
  const rows = matrix.length,
    columns = matrix[0].length;

  /* dimension of a transpose of a matrix with dimension (m * n) 
  (where m, n = number of rows, columns in the matrix respectively) would be (n * m) */
  const result = [];

  for (let i = 0; i < columns; i++) {
    result[i] = [];
    for (let j = 0; j < rows; j++) {
      result[i][j] = matrix[j][i];
    }
  }

  return result;
};
