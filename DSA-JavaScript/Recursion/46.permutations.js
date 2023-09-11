/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

**************************************************************Solution*****************************************************/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */

/*
Refer to this video to understand about the solution in detail:
https://www.youtube.com/watch?v=sPAT_DbvDj0&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=43&ab_channel=Pepcoding

 */
const permute = function (nums) {
  const result = [];

  const util = (arr, possiblePermutation = []) => {
    if (arr.length === 0) {
      result.push(possiblePermutation);
      return;
    }

    for (let i = 0; i < arr.length; i++) {
      util(arr.slice(0, i).concat(arr.slice(i + 1)), [
        ...possiblePermutation,
        arr[i],
      ]);
    }
  };

  util(nums);

  return result;
};
