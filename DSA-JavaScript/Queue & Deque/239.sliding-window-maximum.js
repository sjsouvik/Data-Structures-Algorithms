/*

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 10^5
-104 <= nums[i] <= 10^4
1 <= k <= nums.length

****************************************************************Solution*****************************************************/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */

/*
we need to use deque here since in deque removing item from last and first can be done in O(1) operation 
and these 2 operations are required to solve the problem efficiently

if the array size is 'n', window size is 'k' then there'll be total (n - k + 1) windows 

The idea is to keep a deque of size 'k' where we'll keep all the elements in descending order, to do that whenever 
the current element will be greater than the last item of the deque, we'll remove that item until we get a greater 
item than the current one. After that, we'll add the current item into the deque. With this approach, the front 
of the deque will always hold the max element of the current window.
*/
const maxSlidingWindow = function (nums, k) {
  const dq = [],
    n = nums.length;
  const result = [];

  for (let i = 0; i < k; i++) {
    /* will remove all the smaller or equal items than the current item from the deque as those won't be useful to get the max item in the current or subsequent windows */
    while (dq.length !== 0 && nums[i] >= nums[dq[dq.length - 1]]) {
      dq.pop();
    }

    dq.push(i);
  }

  for (let i = k; i < n; i++) {
    // store the max item of the previous window
    result.push(nums[dq[0]]);

    // this is to remove the indexes of the item from the deque that are not part of the current window
    while (dq.length !== 0 && dq[0] <= i - k) {
      dq.shift();
    }

    while (dq.length !== 0 && nums[i] >= nums[dq[dq.length - 1]]) {
      dq.pop();
    }

    dq.push(i);
  }

  result.push(nums[dq[0]]);
  return result;
};
