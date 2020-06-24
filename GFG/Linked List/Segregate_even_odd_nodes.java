/*
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified 
linked list. Also, keep the order of even and odd numbers same.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of elements in Linked List.
The second line of each test case contains N input,elements in Linked List.

Output:

Print the all even numbers then odd numbers in the modified Linked List.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ size of elements ≤ 1000

Example:

Input
3
7
17 15 8 9 2 4 6
4
1 3 5 7
7
8 12 10 5 4 1 6

Output
8 2 4 6 17 15 9
1 3 5 7
8 12 10 4 6 5 1

************************************************************************Solution***************************************************************************/

import java.util.Scanner;

class Node
{
    int data;
    Node next;
    
    Node(int a)
    {
        data = a;
        next = null;
    }
}


class GFG
 {
	public static void main (String[] args)
	{
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     Node head = new Node(sc.nextInt());
    	     Node tail = head;
    	     
    	     for(int i=2; i <= n; i++)
    	     {
    	         tail.next = new Node(sc.nextInt());
    	         tail = tail.next;
    	     }
    	     
    	     head = new segregateNodes().segregate(head);
    	     printList(head);
    	 }
	 }
	 
	 static void printList(Node head)
	 {
	     while(head != null)
	     {
	        System.out.print(head.data + " ");
	        head = head.next;
	     }
	     
	     System.out.println();
	 }
}


class segregateNodes
{
    Node segregate(Node head)
    {
        Node temp = head;
        
        Node even = null; //list for even elemnents
        Node odd = null; //list for odd elemnents
        
        Node oddHead = null;
        
        while(temp != null)
        {
            if(temp.data % 2 == 0)
            {
                if(even == null)
                {
                    even = temp;
                    head = even;
                }
                else
                {
                    even.next = temp;
                    even = even.next;
                }
            }
            else
            {
                if(odd == null)
                {
                    odd = temp;
                    oddHead = odd;
                }
                else
                {
                    odd.next = temp;
                    odd = odd.next;
                }
            }
            
            temp = temp.next;
        }
        
        if(even != null)
            even.next = oddHead; //connecting even with odd list
        
        odd.next = null; //null to terminate the list otherwise, it'll go in infinite loop
        
        return head;
    }
}










