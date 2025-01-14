/*

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4


*****************************************************************Solution*********************************************************/

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */

/* 2 intervals overlap when max of 2 intervals' start time is smaller than or equal to the end time of the other one. 

Now, if we sort the array of intervals by the start time of each interval in increasing order, then we know the 
interval that comes later has greater start time and we need to check whether the start time of that interval 
is smaller than or equal to the end time of the previous interval or not - If the answer yes, start time of the 
merged interval would be the smaller of the 2 intervals' start time and end time would be the greater of the 2 intervals' end time. */

const merge = function (intervals) {
  intervals = intervals.sort((a, b) => a[0] - b[0]);

  let resultIndex = 0;
  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] <= intervals[resultIndex][1]) {
      intervals[resultIndex][1] = Math.max(
        intervals[i][1],
        intervals[resultIndex][1]
      );
    } else {
      resultIndex++;
      intervals[resultIndex] = intervals[i];
    }
  }

  return intervals.slice(0, resultIndex + 1);
};
