/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

***********************************************************************************************Solution**********************************************************************************************/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {               
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode head = null, newNode = null;
        int sum = 0, carry = 0;
        
        while(l1 != null || l2 != null)
        {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            newNode = new ListNode(sum);
            
            //creating a new list where each digit will be appended at the beginning so that we don't need to reverse the list which contains the result
            if(head == null)
                head = newNode;
            else
            {
                newNode.next = head;
                head = newNode;
            }
            
            if(l1 != null)
                l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;            
        }
        
        if(carry > 0)
        {
            newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        
        return head;
    }
    
    ListNode reverse(ListNode head)
    {
        ListNode current = head, next = null, prev = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}