/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 
Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 
Constraints:

    The number of nodes in the tree is in the range [0, 200].
    -100 <= Node.val <= 100
    -200 <= x <= 200

*****************************************************************************************Solution*********************************************************************************************/

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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode head1 = null, tail1 = null, head2 = null, tail2 = null;
        
        while(head != null)
        {
            if(head.val < x)
            {
                if(head1 == null)
                    head1 = tail1 = head;
                else
                {
                    tail1.next = head;
                    tail1 = tail1.next;
                }                
            }
            else
            {
                if(head2 == null)
                    head2 = tail2 = head;
                else
                {
                    tail2.next = head;
                    tail2 = tail2.next;
                }  
            }
            
            head = head.next;
        }
        
        //to connect list having values less than 'x' with list containing values greater than or equal to 'x'
        if(tail1 != null)
            tail1.next = head2;
        
        //to terminate the newly created list, else it'll not find null while traversing and go into infinite loop 
        if(tail2 != null)
            tail2.next = null;
                        
        return head1 != null ? head1 : head2;
    }
}