/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0] 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

*****************************************************************Solution*************************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
const mergeTwoLists = function(list1, list2) {
    if(!list1){
        return list2;
    }
    
    if(!list2){
        return list1;
    }
    
    let head, tail;
    
    /* 1st, finalize the head node of the resultant list by comparing head of the both given lists. 
    Initially, head and tail of the resultant list would point to the same node. */
    if(list1.val <= list2.val){
        head = tail = list1;
        list1 = list1.next;            
    }else{
        head = tail = list2;
        list2 = list2.next;
    }
    
    /* then, use the tail node to append other nodes by comparing nodes from the both given lists. 
    This loop would work till both of the lists have nodes to compare. */
    while(list1 && list2){
        if(list1.val <= list2.val){            
            tail.next = list1; 
            tail = tail.next;
            list1 = list1.next;            
        }else{
            tail.next = list2; 
            tail = tail.next;
            list2 = list2.next;            
        }
    }
    
    // append the remaining nodes if there's any
    if(list1){
        tail.next = list1;
    }else{
        tail.next = list2;
    }
    
    return head;
};
