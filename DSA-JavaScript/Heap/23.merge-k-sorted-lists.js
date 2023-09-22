/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.


Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

**************************************************************Solution*******************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
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

  isEmpty() {
    return this.items.length === 0;
  }

  swap(index1, index2) {
    [this.items[index1], this.items[index2]] = [
      this.items[index2],
      this.items[index1],
    ];
  }

  //Time complexity: O(height of the binary heap) = O(log n) since we are swapping the elements along the height of the binary heap
  insert(item) {
    if (item === null) {
      return;
    }

    this.items.push(item);

    let i = this.items.length - 1;
    while (i !== 0 && this.items[i].val < this.items[this.parent(i)].val) {
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

    if (left < heapSize && this.items[left].val < this.items[smallest].val) {
      smallest = left;
    }

    if (right < heapSize && this.items[right].val < this.items[smallest].val) {
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

The idea is to create a min heap and insert the 1st item of all the arrays into the heap. Then, repeat the following steps while the heap is not empty:

- remove the min item(which will be at the root of the heap) from the heap.
- use the removed item to form the output list
- add the next item from the removed item's list into the heap.

lists array here contains the head of the given sorted lists

*/
const mergeKLists = function (lists) {
  const minHeap = new MinHeap();

  for (const list of lists) {
    minHeap.insert(list);
  }

  let output = null,
    last = null;
  while (!minHeap.isEmpty()) {
    const removedNode = minHeap.extractMin();

    if (output === null) {
      output = last = removedNode;
    } else {
      last.next = removedNode;
      last = last.next;
    }

    if (removedNode.next) {
      minHeap.insert(removedNode.next);
    }
  }

  return output;
};
