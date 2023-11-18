/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

*********************************************************Solution********************************************************/

/**
 * @param {number[][]} grid
 * @return {number}
 */
const orangesRotting = function (grid) {
  const rows = grid.length,
    columns = grid[0].length,
    queue = [];
  let freshOrangesCount = 0;

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (grid[i][j] === 2) {
        queue.push([i, j]);
      } else if (grid[i][j] === 1) {
        freshOrangesCount++;
      }
    }
  }

  // if there're only empty cells present
  if (queue.length === 0 && freshOrangesCount === 0) {
    return 0;
  }

  const possibleMoves = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];
  let time = -1;
  while (queue.length > 0) {
    time++;
    let size = queue.length;

    while (size-- > 0) {
      const [row, col] = queue.shift();

      for (const [r, c] of possibleMoves) {
        const neighborRow = row + r,
          neighborCol = col + c;

        if (
          neighborRow >= 0 &&
          neighborRow < rows &&
          neighborCol >= 0 &&
          neighborCol < columns &&
          grid[neighborRow][neighborCol] === 1
        ) {
          grid[neighborRow][neighborCol] = 2; // marking as visited by making it rotten
          freshOrangesCount--;
          queue.push([neighborRow, neighborCol]);
        }
      }
    }
  }

  return freshOrangesCount > 0 ? -1 : time;
};
