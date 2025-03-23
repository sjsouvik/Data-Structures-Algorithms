/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the 
following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false

Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are 
two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

**********************************************************Solution******************************************************/

/**
 * @param {character[][]} board
 * @return {boolean}
 */
const isValidSudoku = function (board) {
  const length = board.length;
  const squareLength = Math.sqrt(length);

  const rows = new Map();
  const columns = new Map();
  const squares = new Map();

  for (let row = 0; row < length; row++) {
    for (let col = 0; col < length; col++) {
      const squareKey = `${Math.floor(row / squareLength)},${Math.floor(
        col / squareLength
      )}`;
      if (!rows.has(row)) {
        rows.set(row, new Set());
      }

      if (!columns.has(col)) {
        columns.set(col, new Set());
      }

      if (!squares.has(squareKey)) {
        squares.set(squareKey, new Set());
      }

      const digit = board[row][col];
      if (digit !== ".") {
        if (
          rows.get(row).has(digit) ||
          columns.get(col).has(digit) ||
          squares.get(squareKey).has(digit)
        ) {
          return false;
        }
      }

      rows.get(row).add(digit);
      columns.get(col).add(digit);
      squares.get(squareKey).add(digit);
    }
  }

  return true;
};
