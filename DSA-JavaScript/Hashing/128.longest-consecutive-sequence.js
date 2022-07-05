/*

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

**********************************************************************Solution*****************************************************************/

/**
 * @param {number[]} nums
 * @return {number}
 */

/* the idea is to add all items in a set to have all unique items and make search of consecutive items faster, 
then traverse each item and look for the (item - 1) value in the set. If (item - 1) is not present 
i.e. current item is the starting point of the consecutive subsequence, so continue looking for item + 1, item + 2,... 
and increment the length of LCS. At the end store the max length and return as the result. */

var longestConsecutive = function(nums) {
    if(!nums.length){
        return 0;
    }
    
    const set = new Set(nums);
    let res = 1;
    
    for(const num of set){
        if(!set.has(num - 1)){
            let length = 1;
            
            while(set.has(num + length)){
                length++;                
            }
            
            res = Math.max(res, length);
        }
    }
    
    return res;
};