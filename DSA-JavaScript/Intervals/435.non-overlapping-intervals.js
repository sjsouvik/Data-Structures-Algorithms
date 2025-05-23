/*

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of 
intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are 
non-overlapping.
 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4

********************************************************Solution***************************************************/
/*

The idea is to sort the intervals based on the start time in ascending order and 
start iterating the intervals to compare with the previous intervals's end time 
to find out if there's any overlap.

If there's no overlap, we update the previous interval's end time with the current 
interval's end time. If the current interval overlaps with the previous interval, 
then the interval with the larger end time needs to be deleted.


Time complexity: O(nlogn)
Space complexity: O(1) or O(n) depending on the sorting algorithm.

*/
function eraseOverlapIntervals(intervals) {
  intervals.sort((a, b) => a[0] - b[0]);

  let lastIntervalEndTime = intervals[0][1],
    result = 0;

  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i][0] >= lastIntervalEndTime) {
      lastIntervalEndTime = intervals[i][1];
    } else {
      lastIntervalEndTime = Math.min(lastIntervalEndTime, intervals[i][1]);
      result++;
    }
  }

  return result;
}
