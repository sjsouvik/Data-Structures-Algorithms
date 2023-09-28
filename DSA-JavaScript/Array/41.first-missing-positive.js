/*

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 
Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1

**************************************************************Solution*******************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

/*

In this problem, we have to find out the missing smallest positive number that's in the range(1 <= item <= nums.length).

The brute force approach would be to check the presence of each item in the given range starting from 1 
and return the 1st one that's not found. Time complexity will be O(n^2).

*/

const firstMissingPositive = function (nums) {
  const n = nums.length;

  let found1 = false;

  /* Replacing all the items by 1 that are not in the range(1 <= item <= n). Also, checking the smallest positive 
    number 1 is present or not in the given array, if it's not present then 1 would be the result. After this step, 
    all the items would be in the given range */
  for (let i = 0; i < n; i++) {
    if (nums[i] === 1) {
      found1 = true;
    }

    if (nums[i] < 1 || nums[i] > n) {
      nums[i] = 1;
    }
  }

  if (found1 === false) {
    return 1;
  }

  /* Make the item at givenArray[currentIndex - 1] negative for each index. After following this step as well, 
    if we have some positive number in the array that means the missing number is (i + 1), else the missing number is (n + 1) */
  for (let i = 0; i < n; i++) {
    const index = Math.abs(nums[i]) - 1;
    nums[index] = -Math.abs(nums[index]);
  }

  for (let i = 0; i < n; i++) {
    if (nums[i] > 0) {
      return i + 1;
    }
  }

  return n + 1;
};
