/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

***************************************************************Solution**********************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

/* Boyer-Moore's Majority Vote Algo - this will return one element which might be the majority element. 
So, we need to check whether the count of returned item is more than (n / 2) or not. 
We didn't check that here since the majority element always exists in the array as per this problem statement. */
const majorityElement = function (nums) {
  let count = 0,
    m = -1;

  for (const item of nums) {
    if (count === 0) {
      m = item;
      count = 1;
    } else if (m === item) {
      count++;
    } else {
      count--;
    }
  }

  return m;
};
