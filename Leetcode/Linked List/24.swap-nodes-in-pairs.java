/*
Given a linked list, swap every two adjacent nodes and return its head.
 
Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [1]
Output: [1]
 
Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100

 
Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)

*****************************************************************************************Solution**********************************************************************************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null)
            return head;
        
        ListNode temp = head;
        while(temp != null && temp.next != null)
        {
            int val = temp.val;
            temp.val = temp.next.val;
            temp.next.val = val;
            
            temp = temp.next.next;
        }
        
        return head;
    }
}
