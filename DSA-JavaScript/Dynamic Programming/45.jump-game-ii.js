/*

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].


Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

*************************************************Solution*************************************************/

function jump(nums) {
    const cache = []

    function minJumps(n = nums.length) {
        if (n === 1) {
            return 0
        }

        if (cache[n] !== undefined) {
            return cache[n]
        }

        let result = Number.POSITIVE_INFINITY
        /* checking if it's possible to reach to the last index from all the previous indexes, 
        if possible, then find the minimum number of jumps required to reach the those indexes 
        from its previous indexes recursively. 
        Minimum jumps to reach any index 'i' = (minimum jumps required to reach index 'i' from any of its previous index + 1), 
        1 needs to be added to reach to the index 'i' from its previous index */
        for (let i = 0; i < n - 1; i++) {
            if (i + nums[i] >= n - 1) {
                const jumps = minJumps(i + 1)
                result = Math.min(result, jumps + 1)
            }
        }

        cache[n] = result
        return result
    }

    return minJumps()
};