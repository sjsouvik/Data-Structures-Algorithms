/*

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],
[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings 
without any conflicts.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2

Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1

Note:

(0,8),(8,10) is not considered a conflict at 8
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000

*********************************************************Solution**************************************************/

/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
  /**
   * @param {Interval[]} intervals
   * @returns {number}
   */

  /*
  
  The idea is to take all start times and end times into separate arrays, sort them in ascending order. 
  Next, have 2 pointers(startedMeeting, endedMeeting) pointing to the starting index 
  of the start times and end times array respectively. We'll iterate through the start 
  times and end times, select the minimum of the current start time and end time - 
  
  if we select a start time that means a meeting will start, ongoing meeting count will 
  be incremented in that case and we'll move to the next start time.

  If we select an end time after comparing the current start time and end time that 
  means a meeting will end, ongoing meeting count will be decreased in that case 
  and we'll move to the next end time.
  
  If both the current start and end time are equal, then we'll select end time because 
  before starting a new meeting at the same time, we would end a meeting to keep the 
  ongoing meeting count minimum. The max number of ongoing meeting would be the answer 
  of this problem.

  Time complexity: O(nlogn)
  Space complexity: O(n)


  */

  minMeetingRooms(intervals) {
    const startTimes = intervals
      .map((interval) => interval.start)
      .sort((a, b) => a - b);
    const endTimes = intervals
      .map((interval) => interval.end)
      .sort((a, b) => a - b);

    let result = 0,
      ongoingMeeting = 0,
      startedMeeting = 0,
      endedMeeting = 0;

    while (startedMeeting < intervals.length) {
      if (startTimes[startedMeeting] < endTimes[endedMeeting]) {
        startedMeeting++;
        ongoingMeeting++;
      } else {
        endedMeeting++;
        ongoingMeeting--;
      }

      result = Math.max(result, ongoingMeeting);
    }

    return result;
  }
}
