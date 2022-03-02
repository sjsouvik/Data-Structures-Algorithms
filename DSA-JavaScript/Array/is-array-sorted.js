/*

Given an array a[ ] of size N. The task is to check if array is sorted or not. A sorted array can either be increasingly 
sorted or decreasingly sorted. Also consider duplicate elements to be sorted.

Example 1:

Input:
N = 5
a[] = {1 1 2 2 3}
Output: 1
Example 2:

Input:
N = 2
a[] = {4 2}
Output: 1
Your Task:
You just need to complete the function isSorted() that takes arr and n as parameters and returns 0 if arr is unsorted and 
returns 1 if arr is sorted.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
1 <= a[i] <= 106

******************************************************************Solution******************************************************/

function isSorted(arr, n) {
  if (n === 1) {
    return 1;
  }

  let incFlag = false,
    decFlag = false,
    index;

  for (let i = 0; i < n - 1; i++) {
    if (arr[i] <= arr[i + 1]) {
      incFlag = true;
    } else {
      incFlag = false;
      index = i;
      break;
    }
  }

  if (index === 0) {
    for (let i = 0; i < n - 1; i++) {
      if (arr[i] >= arr[i + 1]) {
        decFlag = true;
      } else {
        decFlag = false;
        break;
      }
    }
  }

  return incFlag || decFlag ? 1 : 0;
}
