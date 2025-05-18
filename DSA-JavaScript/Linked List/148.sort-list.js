/*

Given the head of a linked list, return the list after sorting it in ascending order.


Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

*********************************************************Solution****************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

/*

Time complexity: 
O(nlogn)

Space complexity: 
O(logn) for recursion stack.

*/
const sortList = function (head) {
  if (!head || !head.next) {
    return head;
  }

  /* Applying merge sort recursively: Splitting the list into 2 parts where left is the head of the 1st part 
    and right is the head of the 2nd part, sorting them and finally merging them to get the sorted list */
  let left = head;
  let right = getMid(head);

  const temp = right.next;
  right.next = null;
  right = temp;

  left = sortList(left);
  right = sortList(right);
  return merge(left, right);
};

function getMid(head) {
  let slow = head,
    fast = head.next;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}

function merge(list1, list2) {
  const dummy = new ListNode();
  let tail = dummy;

  while (list1 && list2) {
    if (list1.val <= list2.val) {
      tail.next = list1;
      list1 = list1.next;
    } else {
      tail.next = list2;
      list2 = list2.next;
    }

    tail = tail.next;
  }

  if (list1) {
    tail.next = list1;
  }

  if (list2) {
    tail.next = list2;
  }

  return dummy.next;
}
