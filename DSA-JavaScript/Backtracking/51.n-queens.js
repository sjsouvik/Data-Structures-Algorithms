/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack 
each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
indicate a queen and an empty space, respectively.
 

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

******************************************************Solution****************************************************/

/*

Time complexity: O(n!)
Space complexity: O(n^2)

*/

function solveNQueens(n) {
  const result = [];
  const board = Array(n)
    .fill(null)
    .map(() => Array(n).fill("."));

  function isSafe(rowIndex, colIndex) {
    for (let row = rowIndex - 1; row >= 0; row--) {
      if (board[row][colIndex] === "Q") {
        return false;
      }
    }

    for (
      let row = rowIndex - 1, col = colIndex - 1;
      row >= 0 && col >= 0;
      row--, col--
    ) {
      if (board[row][col] === "Q") {
        return false;
      }
    }

    for (
      let row = rowIndex - 1, col = colIndex + 1;
      row >= 0 && col < n;
      row--, col++
    ) {
      if (board[row][col] === "Q") {
        return false;
      }
    }

    return true;
  }

  function backtrack(rowIndex) {
    if (rowIndex === n) {
      result.push(board.map((row) => row.join("")));
      return;
    }

    for (let colIndex = 0; colIndex < n; colIndex++) {
      if (isSafe(rowIndex, colIndex)) {
        board[rowIndex][colIndex] = "Q";
        backtrack(rowIndex + 1);
        board[rowIndex][colIndex] = ".";
      }
    }
  }

  backtrack(0);
  return result;
}
