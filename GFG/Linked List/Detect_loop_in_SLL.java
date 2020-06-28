/*
Given a linked list of N nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains the data 
of linked list. Third line contains an integer denoting the position of the linked list node(counting from head) to which the last node connects in order 
to create a loop. If this integer is 0, this means no loop exists.

Output:
For each testcase, print "True", if linked list contains loop, else print "False".

User Task:
The task is to complete the function detectloop() which contains reference to the head as only argument. This function should return 1 if linked list 
contains loop, else return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= Data on Node <= 103

Example:
Input:
2
3
1 3 4
2
4
1 8 3 4
0
Output:
True
False

Explaination:
Testcase 1: In above test case N = 3. The linked list with nodes N = 3 is given. Then value of x=2 is given which means last node is connected with xth 
node of linked list. Therefore, there exists a loop. 
Testcase 2: For N = 4 ,x = 0 means then lastNode->next = NULL, then the Linked list does not contains any loop.

**********************************************************************Solution******************************************************************************/

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
    public static void makeLoop(Node head, Node tail, int x){
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
            if( x.detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}


class Solution 
{
    public static boolean detectLoop(Node head)
    {
        Node hare = head, turtle = head;
        
        //Floyd's cycle detection algorithm
        while(hare != null && hare.next != null)
        {
            hare = hare.next.next;
            turtle = turtle.next;
            
            if(hare == turtle) //Note : we are comparing address of the 2 pointers to find the meet point, we won't compare the data part of the nodes since there might be some duplicates which will return wrong results
                return true;
        }    
        
        return false;
    }
}






