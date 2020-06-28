/*
Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new list should be made with its own 
memory — the original lists should not be changed.

Input:
You have to complete the method which takes 3 argument: the head of the first linked list , the head of second linked list and the head of the third link 
list which is to be created. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called 
individually.

Output:
Complete the Function given to produce the desired list with intersectioned values.

User Task:
The task is to complete the function intersection() which should find the intersection of two linked list and add all the elements in intersection to the 
third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)

Constraints:
1 <= T <= 100
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 1000

Example:
Input:
2
5 4
1 2 3 4 6
2 4 6 8
4 2
10 20 40 50
15 40

Output:
2 4 6
40

Explanation:
Testcase 1: For the given first two linked list, 2, 4 and 6 are the elements in the intersection.

********************************************************************Solution******************************************************************************/

import java.io.*;
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

class GfG
{
    static Scanner sc = new Scanner(System.in);

    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	            printList(result);
	            System.out.println();
                }
        }
}


class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node headIntersection = null, tailIntersection = null;
        
        while(head1 != null && head2 != null)
        {
            //creating a new list with intersection elements from 2 lists : Merge approach of Merge sort where we merge 2 sorted lists
            if(head1.data == head2.data)
            {
                if(headIntersection == null)
                    headIntersection = tailIntersection = new Node(head1.data);
                else
                {
                    tailIntersection.next = new Node(head1.data); 
                    tailIntersection = tailIntersection.next;
                }
                
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.data > head2.data)
                head2 = head2.next;
            else
                head1 = head1.next;
        }
        
        return headIntersection;
    }
}



