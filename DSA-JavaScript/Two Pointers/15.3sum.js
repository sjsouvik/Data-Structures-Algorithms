/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

***************************************************************Solution**********************************************************/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */

// 2 pointers approach

var threeSum = function(nums) {
    const target = 0, result = [];        
    
    nums = nums.sort((a, b) => a - b);        
    
    for(let i = 0; i < nums.length - 2; i++){
        if(i === 0 || (i > 0 && nums[i] !== nums[i - 1])){            
            let startIndex = i + 1, endIndex = nums.length - 1, restOfTheTarget = target - nums[i], sum;

            while(startIndex < endIndex){
                sum = nums[startIndex] + nums[endIndex];
                
                if(sum === restOfTheTarget){
                    result.push([nums[i], nums[startIndex], nums[endIndex]]);

                    // to avoid duplicates
                    while(nums[startIndex] === nums[startIndex + 1]){
                        startIndex++;
                    } 
                    
                    // to avoid duplicates
                    while(nums[endIndex] === nums[endIndex - 1]){
                        endIndex--;
                    }

                    startIndex++; 
                    endIndex--; 
                }else if(sum < restOfTheTarget){
                    startIndex++;
                }else{
                    endIndex--;
                }
            }
        }        
    }
        
    return result;
};