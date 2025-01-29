/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

 
Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

*******************************************************Solution****************************************************/

/*

Time complexity: O(m ∗ 4^n)
Space complexity: O(n)
Where m is the number of cells in the board and n is the length of the word.

*/

function exist(board, word) {
  const rows = board.length,
    columns = board[0].length;

  function dfs(row, col, wordIndex) {
    if (wordIndex === word.length) {
      return true;
    }

    if (
      row < 0 ||
      row === rows ||
      col < 0 ||
      col === columns ||
      board[row][col] !== word[wordIndex] ||
      board[row][col] === "0"
    ) {
      return false;
    }

    board[row][col] = "0";
    const result =
      dfs(row + 1, col, wordIndex + 1) ||
      dfs(row - 1, col, wordIndex + 1) ||
      dfs(row, col + 1, wordIndex + 1) ||
      dfs(row, col - 1, wordIndex + 1);
    board[row][col] = word[wordIndex];
    return result;
  }

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (dfs(i, j, 0)) {
        return true;
      }
    }
  }

  return false;
}
