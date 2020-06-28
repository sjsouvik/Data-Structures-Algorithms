/*
Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains a loop or not and 
if the loop is present then return the count of nodes in a loop or else return 0.

Input:
The first line of input contains the number of testcases T. For each test case, the first line of input contains the length of a linked list and next line 
contains data of the linked list, and the third line contains the position of the node from the beginning (1 based indexing) to which the last node will be 
connected to form a loop.

Note: If the input of the third line is zero then there is no loop.

Output:
For each test case, there will be a single line of output containing the length of the loop in a linked list, else print 0, if the loop is not present in 
the linked list.

User Task:
The task is to complete the function countNodesinLoop() which contains the only argument as reference to head of linked list.

Challenge : Try to solve the problem with constant Auxilliary space and Linear Time Complexity.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
1 <= N <= 500
0 <= C <= N-1

Example:
Input:
2
10
25 14 19 33 10 21 39 90 58 45
4
2
1 0
1
Output:
6
1

Explanation:
Testcase 1: The loop is 45->10. So length of loop is 10->21->39->90->58->45 = 6. The number 10 is connected to the last node to form the loop because 
according to the input the 4th node from the beginning(0 based index) will be connected to the last node for the loop.

Testcase2:  The length of the loop is 1.

*********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

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
    public static void makeLoop(Node head, Node tail, int x)
    {
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            System.out.println( x.countNodesinLoop(head) );
        }
    }
}


class Solution
{
    static int countNodesinLoop(Node head)
    {
        Node hare = head, turtle = head;
        
        //Floyd's cycle detection algorithm
        while(hare != null && hare.next != null)
        {
            hare = hare.next.next;
            turtle = turtle.next;
            
            if(hare == turtle)
                return loopLength(hare); //to get the length of the loop
        }
        
        return 0;
    }
    
    //gives length of the loop
    static int loopLength(Node meetPoint)
    {
        int len = 1;
        Node temp = meetPoint;
        
        while(temp.next != meetPoint)
        {
            len++;
            temp = temp.next;
        }
        
        return len;
    }
    
}




