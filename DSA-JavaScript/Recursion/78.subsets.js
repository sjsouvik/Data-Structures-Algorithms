/*

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

*************************************************************Solution*********************************************************/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const subsets = function (nums) {
  const output = [];

  const util = (nums, possibleSubset = []) => {
    if (nums.length === 0) {
      output.push(possibleSubset);
      return;
    }

    util(nums.slice(1), possibleSubset);
    util(nums.slice(1), [...possibleSubset, nums[0]]);
  };

  util(nums);
  return output;
};
