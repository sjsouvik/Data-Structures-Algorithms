/*
Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of which contains length of linked list and 
next line contains elements of the nodes of linked list.

Output:
Reorder it as explained above.

User Task:
The task is to complete the function reorderList() which should reorder the list as required.

Note: Try to solve without using any auxilliary space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 200
1 <= N <= 104

Example:
Input:

2
3
1 2 3
4
1 7 3 4

Output:
1 3 2
1 4 7 3

Explanation:
Testcase 2: After rearranging the given list as required, we have list as 1 -> 4 -> 7 -> 3.

**********************************************************************Solution****************************************************************************/

import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; 
    Node last; 
   
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {            
            last.next = node;
            last = last.next;
        }
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    public static void main(String args[]) 
    {        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) 
	{
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);

            llist.addToTheLast(head);

            for (int i = 1; i < n; i++) 
	    {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new gfg().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}


class gfg 
{
    //Merging 1st and 2nd half at alternate positions
    Node shuffleMerge(Node a, Node b)
    {
        if(a == null)
            return b;
        if(b == null)
            return a;
        
        Node head = a, anext = null, bnext = null;
        
        while(a != null && b != null)
        {
            anext = a.next;
            bnext = b.next;
            
            a.next = b;
            b.next = anext;
            
            a = anext;
            b = bnext;
        }
        
        return head;
    }
    
    //this is to reverse the 2nd part of the list
    Node reverse(Node head)
    {
        Node current = head, prev = null, next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        
        return head;
    }
    
    //this is to divide the list into 2 parts
    Node findMiddle(Node head)
    {
        Node slow = head, fast = head, prev = null;
        
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //if total odd no of nodes are present, then need to fix the 1st node of 2nd half
        if(fast != null && fast.next == null)
        {
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        
        return slow;
    }
    
    Node reorderlist(Node head) 
    {
        //dividing the list into 2 parts
        Node mid = findMiddle(head);
        
        //reversing the 2nd half of the list
        Node reverseHead = reverse(mid);
        
        //Merging the 1st half with the reversed 2nd half at alternate positions
        return (shuffleMerge(head, reverseHead));
    }
}



