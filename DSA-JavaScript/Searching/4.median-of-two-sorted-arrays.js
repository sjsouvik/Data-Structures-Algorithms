/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*****************************************************Solution******************************************************/

// time complexity - O(m + n)
function findMedianSortedArrays(nums1, nums2) {
  const m = nums1.length,
    n = nums2.length,
    allNums = [];
  let i = 0,
    j = 0;

  while (i < m && j < n) {
    if (nums1[i] < nums2[j]) {
      allNums.push(nums1[i++]);
    } else {
      allNums.push(nums2[j++]);
    }
  }

  if (i === m) {
    allNums.push(...nums2.slice(j));
  } else {
    allNums.push(...nums1.slice(i));
  }

  const midIndex = Math.floor(allNums.length / 2);
  if (allNums.length % 2 === 0) {
    return (allNums[midIndex] + allNums[midIndex - 1]) / 2;
  }

  return allNums[midIndex];
}
