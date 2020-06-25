/*
Given a linked list of N nodes. The task is to reverse this list.

Input:
The first line of input contains the number of test cases T. For each test case, the first line contains the length of the linked list and the next line 
contains the elements of the linked list.

Output:
For each test case, print the reversed linked list in a new line.

User Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10
Output:
6 5 4 3 2 1
10 9 8 7 2

Explanation:
Testcase 1: After reversing the list, elements are 6->5->4->3->2->1.
Testcase 2: After reversing the list, elements are 10->9->8->7->2.

**********************************************************************Solution******************************************************************************/

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
        
            ReverseLL g = new ReverseLL();
            head = g.reverseList(head);
            printList(head); 
            t--;
        }
    } 
} 


class ReverseLL
{    
    Node reverseList(Node head)
    {        
        Node prev = null, current = head, next = null;
        
        if(head.next == null) //if only 1 element is there in the list
            return head;
            
        while(current != null)
        {
            next = current.next; //this is to store the next element of current element as it's required to go to the next element of the list
            current.next = prev; //current.next is now pointing to previous element and because of this the address of next element of current element needs to be stored in a variable('next' variable) so that we can traverse the entire list 
            prev = current;
            current = next;
        }
        
        head = prev; //as prev holds the last element of the list which will become the head of the reversed list
        
        return head;
    }
}




