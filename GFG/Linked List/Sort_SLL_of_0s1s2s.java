/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros 
segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the linked list and next 
line contains N elements as the data in the linked list.

Output:
For each test case, segregate the 0s, 1s, and 2s and display the linked list.

Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of 
the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
8
1 2 2 1 2 0 2 2
4
2 2 0 1
Output:
0 1 1 2 2 2 2 2
0 1 2 2

Explanation:
Testcase 1: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
Testcase 2: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.

************************************************************************Solution****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}


class LinkedList
{
    //this is one way to solve the problem using single traversal, also we can count number of 0s, 1s, 2s and then put then back in correct order 
    static Node segregate(Node head)
    {
        //dummy nodes to point to the beginning of 3 lists
        Node first = new Node(0);
        Node second = new Node(0);
        Node third = new Node(0);
        
        Node zero = first, one = second, two = third, current = head;
        
        while(current != null)
        {
            if(current.data == 0)
            {
                zero.next = current;
                zero = zero.next;
            }
            else if(current.data == 1)
            {
                one.next = current;
                one = one.next;
            }
            else
            {
                two.next = current;
                two = two.next;
            }
            
            current = current.next;
        }
        
        //checking next node of second as it may contain null and then the 3 lists would not be connected
        zero.next = (second.next != null) ? second.next : third.next;
        one.next = third.next;
        two.next = null;
        
        return first.next;
    }
}








