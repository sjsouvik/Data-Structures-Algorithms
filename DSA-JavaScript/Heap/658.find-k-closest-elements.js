/*

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4

**************************************************************Solution*******************************************************/

/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */

class PriorityQ {
  constructor(compare) {
    this.compare = compare;
    this.items = [];
  }

  parent(i) {
    return Math.floor((i - 1) / 2);
  }

  left(i) {
    return 2 * i + 1;
  }

  right(i) {
    return 2 * i + 2;
  }

  swap(index1, index2) {
    [this.items[index1], this.items[index2]] = [
      this.items[index2],
      this.items[index1],
    ];
  }

  peek() {
    return this.items[0];
  }

  size() {
    return this.items.length;
  }

  add(item) {
    this.items.push(item);

    let i = this.items.length - 1;
    while (i !== 0 && this.compare(this.items[this.parent(i)], this.items[i])) {
      this.swap(i, this.parent(i));
      i = this.parent(i);
    }
  }

  heapify(index) {
    const left = this.left(index),
      right = this.right(index);
    let rootIndex = index;

    if (
      left < this.size() &&
      this.compare(this.items[rootIndex], this.items[left])
    ) {
      rootIndex = left;
    }

    if (
      right < this.size() &&
      this.compare(this.items[rootIndex], this.items[right])
    ) {
      rootIndex = right;
    }

    if (rootIndex !== index) {
      this.swap(rootIndex, index);
      this.heapify(rootIndex);
    }
  }

  poll() {
    if (this.size() === 0) {
      return;
    }

    if (this.size() === 1) {
      return this.items.pop();
    }

    this.swap(0, this.items.length - 1);
    this.items.pop();
    this.heapify(0);
  }
}

/* 

This problem is about finding 'K' smallest items based on the difference between the array item and the given number 'x'. 

We'll use max heap here and push the abs(item - x) of first 'k' items into the heap. And for the rest of the array items, 
we'll compare the top of the heap with the absolute difference for the current item, if the top of the heap has the 
greater value, then we'll remove that and add the current item into the heap. In this way, at the end, we'll have 
the 'k' closest items in the heap.

We used max heap here so that we can easily get access of the item with the largest difference for subarray of 
size 'k' and remove that.

We could solve this problem using min heap as well but in that case, we had to build the heap with the difference of 
all the items and then we could extract the first 'k' items with min difference. Time complexity(nlogn to build the 
heap + klogn to extract first 'k' items from the heap = O(nlogn)) would be more in this approach.

*/

// Time complexity: O(klogk + 2(n - k)logk + klogk) = O(nlogk)
const findClosestElements = function (arr, k, x) {
  const maxHeap = new PriorityQ((a, b) => a.difference - b.difference < 0);

  // O(klogk) to build the heap with 'k' items
  for (let i = 0; i < k; i++) {
    maxHeap.add({ difference: Math.abs(arr[i] - x), index: i });
  }

  // (n - k) * (2logk) = 2(n - k)logk to remove and add new item into the heap
  for (let i = k; i < arr.length; i++) {
    if (maxHeap.peek().difference > Math.abs(arr[i] - x)) {
      maxHeap.poll();
      maxHeap.add({ difference: Math.abs(arr[i] - x), index: i });
    }
  }

  // O(klogk) to extract the items from the heap or, sort the result in ascending order
  const result = [];
  for (const item of maxHeap.items) {
    result.push(arr[item.index]);
  }

  return result.sort((a, b) => a - b);
};
