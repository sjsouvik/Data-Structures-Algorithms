/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique 
combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.


Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

******************************************************Solution****************************************************/

/*

Time complexity: O(n ∗ 2^n)
Space complexity: O(n)

*/

function combinationSum2(candidates, target) {
  const result = [];
  candidates.sort((a, b) => b - a);

  function util(n = candidates.length, sum = target, ans = []) {
    if (sum === 0) {
      result.push(ans);
      return;
    }

    if (n === 0 || sum < 0) {
      return;
    }

    util(n - 1, sum - candidates[n - 1], [...ans, candidates[n - 1]]);

    let i = n - 1;
    while (i >= 1 && candidates[i] === candidates[i - 1]) {
      i--;
      n--;
    }

    util(n - 1, sum, ans);
  }

  util();
  return result;
}
