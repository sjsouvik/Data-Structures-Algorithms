/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

*******************************************************************************************Solution************************************************************************************************/

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
        ListNode temp = l1, prev = null;
        int sum = 0, carry = 0;
        
        while(temp != null || l2 != null)
        {
            sum = (temp != null ? temp.val : 0) + (l2 != null ? l2.val : 0) + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            //if there's no more elements in list 1 and we are using list 1 to store the result, then we have to add new nodes to get the result
            if(temp == null)
            {
                prev.next = new ListNode(sum);
                prev = prev.next;
            }                
            else
                temp.val = sum;                        
            
            if(temp != null) 
            {
                prev = temp;
                temp = temp.next;
            }                
                                        
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry > 0)
            prev.next = new ListNode(carry);
        
        return l1;
    }
}
