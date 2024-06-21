/*

Given an integer array nums, return true if you can partition the array into two subsets such that 
the sum of the elements in both subsets is equal or false otherwise.


Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

***********************************************Solution***************************************************/

/* if total sum of the given array items is odd, then it can't be partitioned into 2 subsets with equal sum. 
If the total sum is even, then we just need to find if there's any subset with (totalSum / 2)  */

function canPartition(nums) {
    const totalSum = nums.reduce((sum, item) => item + sum)

    if (totalSum % 2 !== 0) {
        return false
    }

    const target = totalSum / 2;

    const cache = {}
    function util(n = nums.length, sum = target) {
        if (n === 0) {
            return sum === 0
        }

        const key = `${n}_${sum}`
        if (cache[key] !== undefined) {
            return cache[key]
        }

        const result = util(n - 1, sum - nums[n - 1]) || util(n - 1, sum)
        cache[key] = result
        return result
    }

    return util()
};