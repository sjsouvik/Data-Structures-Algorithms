/*

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 
Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

*************************************************************Solution********************************************************/

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */

const searchMatrix = function (matrix, target) {
  const rows = matrix.length,
    columns = matrix[0].length;

  /* this is to find the index of the potential row where the target item might be present */
  const findPotentialRowIndex = () => {
    let low = 0,
      high = rows - 1,
      mid;

    while (low <= high) {
      mid = low + Math.floor((high - low) / 2);
      const rowFirstItem = matrix[mid][0],
        rowLastItem = matrix[mid][columns - 1];

      if (target >= rowFirstItem && target <= rowLastItem) {
        return mid;
      }

      if (rowLastItem < target) {
        low = mid + 1;
      } else if (rowFirstItem > target) {
        high = mid - 1;
      }
    }

    return -1;
  };

  const potentialRowIndex = findPotentialRowIndex();

  if (potentialRowIndex === -1) {
    return false;
  }

  const potentialRow = matrix[potentialRowIndex];

  /* once we have the potential row where the target item might lie, we need to search and confirm whether 
  the target item is actually present or not */
  const findTarget = () => {
    let low = 0,
      high = columns - 1,
      mid;

    while (low <= high) {
      mid = low + Math.floor((high - low) / 2);

      if (potentialRow[mid] === target) {
        return mid;
      }

      if (potentialRow[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  };

  return findTarget() !== -1;
};
