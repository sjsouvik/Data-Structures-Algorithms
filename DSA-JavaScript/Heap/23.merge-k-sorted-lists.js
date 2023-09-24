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

The idea is to create a min heap and insert the 1st item of all the arrays into the heap. Then, repeat the following steps while the heap is not empty:

- remove the min item(which will be at the root of the heap) from the heap.
- use the removed item to form the output list
- add the next item from the removed item's list into the heap.

lists array here contains the head of the given sorted lists

*/

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
const mergeKLists = function (lists) {
  const minHeap = new PriorityQ((a, b) => a.val - b.val > 0);

  for (const list of lists) {
    if (list !== null) {
      minHeap.add(list);
    }
  }

  let output = null,
    last = null;
  while (minHeap.size() !== 0) {
    const removedNode = minHeap.poll();

    if (output === null) {
      output = last = removedNode;
    } else {
      last.next = removedNode;
      last = last.next;
    }

    if (removedNode.next) {
      minHeap.add(removedNode.next);
    }
  }

  return output;
};
