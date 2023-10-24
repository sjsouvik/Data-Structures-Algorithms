/*

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

***************************************************************Solution***************************************************/

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

// this problem & solution is same as the coin change problem that we solved using dynamic programming
const combinationSum = function (candidates, target) {
  const result = [];

  const util = (target, n = candidates.length, ans = []) => {
    if (target === 0) {
      result.push(ans);
      return;
    }

    if (n === 0 || target < 0) {
      return;
    }

    util(target - candidates[n - 1], n, [...ans, candidates[n - 1]]);
    util(target, n - 1, ans);
  };

  util(target);

  return result;
};

//another solution
const anotherCombinationSum = function (candidates, target) {
  const result = [];

  const util = (target, n = candidates.length, ans = []) => {
    if (target === 0) {
      result.push(ans);
      return;
    }

    if (n === 0) {
      return;
    }

    /* if the candidate is less than or equal to the target, we have 2 possible choices - either select the 
    candidate and reduce the target or, skip the candidate */
    if (candidates[n - 1] <= target) {
      // selecting the candidate
      util(target - candidates[n - 1], n, [...ans, candidates[n - 1]]);

      // skipping the candidate
      util(target, n - 1, ans);
    } else {
      util(target, n - 1, ans);
    }
  };

  util(target);

  return result;
};
