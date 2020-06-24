/*
Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even positions node are together.
Assume the first element to be at position 1 followed by second element at position 2 and so on.

Input: 
The first line of each testcase consists of the number of test cases T. For each testcase, there will be two lines, first of which contains the length
of the linked list and next will contains the elements of the linked list.

Output: 
For each testcase, output the linked list after rearranging the nodes in it such that odd position nodes appear before even position nodes.

User Task:
The task is to complete the function rearrangeEvenOdd() which rearranges the nodes in the linked list as required.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 10000
1 <= value <= 1000

Example:
Input:
2
4
1 2 3 4
5
1 2 3 4 5

Output:
1 3 2 4
1 3 5 2 4

Explanation:
Testcase 1: After rearranging the linked list elements in odd-even fashion 1, 3 are odd and they are together. Also, 2 and 4 are even and they are together.

************************************************************************Solution**************************************************************************/

import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }    
}


class GFG
{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}

    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
	{
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            head = new gfg().rearrangeEvenOdd(head);
            printList(head); 
            t--;
        }
    } 
} 


class gfg
{  
    Node rearrangeEvenOdd(Node head)
    {          
          Node odd = head;
          Node even = head.next;
          
          Node evenHead = even; //to keep head of even node as it's needed to connect with end of odd list later
          
          while(true)
          {
              //to handle corner cases and if there's no more odd node after the current even node
              if(head == null || even == null || even.next == null)
              {
                  odd.next = evenHead;
                  break;
              }
              
              //connecting current odd node with next odd node
              odd.next = even.next;
              odd = odd.next;
              
              //if there's no more even node after the current odd node
              if(odd.next ==  null)
              {
                  even.next = odd.next;
                  odd.next = evenHead;
                  break;
              }
              
              //connecting current even node with next even node
              even.next = odd.next;
              even = even.next;
          }
        
        return head;  
     }
}









