/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

**************************************************************Solution*******************************************************/

/**
 * @param {number[]} nums
 * @return {number[]}
 */

/*

The idea is to keep an array(say, productFromRight) where we can keep the product of all the visited numbers from 
the right for each index.

Then, we can traverse the array from index 0, keep the product of all the visited numbers from the left in a 
variable(say, productFromLeft) and calculate the product for index 'i' by multiplying product so far till 
index (i - 1) with the products of all the numbers from (i + 1) till the end.

*/

const productExceptSelf = function (nums) {
  const productFromRight = [];
  let product = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    product *= nums[i];
    productFromRight[i] = product;
  }

  let productFromLeft = 1,
    result = [];
  for (let i = 0; i < nums.length - 1; i++) {
    result[i] = productFromLeft * productFromRight[i + 1];
    productFromLeft *= nums[i];
  }

  result[nums.length - 1] = productFromLeft;
  return result;
};
