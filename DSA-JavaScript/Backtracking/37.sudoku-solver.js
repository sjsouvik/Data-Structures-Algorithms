/*

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.


Example 1:

Input: board = 
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]

Output: 
[["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]

Explanation: The input board is shown above and the only valid solution is shown below:


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution

*******************************************************Solution***************************************************/

/**
 Do not return anything, modify board in-place instead.
 */
function solveSudoku(board) {
  const length = board.length;

  function isSafe(row, col, digit) {
    for (let i = 0; i < length; i++) {
      if (board[i][col] === digit || board[row][i] === digit) {
        return false;
      }
    }

    const subBoxLength = Math.sqrt(length);
    const rowIndex = row - (row % subBoxLength);
    const colIndex = col - (col % subBoxLength);

    for (let i = 0; i < subBoxLength; i++) {
      for (let j = 0; j < subBoxLength; j++) {
        if (board[rowIndex + i][colIndex + j] === digit) {
          return false;
        }
      }
    }

    return true;
  }

  function backtrack(row, col) {
    if (row === length) {
      return true;
    }

    let nextRowIndex = row,
      nextColIndex = col;
    if (col === length - 1) {
      nextRowIndex += 1;
      nextColIndex = 0;
    } else {
      nextColIndex += 1;
    }

    if (board[row][col] !== ".") {
      return backtrack(nextRowIndex, nextColIndex);
    }

    for (let digit = 1; digit <= 9; digit++) {
      if (isSafe(row, col, String(digit))) {
        board[row][col] = String(digit);
        if (backtrack(nextRowIndex, nextColIndex)) {
          return true;
        }

        board[row][col] = ".";
      }
    }

    return false;
  }

  backtrack(0, 0);
}
