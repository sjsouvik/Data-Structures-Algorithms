/*

Given an array, rotate the array to the right by k steps, where k is non-negative.

 
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

**********************************************************************Solution*****************************************************/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 var rotate = function(nums, k) {        
    function reverse(start, end){
        let temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }            
      
    const numsLength = nums.length;    
    k = k % numsLength;
    
    reverse(0, numsLength - k - 1);
    reverse(numsLength - k, numsLength - 1);
    reverse(0, numsLength - 1);        
};