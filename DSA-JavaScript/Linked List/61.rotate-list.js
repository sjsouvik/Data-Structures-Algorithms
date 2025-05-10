/*

Given the head of a linked list, rotate the list to the right by k places.


Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9

***************************************************Solution***************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
const rotateRight = function (head, k) {
  if (!head) {
    return head;
  }

  let tail = head,
    length = 1;
  while (tail.next) {
    tail = tail.next;
    length++;
  }

  k = k % length;

  if (k === 0) {
    return head;
  }

  let current = head,
    n = length - k - 1;
  while (n-- > 0) {
    current = current.next;
  }

  const updatedHead = current.next;
  current.next = null;
  tail.next = head;

  return updatedHead;
};
