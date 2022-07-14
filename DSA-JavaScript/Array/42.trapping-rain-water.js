/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 
Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:

n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5

***********************************************************************Solution************************************************************/

/**
 * @param {number[]} height
 * @return {number}
 */

// to find max item for each on its right
const findRightMax = (height, n) => {
    const rightMax = [];
    
    rightMax[n - 1] = height[n - 1];
    for(let i = n - 2; i >= 0; i--){
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    
    return rightMax;
}

var trap = function(height) {
    const n = height.length;
    
    // we need at least 3 blocks to store some water
    if(n <= 2){
        return 0;
    }
    
    const rightMax = findRightMax(height, n);        
    
    let trappedWater = 0, leftMax = height[0];
    
    // as we can trap water only using mid blocks, calculating trapped water for each block starting from index 1 till (n - 2)
    for(let i = 1; i < n - 1; i++){
        leftMax = Math.max(leftMax, height[i]);
        
        trappedWater += Math.min(leftMax, rightMax[i]) - height[i];
    }
    
    return trappedWater;
};