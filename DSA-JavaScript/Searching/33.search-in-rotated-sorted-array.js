/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-10^4 <= target <= 10^4

***************************************************************Solution*******************************************************/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = function (nums, target) {
  let low = 0,
    high = nums.length - 1,
    mid;

  while (low <= high) {
    mid = low + Math.floor((high - low) / 2);

    if (nums[mid] === target) {
      return mid;
    }

    /* Comparing mid item with the 1st item in the list to know whether the left half is sorted or not, if the mid item 
    is greater than or equal to the 1st item in the list then we know that we're in the left half of the array which is sorted. */
    if (nums[low] <= nums[mid]) {
      /* Next, we need to check whether the target item lies in the left half or not(1stItem <=target < midItem), 
      if it lies in that range, update the high pointer to search in the left half part, else we need to update 
      the low pointer to discard the left half part */
      if (target >= nums[low] && target < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    } else {
      if (target > nums[mid] && target <= nums[high]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }

  return -1;
};
