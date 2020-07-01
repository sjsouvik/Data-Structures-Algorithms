/*
Given a linked list of N positive integers. You need to swap elements pairwise. Your task is to complete the function pairwise_swap().

Input:
The input line contains T, denoting the number of testcases. Each testcase contains two lines, the first line contains N(size of linked list). The second 
line contains N elements of linked list separately.

Output:
For each testcase, in new line, print the modified linked list.

User Task:
Since this is a functional problem you don't have to worry about input and output, you just have to complete the function pairwise_swap(). The printing is 
done automatically by the driver code.

Constraint:
1 <= T <= 100
1 <= N <= 100
1 <= Node values <= 1000

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Example:
Input:
2
7
1 2 3 4 5 6 7
6
1 2 3 4 5 6
Output:
2 1 4 3 6 5 7
2 1 4 3 6 5

Explanation:
Testcase 1: The linked list after swapping becomes: 1 2 3 4 5 6 7 -> 2 1 4 3 6 5 7.
Testcase 2: The linked list after swapping becomes: 1 2 3 4 5 6 -> 2 1 4 3 6 5.

************************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

  
   class Node 
   { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 

public class LinkedList1
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            lastNode.next = node;
            lastNode = node;
        }
    }
    

    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }        
    }

    
    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t= Integer.parseInt(br.readLine());
            
        while(t>0)
        {
            int n = Integer.parseInt(br.readLine());
            Node head = null;
            
            String str = br.readLine();
            String nums[] = str.trim().split("\\s+");
            
            int a1= Integer.parseInt(nums[0]);
            head= new Node(a1);
            addToTheLast(head);
            
            for (int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(nums[i]);
                addToTheLast(new Node(a));
            }


            head = new Swap().pairwise_swap(head);
            
            printList(head);
            System.out.println();
            
            t--;
        }
        
    }
}


class Swap
{
    //this is a way to solve the problem where we change the pointers
    public static Node pairwise_swap(Node head)
    {
        if(head == null || head.next == null) //if there's no node or only single node then no need to do anything
            return head;
        
        Node prev = head, curr = head.next, next = null;
        
        head = curr; //this will be the new head of the updated list
        
        while(true)
        {
            next = curr.next;
            
            curr.next = prev;
            
            if(next == null || next.next == null)
            {
                prev.next = next;
                break;
            }
            
            prev.next = next.next;
            
            //updating prev and curr node
            prev = next;
            curr = prev.next;
        }
        
        return head;
    }
    
    
    //this is another way to solve the problem where data part of the nodes are being swapped but it's not recommended one since the node might contains object instead of integer
    public static Node pairwise_swap2(Node head)
    {
        if(head == null || head.next == null)
            return head;
        
        Node curr = head;
        
        while(curr != null && curr.next != null)
        {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
        
        return head;    
    }
    
}




