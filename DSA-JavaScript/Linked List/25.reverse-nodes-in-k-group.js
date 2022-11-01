/*

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.


Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000

****************************************************************Solution*********************************************************/

// Iterative solution

const reverseKGroup = function(head, k) {
    if(k === 1){
        return head;
    }
    
    let temp = head, numberOfNodes = 0;
    
    while(temp){
        temp = temp.next;
        numberOfNodes++;
    }
    
    let noOfgroupsToReverse = Math.floor(numberOfNodes / k), current = head, prev = null, next, isFirstPass = true, resultantHead, firstInTheGroup, lastInTheReversedGroup;    
    
    while(noOfgroupsToReverse-- > 0){
        temp = k, firstInTheGroup = current;
        
        while(temp-- > 0){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        if(isFirstPass){
            resultantHead = prev;
            isFirstPass = false;
        }else{
            lastInTheReversedGroup.next = prev;            
        }
        
        lastInTheReversedGroup = firstInTheGroup;        
    }
    
    lastInTheReversedGroup.next = current;
    
    return resultantHead;
};
