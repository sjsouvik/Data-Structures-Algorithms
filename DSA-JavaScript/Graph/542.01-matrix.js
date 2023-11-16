/*

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.


Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

**********************************************************Solution*******************************************************/

/**
 * @param {number[][]} mat
 * @return {number[][]}
 */

/* Refer to this for better understanding https://www.youtube.com/watch?v=BJbaUH9dN24&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=4 */
const updateMatrix = function (mat) {
  const rows = mat.length,
    columns = mat[0].length,
    queue = [];

  /* Will do BFS from the cells with value 0 and update the distance if we find any neighbor cell with value 1. 
  So, as a 1st step, keeping the indexes of the cells containing 0 in a queue and marking the cells with the value 1 
  as unvisited by updating the value to -1 since 1 is also a possible distance from a cell with value 0 to a cell 
  with value 1 */
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (mat[i][j] === 0) {
        queue.push([i, j]);
      } else {
        mat[i][j] = -1;
      }
    }
  }

  // possible moves(top, bottom, left, right) from one cell
  const moves = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];

  while (queue.length > 0) {
    const [row, column] = queue.shift();

    for (const [r, c] of moves) {
      const nextRow = row + r,
        nextCol = column + c;

      /* updating the distance if we find any valid, unvisited cell in the matrix and pushing the index of the 
      currently visited cell into the queue so that we can reach if there's any unvisited cell from the 
      currently visited cell */
      if (
        nextRow >= 0 &&
        nextRow < rows &&
        nextCol >= 0 &&
        nextCol < columns &&
        mat[nextRow][nextCol] === -1
      ) {
        mat[nextRow][nextCol] = mat[row][column] + 1;
        queue.push([nextRow, nextCol]);
      }
    }
  }

  return mat;
};
