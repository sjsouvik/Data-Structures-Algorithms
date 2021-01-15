/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

******************************************************************************************Solution*****************************************************************************************/

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
    //The idea is to split the list into parts, reverse the 2nd half and then compare with 1st half 
    public boolean isPalindrome(ListNode head) 
    {
        ListNode temp = head, mid = head;
        
        while(temp != null && temp.next != null)
        {
            mid = mid.next;
            temp = temp.next.next;
        }
        
        ListNode headSecondHalf = null;
        
        //when number of nodes is even, mid node would be the head of 2nd half of the list
        if(temp == null) 
            headSecondHalf = mid;
        //when number of nodes is odd, next node of mid node would be the head of 2nd half of the list
        else 
            headSecondHalf = mid.next;
        
        headSecondHalf = reverse(headSecondHalf);
        
        return compare(head, mid, headSecondHalf);
    }
    
    //to reverse the 2nd half of the list
    ListNode reverse(ListNode head)
    {
        ListNode prev = null, current = head, next;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    //to compare the 1st half of the list is matching with 2nd half or not
    boolean compare(ListNode headFirstHalf, ListNode endFirstHalf, ListNode headSecondHalf)
    {
        while(headFirstHalf != endFirstHalf && headSecondHalf != null)
        {
            if(headFirstHalf.val != headSecondHalf.val)
                return false;
            
            headFirstHalf = headFirstHalf.next;
            headSecondHalf = headSecondHalf.next;
        }
        
        return true;
    }
}