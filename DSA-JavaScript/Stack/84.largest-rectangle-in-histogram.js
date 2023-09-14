/*

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 
Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:

Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

***************************************************************Solution******************************************************/

/**
 * @param {number[]} heights
 * @return {number}
 */

/* The idea is to keep index of smaller item on the left and right for each item, so that we can get the largest possible width for each given height. Now the trick is, if there's no smaller element on the left and right of an item, then keep -1 and the length of the array as the index of smaller element for that item respectively. */
const getPrevSmaller = (arr) => {
  const stack = [],
    result = [];

  for (let i = 0; i < arr.length; i++) {
    while (stack.length && arr[stack[stack.length - 1]] >= arr[i]) {
      stack.pop();
    }

    result[i] = stack.length === 0 ? -1 : stack[stack.length - 1];
    stack.push(i);
  }

  return result;
};

const getNextSmaller = (arr) => {
  const stack = [],
    result = [];

  for (let i = arr.length - 1; i >= 0; i--) {
    while (stack.length && arr[stack[stack.length - 1]] >= arr[i]) {
      stack.pop();
    }

    result[i] = stack.length === 0 ? arr.length : stack[stack.length - 1];
    stack.push(i);
  }

  return result;
};

const largestRectangleArea = function (heights) {
  const prevSmallers = getPrevSmaller(heights);
  const nextSmallers = getNextSmaller(heights);

  let maxArea = heights[0];
  for (let i = 0; i < heights.length; i++) {
    maxArea = Math.max(
      maxArea,
      heights[i] * (nextSmallers[i] - prevSmallers[i] - 1)
    );
  }

  return maxArea;
};
