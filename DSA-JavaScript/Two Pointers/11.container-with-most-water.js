/*

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4

*************************************************************Solution********************************************************/

/**
 * @param {number[]} heights
 * @return {number}
 */

/*
The idea is to use 2 pointers to point the 1st and last height in the array. The height of any container with heights 
at index 'i', 'j' will be the min. of the heights at index 'i', 'j' and width will be difference between 'i' and 'j'.

Next, whether to increment 'i' or decrement 'j', we can decide that based on the heights at index 'i', 'j'. If the 
height at the index 'i' is less than the height at index 'j', then we'll increment 'i' because even if we decrement 'j' 
and we get even a greater height at index (j - 1), then also the height of the container will be the height at index 'i' 
since that was the minimum height between the heights at 'i' and 'j'.
*/

const maxArea = function (heights) {
  let i = 0,
    j = heights.length - 1,
    maxAmount = 0;

  while (i < j) {
    const height = Math.min(heights[i], heights[j]);
    const width = j - i;
    maxAmount = Math.max(maxAmount, height * width);

    heights[i] < heights[j] ? i++ : j--;
  }

  return maxAmount;
};
