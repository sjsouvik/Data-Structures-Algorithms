/*

Given the head of a linked list, remove the nth node from the end of the list and return its head.


Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
****************************************************Solution**************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
const removeNthFromEnd = function (head, n) {
  let current = head,
    length = 0;
  while (current) {
    current = current.next;
    length++;
  }

  let position = length - n;

  if (position === 0) {
    return head.next;
  }

  /* current will point to the previous node of the node that needs 
    to be deleted after the next iteration */
  current = head;
  while (position-- > 1) {
    current = current.next;
  }

  current.next = current.next.next;
  return head;
};
