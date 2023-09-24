/*

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

*************************************************************Solution********************************************************/

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
    const rootItem = this.items.pop();
    this.heapify(0);
    return rootItem;
  }
}

/*

The idea is to use min heap to store the 1st 'k' items in the array. Then, traverse the rest of the array 
and add the item into the heap only if the item is greater than the root or, min item of the heap after 
removing the min item from the heap. In this way, the heap will only contain the 'k' largest items at the 
end where the root of the heap will be the kth largest item.

Time complexity: O(klogk) to build the heap and O((n - k) * (2logk)) operations to extract root or min 
item from the heap and insert new item into the heap ~= O(nlogk).

Another approach: we could solve this using max heap also by adding all items into the max heap and then 
removing 'k' items from the heap to get the kth largest item in the array. 

Time complexity would be O(nlogn) to build the heap and O(k * logn) operations to extract the 'k' items 
from the heap ~= O(nlogn).

O(nlogn + klogn) > O(klogk + 2(n - k)logk)

if k === n, O(logn + nlogn) > O(logn)

*/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

// Time complexity: O(klogk + 2(n - k)logk) = O(nlogk)
const findKthLargest = function (nums, k) {
  const minHeap = new PriorityQ((a, b) => a - b > 0);

  for (let i = 0; i < k; i++) {
    minHeap.add(nums[i]);
  }

  for (let i = k; i < nums.length; i++) {
    if (nums[i] > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(nums[i]);
    }
  }

  return minHeap.peek();
};
