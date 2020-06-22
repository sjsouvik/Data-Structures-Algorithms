/*
Given a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the number of nodes N, to be inserted 
into the linked list and the next line contains data of N nodes.

Output:
There will be a single line of output for each test case, which contains the length of the linked list.

User Task:
Your task is to complete the given function getCount(), which takes a head reference as an argument and should return the length of the linked list.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= value <= 103

Example:
Input:
2
5
1 2 3 4 5
7
2 4 6 7 5 1 0
Output:
5
7

Explanation:
Testcase 1: Count of nodes in the linked list is 5, which is its length.
Testcase 2: Count of nodes in the linked list is 7. Hence, the output is 7.

********************************************************************Solution*******************************************************************************/

import java.util.*;

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

class LinkedList
{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
                        
            System.out.println(getCount(head));
        }
    }
   
       
    public static int getCount(Node head)
    {
        Node temp = head;
        
        int c=0;
        
        while(temp != null)
        {
            c++;
            temp = temp.next;
        }
        
        return c;
    }
    
}





