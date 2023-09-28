/*

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.


Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 10^9

************************************************************Solution*********************************************************/

/**
 * @param {number[]} nums
 * @return {string}
 */
const largestNumber = function (nums) {
  const n = nums.length;

  // convert array of numbers to array of strings
  for (let i = 0; i < n; i++) {
    nums[i] = String(nums[i]);
  }

  /* Sort the array in such a way that if there're 2 numbers 'a', 'b' which can be used to form 2 numbers (ab) or, (ba) and if Number(ab) > Number(ba), then we'll place the 'a' in the array later than 'b', so that when we form the number by traversing the array from the end, 'a' will be appended first in the result than 'b' */
  const sortedNums = nums.sort((a, b) => {
    const n1 = Number(a + b);
    const n2 = Number(b + a);

    if (n1 > n2) {
      return 1;
    }

    if (n1 < n2) {
      return -1;
    }

    return 0;
  });

  let result = "";
  for (let i = n - 1; i >= 0; i--) {
    result += sortedNums[i];
  }

  /* if '0' is the 1st character in the result, that means all the characters after that are less than or equal to that, so return '0' in that case */
  if (result[0] === "0") {
    return result[0];
  }

  return result;
};
