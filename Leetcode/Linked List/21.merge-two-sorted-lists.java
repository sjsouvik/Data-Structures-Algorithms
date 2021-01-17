/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 
Example 1:

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: l1 = [], l2 = []
Output: []

Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
 
Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both l1 and l2 are sorted in non-decreasing order.

******************************************************************************************Solution******************************************************************************************/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        
        ListNode temp1 = l1, temp2 = l2, head = null, tail = null;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                if(head == null)
                    head = tail = temp1;
                else
                {
                    tail.next = temp1;
                    tail = tail.next;
                }
                temp1 = temp1.next;
            }
            else
            {
                if(head == null)
                    head = tail = temp2;
                else
                {
                    tail.next = temp2;
                    tail = tail.next;
                }
                temp2 = temp2.next;
            }
        }
        
        if(temp1 != null)
            tail.next = temp1;
        else
            tail.next = temp2;
        
        return head;
    }
}