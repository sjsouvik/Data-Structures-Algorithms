/*

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 
Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 10^4].
1 <= Node.val <= 1000

******************************************************Solution************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */

// alternative solution - time complexity - O(n), space complexity - O(n)
const reorderList2 = (head) => {
  const nodes = [];

  let current = head;
  while (current) {
    nodes.push(current);
    current = current.next;
  }

  let i = 0,
    j = nodes.length - 1;

  while (i < j) {
    nodes[i].next = nodes[j];
    i++;

    if (i >= j) {
      break;
    }

    nodes[j].next = nodes[i];
    j--;
  }

  nodes[i].next = null;
};

function findMid(head) {
  let slow = head,
    fast = head;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}

function reverse(head) {
  let current = head,
    prev = null,
    next = null;
  while (current) {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
  }

  return prev;
}

// better solution - time complexity - O(n), space complexity - O(1)
const reorderList = function (head) {
  /* split the list into 2 parts - if the list has odd number of nodes, 
    then the 1st part will have more nodes(1 extra) */
  const mid = findMid(head);

  let second = mid.next; // head of the 2nd part of the list
  mid.next = null; // end of 1st list

  second = reverse(second); // reverse the 2nd part of the list

  // merge 2 lists
  let first = head,
    firstNext,
    secondNext;
  while (second) {
    firstNext = first.next;
    secondNext = second.next;

    first.next = second;
    second.next = firstNext;

    first = firstNext;
    second = secondNext;
  }
};
