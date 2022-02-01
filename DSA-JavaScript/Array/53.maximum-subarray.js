/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

*********************************************************************Solution****************************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

// This is known as Kadane's algorithm
var maxSubArray = function (nums) {
  let maxSoFar = Number.NEGATIVE_INFINITY,
    maxTillHere = 0;

  for (let i = 0; i < nums.length; i++) {
    maxTillHere += nums[i];

    if (maxTillHere > maxSoFar) {
      maxSoFar = maxTillHere;
    }

    if (maxTillHere < 0) {
      maxTillHere = 0;
    }
  }

  return maxSoFar;
};
