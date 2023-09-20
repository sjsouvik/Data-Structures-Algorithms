/*

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.


Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1

************************************************************Solution********************************************************/

/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */

const setZeroes = (matrix) => {
  const rowsWithIndex0 = [],
    colsWithIndex0 = [];
  const rows = matrix.length,
    columns = matrix[0].length;

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (matrix[i][j] === 0) {
        rowsWithIndex0.push(i);
        colsWithIndex0.push(j);
      }
    }
  }

  for (const row of rowsWithIndex0) {
    for (let j = 0; j < columns; j++) {
      matrix[row][j] = 0;
    }
  }

  for (const column of colsWithIndex0) {
    for (let i = 0; i < rows; i++) {
      matrix[i][column] = 0;
    }
  }
};

// Alternate solution

/*
const setZeroes = (matrix) => {
    const rowsWithIndex0 = {}, colsWithIndex0 = {};
    const m = matrix.length, n = matrix[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {            
            if (matrix[i][j] === 0) {
                rowsWithIndex0[i] = i;
                colsWithIndex0[j] = j;
            }
        }
    }    

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (rowsWithIndex0[i] !== undefined || colsWithIndex0[j] !== undefined) {
                matrix[i][j] = 0;
            }
        }
    }    
}
*/
