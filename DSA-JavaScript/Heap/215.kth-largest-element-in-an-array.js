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

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

class MinHeap {
  constructor() {
    this.items = [];
  }

  parent(index) {
    return Math.floor((index - 1) / 2);
  }

  left(index) {
    return 2 * index + 1;
  }

  right(index) {
    return 2 * index + 2;
  }

  getMin() {
    return this.items[0];
  }

  swap(index1, index2) {
    [this.items[index1], this.items[index2]] = [
      this.items[index2],
      this.items[index1],
    ];
  }

  //Time complexity: O(height of the binary heap) = O(log n) since we are swapping the elements along the height of the binary heap
  insert(item) {
    this.items.push(item);

    let i = this.items.length - 1;
    while (i !== 0 && this.items[i] < this.items[this.parent(i)]) {
      this.swap(i, this.parent(i));
      i = this.parent(i);
    }
  }

  //Time complexity: O(log n) as we are swapping the elements along the height of the binary heap
  minHeapify(index) {
    const left = this.left(index);
    const right = this.right(index);
    const heapSize = this.items.length;
    let smallest = index;

    if (left < heapSize && this.items[left] < this.items[smallest]) {
      smallest = left;
    }

    if (right < heapSize && this.items[right] < this.items[smallest]) {
      smallest = right;
    }

    if (smallest !== index) {
      this.swap(index, smallest);
      this.minHeapify(smallest);
    }
  }

  extractMin() {
    if (this.items.length === 0) {
      return;
    }

    if (this.items.length === 1) {
      return this.items.pop();
    }

    this.swap(0, this.items.length - 1);
    const minItem = this.items.pop();
    this.minHeapify(0);

    return minItem;
  }
}

/*

The idea is to use min heap to store the 1st 'k' items in the array. Then, traverse the rest of the array 
and add the item into the heap only if the item is greater than the root or, min item of the heap after 
removing the min item from the heap. In this way, the heap will only contain the 'k' largest items at the 
end where the root of the heap will be the kth largest item.

Time complexity: O(logk) to build the heap and O((n - k) * (2logk)) operations to extract root or min 
item from the heap and insert new item into the heap.

Another approach: we could solve this using max heap also by adding all items into the max heap and then 
removing 'k' items from the heap to get the kth largest item in the array. 

Time complexity would be O(logn) to build the heap and O(k * logn) operations to extract the 'k' items from the heap.

O(logn + klogn) > O(logk + 2(n - k)logk)

if k === n, O(logn + nlogn) > O(logn)

*/

const findKthLargest = function (nums, k) {
  const minHeap = new MinHeap();

  for (let i = 0; i < k; i++) {
    minHeap.insert(nums[i]);
  }

  for (let i = k; i < nums.length; i++) {
    if (nums[i] > minHeap.getMin()) {
      minHeap.extractMin();
      minHeap.insert(nums[i]);
    }
  }

  return minHeap.getMin();
};
