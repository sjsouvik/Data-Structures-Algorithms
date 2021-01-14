/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

*****************************************************************************Solution**********************************************************************************/

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
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(m == n)
            return head;
        
        ListNode temp = head;
        
        int start = m;
        
        while(--start > 1 && temp != null)
            temp = temp.next;
        
        ListNode prev = null, current, next;
        
        if(m == 1)
            current = temp;
        else
            current = temp.next;
        
        //reversing the list from nodes m to n
        for(int i = m; i <= n; i++)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
                
        //connecting reversed part with the rest of the list
        if(m == 1)
        {
            head = prev;
            temp.next = current;
        }
        else
        {
            temp.next.next = current;
            temp.next = prev;
        }        
        
        return head;
    }
}