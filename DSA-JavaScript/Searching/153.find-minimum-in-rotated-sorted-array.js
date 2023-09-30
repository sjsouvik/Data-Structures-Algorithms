/*

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.


Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

************************************************************Solution********************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

const findMin = (arr) => {
  const size = arr.length;

  // when the given array is sorted but not rotated, the 1st item would be the smallest item
  if (arr[0] < arr[size - 1] || size === 1) {
    return arr[0];
  }

  let low = 0,
    high = size - 1,
    mid;
  while (low <= high) {
    mid = low + Math.floor((high - low) / 2);

    // if the mid item is less than the item in its previous index, then that's the smallest item
    if (arr[mid] < arr[mid - 1]) {
      return arr[mid];
    }

    // if the mid item is greater than the next item, then that's the smallest item
    if (arr[mid] > arr[mid + 1]) {
      return arr[mid + 1];
    }

    /* If the mid item is greater than the 1st item in the given array, then we're in the left half of the array, 
    so need to update the low pointer to find out the smallest item in the array. If the mid item is less than the 
    last item in the array, then we're in the right half of the array, so need to update the high pointer to 
    find out the minimum item in the array */
    if (arr[mid] > arr[0]) {
      low = mid + 1;
    } else if (arr[mid] < arr[size - 1]) {
      high = mid - 1;
    }
  }

  return -1;
};

// Another solution
const findMin2 = (nums) => {
  const toCompare = nums[0],
    size = nums.length;
  let start = 0,
    end = size - 1,
    mid;

  /* when the given array is sorted but not rotated, the 1st item would be the smallest item */
  if (nums[start] < nums[end] || size === 1) {
    return nums[0];
  }

  while (start <= end) {
    mid = start + Math.floor((end - start) / 2);

    const prevMid = (mid + size - 1) % size;
    const nextMid = (mid + 1) % size;

    if (nums[mid] < nums[prevMid] && nums[mid] < nums[nextMid])
      return nums[mid];

    if (nums[mid] >= toCompare) start = mid + 1;
    else if (nums[mid] < toCompare) end = mid - 1;
  }

  return -1;
};
