/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Input:
First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list 
elements.

Output:
For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.

User Task:
The task is to complete the function reverse() which should reverse the linked list in group of size k.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Example:
Input:
2
8
1 2 2 4 5 6 7 8
4
5
1 2 3 4 5
3

Output:
4 2 2 1 8 7 6 5
3 2 1 5 4

Explanation:
Testcase 1: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.

*********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;

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

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            GfG gfg = new GfG();
            Node res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


class GfG
{
    public static Node reverse(Node head, int k)
    {
        //base case
        if(head == null)
            return null;
        
        Node prev = null, current = head, next = null;
        int count = 0;
        
        while(current != null && count++ < k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        /*
        head of the current sublist contains the first element of the original sublist 
        or, in other words, head contains the last element of the reversed sublist
        so, head of the current reversed sublist will be connected with the returned node 
        of the next reversed sublist 
        */
        head.next = reverse(next, k); 
        
        return prev; //as prev holds the last element of the sublist(size=k) which will become the head of the reversed list
    }
}






