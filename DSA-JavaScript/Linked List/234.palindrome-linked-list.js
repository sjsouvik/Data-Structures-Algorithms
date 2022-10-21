/*

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.


Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9

**************************************************************Solution**************************************************************/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */

/* the idea is to split the list into 2 parts, reverse the 2nd part of the list and then compare reversed 2nd part of the 
list with the 1st part to chcek whether the list is palindrome or not */

const isPalindrome = function(head) {
    const middleNodeOfTheList = findMiddleNode(head);
    
    const headOfThe2ndPartOfTheList = middleNodeOfTheList.next;    
    const headOfTheReversed2ndPartOfTheList = reverseList(headOfThe2ndPartOfTheList);
    
    return compare2PartsOfTheList(head, headOfTheReversed2ndPartOfTheList);
};

const findMiddleNode = (head) => {
    let fastPointer = head, slowPointer = head;
    
    while(fastPointer.next && fastPointer.next.next){
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }
    
    return slowPointer;
}

const reverseList = (head) => {
    let currentNode = head, nextNode, previousNode = null;
    
    while(currentNode){
        nextNode = currentNode.next;
    
        currentNode.next = previousNode;        
        previousNode = currentNode;    
        currentNode = nextNode;
    }    
    
    return previousNode;
}

const compare2PartsOfTheList = (headOf1stPart, headOf2ndPart) => {
    // 2nd part of the list would have null to mark the end of the list
    while(headOf2ndPart){
        if(headOf1stPart.val !== headOf2ndPart.val){
            return false
        }
        
        headOf1stPart = headOf1stPart.next;
        headOf2ndPart = headOf2ndPart.next;
    }   
    
    return true;
}
