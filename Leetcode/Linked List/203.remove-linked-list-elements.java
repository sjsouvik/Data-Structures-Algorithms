/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

******************************************************************************Solution**************************************************************************/

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
    public ListNode removeElements(ListNode head, int val) 
    {     
        //this is to remove nodes with the given value from the beginning of the list
        while(head != null && head.val == val)
            head = head.next;
        
        //head will be null if all nodes contain the same value that needs to be removed
        if(head == null)
            return head;
        
        ListNode prev = head, temp = head.next; 
                
        while(temp != null)
        {                       
            if(temp.val == val)
            {
                temp = temp.next;                                
                prev.next = temp;                                    
            }
            else
            {
                prev = temp;
                temp = temp.next;
            }                
        }
        
        return head;
    }
}