/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the 
addition of two input numbers.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the first linked list and 
next line contains N elements of the linked list. Again, the next line contains M, and the following line contains M elements of the linked list.

Output:
Output the resultant linked list.

User Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the new list.

Expected Time Complexity: O(N) + O(M)
Expected Auxiliary Space: O(N) + O(M)

Constraints:
1 <= T <= 100
1 <= N, M <= 5000

Example:
Input:
2
2
4 5
3
3 4 5
2
6 3
1
7
Output:
3 9 0  
7 0

Explanation:
Testcase 1: For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
Testcase 2: For the given two linked list (6 3) and (7), after adding the two linked list resultant linked list will be (7 0).

***********************************************************************Solution****************************************************************************/

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG
{    
    static void printList(Node n)
    {
        while(n!=null)
	{
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) 
	{
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}


class Solution
{
    static Node addLists(Node first, Node second)
    {        
        first = reverse(first);
        second = reverse(second);
        
        int carry = 0, sum = 0;
        Node head = null, temp = null;
        
        while(first != null || second != null)
        {
            sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
            
            carry = (sum >= 10 ? 1 : 0);
            sum = sum % 10;
            
            /*
            creating a new list with the sum of each element from 2 given lists,
            adding each sum at the beginning of the list so that we can print the list 
            as it is without reversing it
            */
            temp = new Node(sum);
            
            if(head == null)
                head = temp;
            else
            {
                temp.next = head;
                head = temp;
            }
            
            if(first != null)
                first = first.next;
            
            if(second != null)
                second = second.next;    
        }
        
        //if there's any carry left to be added
        if(carry > 0)
        {
            temp = new Node(carry);
            temp.next = head;
            head = temp;
        }
        
        return head;
    }
    
    static Node reverse(Node head)
    {
        Node prev = null, current = head, next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        
        return head; //head of the list containing the sum of 2 given lists
    }
    
}






