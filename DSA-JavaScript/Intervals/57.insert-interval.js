/*

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5

************************************************************Solution*********************************************************/

/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */

const insert = (intervals, newInterval) => {
  const [newIntervalStart, newIntervalEnd] = newInterval;

  const result = [];
  let index = 0;

  /* First, insert the intervals into the result array for which the start time is less than the start time of the new interval */
  while (index < intervals.length && intervals[index][0] < newIntervalStart) {
    result.push(intervals[index]);
    index++;
  }

  /* Then, push the new interval to the result array if the start time of the new interval is greater than 
  the end time of the last interval in the result array, else merge the new interval with the last interval 
  in the result array by updating the end time. The updated end time will be the max end time between new interval 
  and the last interval from the result array */
  let lastInterval = result[result.length - 1];
  if (result.length === 0 || newIntervalStart > lastInterval[1]) {
    result.push(newInterval);
  } else {
    lastInterval[1] = Math.max(lastInterval[1], newIntervalEnd);
  }

  /* At last, merge or push the rest of the intervals into the result array just like we did above 
  by comparing each interval's start time with the end time of the last interval */
  while (index < intervals.length) {
    lastInterval = result[result.length - 1];
    if (intervals[index][0] > lastInterval[1]) {
      result.push(intervals[index]);
    } else {
      lastInterval[1] = Math.max(lastInterval[1], intervals[index][1]);
    }
    index++;
  }

  return result;
};
