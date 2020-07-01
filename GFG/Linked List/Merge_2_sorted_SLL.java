/*
Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.
Note: It is strongly recommended to do merging in-place using O(1) extra space.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains N and M, and next two line contains N and M sorted 
elements in two lines for each.

Output:
For each testcase, print the merged list in sorted form.

User Task:
The task is to complete the function sortedMerge() which takes references to the heads of two linked lists as the arguments and returns the head of merged 
linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 100
1 <= N, M <= 104
1 <= Node's data <= 105

Example:
Input:
2
4 3
5 10 15 40 
2 3 20
2 2
1 1
2 4 
Output:
2 3 5 10 15 20 40
1 1 2 4

Explanation:
Testcase 1: After merging the two linked lists, we have merged list as 2, 3, 5, 10, 15, 20, 40.
Testcase 2: After merging the given two linked list , we have 1, 1, 2, 4 as output.

************************************************************************Solution***************************************************************************/

import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;
  
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	       
    public static void main(String args[])
    {                        
         Scanner sc = new Scanner(System.in);
	 int t=sc.nextInt();
		 
	 while(t>0)
         {
	    int n1 = sc.nextInt();
	    int n2 = sc.nextInt();

	    Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }

	    Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
	    LinkedList obj = new LinkedList();
	    Node head = obj.sortedMerge(head1,head2);
	    printList(head);
			
	    t--;			
         }
    }
}


class LinkedList
{
    Node sortedMerge(Node headA, Node headB) 
    {     
     if(headA == null || headB == null)
        return headA == null ? headB : headA;
     
     Node temp1 = headA, temp2 = headB, head = null, tail = null;
     
     while(temp1 != null && temp2 != null)
     {
         if(temp1.data <= temp2.data)
         {
             if(head == null)
                head = tail = temp1;
             else
             {
                 tail.next = temp1;
                 tail = tail.next;
             }
             
             temp1 = temp1.next;
         }
         else
         {
             if(head == null)
                head = tail = temp2;
             else
             {
                tail.next = temp2;
                tail = tail.next;
             }
             
             temp2 = temp2.next;   
         }
     }
     
     if(temp1 != null)
        tail.next = temp1;
     else
        tail.next = temp2;
     
     return head;
   } 
}



