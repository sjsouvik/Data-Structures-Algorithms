/*
Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the 
distinct elements only.

Input:
The function takes 2 arguments, reference pointer to the head of the first linked list (head1) and reference pointer to the head of the second linked list 
(head2). 

There are multiple test cases and for each test case this function will be called separately.

Output:
The function should return reference pointer to the head of the new list that is formed by the union of the two the lists. 
Note: The new list formed should be in non-decreasing order.

User Task:
The task is to complete the function makeUnion() which makes the union of the given two lists.

Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1<=T<=100
1<=N<=5000

Example:
Input:
1
6
9 6 4 2 3 8
5
1 2 8 6 2

Output:
1 2 3 4 6 8 9

Explanation:
Testcase 1: Union of the given two lists have elements 1, 2, 3, 4, 6, 8 and 9 in the list.

************************************************************************Solution****************************************************************************/

// { Driver Code Starts
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
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //As objects are stored in sorted and ascending oreder, it implements the SortedSet interface 
	    TreeSet<Integer> ts = new TreeSet<Integer>();
	    
	    //Adding elements of 2 lists into a TreeSet, we are implementing TreeSet as we need all union elemnts in ascending order and Set doesn't contain duplicates
	    while(head1 != null)
	    {
	        ts.add(head1.data);
	        head1 = head1.next;
	    }
	    
	    while(head2 != null)
	    {
	        ts.add(head2.data);
	        head2 = head2.next;
	    }
	    
	    //Adding all elements from TreeSet to a list
	    Node head = null, tail = null;
	    
	    for(Integer i : ts)
	    {
	        if(head == null)
	            head = tail = new Node(i);
	        else
	        {
	            tail.next = new Node(i);
	            tail = tail.next;
	        }
	    }
	    
	    return head;
	}
}



