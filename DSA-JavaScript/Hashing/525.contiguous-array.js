/*

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.


Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.

**************************************************************Solution******************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

/*

The idea is to consider '0's as '-1' and this problem would turn into finding subarrays with sum '0' 
where we need to find the max length of the subarray with sum '0'.

*/

const findMaxLength = function (nums) {
  let prefixSum = 0,
    maxLength = 0;

  const obj = {};
  obj[prefixSum] = -1;

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 0) {
      prefixSum -= 1;
    } else {
      prefixSum += nums[i];
    }

    if (obj[prefixSum] !== undefined) {
      maxLength = Math.max(maxLength, i - obj[prefixSum]);
    } else {
      obj[prefixSum] = i;
    }
  }

  return maxLength;
};
