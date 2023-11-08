/*

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

***********************************************************Solution*******************************************************/

/**
 * @param {character[][]} grid
 * @return {number}
 */

/* The concept to find the number of connected components in a graph has been used to solve this problem */
const numIslands = function (grid) {
  const rows = grid.length,
    columns = grid[0].length;
  let result = 0;

  const findLand = (sr, sc) => {
    if (
      sr < 0 ||
      sr === rows ||
      sc < 0 ||
      sc === columns ||
      grid[sr][sc] === "0"
    ) {
      return;
    }

    /* marking the cell as visited by updating the cell value to "0", so if any cell contains "0" 
    i.e. either that contains water or that cell is visited */
    grid[sr][sc] = "0";
    findLand(sr - 1, sc);
    findLand(sr + 1, sc);
    findLand(sr, sc + 1);
    findLand(sr, sc - 1);
  };

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (grid[i][j] === "1") {
        findLand(i, j);
        result++;
      }
    }
  }

  return result;
};
