/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 
Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Example 3:

Input: head = [1], k = 1
Output: [1]

Example 4:

Input: head = [1,2], k = 1
Output: [2,1]

Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
 
Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 105
    0 <= Node.val <= 100

*****************************************************************************************Solution*****************************************************************************************/

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
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode temp = head, kthNode = null;
        int len = 0;
        
        while(temp != null)
        {
            len++;
            
            if(len == k)
                kthNode = temp;
            
            temp = temp.next;
        }
        
        int pos = len - k + 1;
        temp = head;
        while(pos-- > 1)        
            temp = temp.next;        
        
        //swapping the values of kth node from beginning and kth node from the end
        int val = kthNode.val;
        kthNode.val = temp.val;
        temp.val = val;
        
        return head;
    }
}
