/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List

Note: Expected time complexity is O(m + n) where m and n are lengths of two linked lists.

Input:
First line of input is the number of test cases T. Every test case has four lines. First line of every test case contains three numbers, x (number of nodes 
before merge point in 1st list), y (number of nodes before merge point in 2nd list) and z (number of nodes after merge point). Next three lines contain x, y 
and z values.

Output:
Print the data of the node in the linked list where two linked lists intersects.

Your Task:
The task is to complete the function intersetPoint() which finds the point of intersection of two linked list. The function should return data value of a 
node where two linked lists merge. If linked list do not merge at any point, then it should return -1.

Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= value <= 1000

Example:
Input:
2
2 3 2
10 20
30 40 50
5 10
2 3 2
10 20
30 40 50
10 20
8 5 1
19 24 28 8 12 14 5 45
31 27 11 41 45
42
Output:
5
10
42

Explanation:
Testcase 1: The point of intersection of two linked list is 5, means both of them get linked (intersects) with each other at node whose value is 5.
Testcase 2: The point of intersection of two linked list is 10. Hence, output is 10.

************************************************************************Solution***************************************************************************/

import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) 
    {
        data = d; 
        next = null;
    }
}
	
class LinkedList_Intersection
{        
    public static void main(String args[])
    {                        
         Scanner sc = new Scanner(System.in);
	 int t=sc.nextInt();
		 
	 while(t>0)
         {
	 	int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int a1=sc.nextInt();
		Node head1= new Node(a1);
		Node tail1= head1;
				
		for (int i = 1; i < n1; i++) 
		{
			int a = sc.nextInt(); 
			tail1.next = (new Node(a));
			tail1= tail1.next;
		}
						
		int b1=sc.nextInt();
		Node head2 = new Node(b1);
		Node tail2 = head2;
		for (int i = 1; i < n2; i++) 
		{
			int b = sc.nextInt();  
			tail2.next = (new Node(b));
			tail2= tail2.next;
		}
				
		int c1=sc.nextInt();
		Node head3= new Node(c1);
		tail1.next = head3;
		tail2.next = head3;
		Node tail3=head3;
		for (int i = 1; i < n3; i++) 
		{
			int c = sc.nextInt();   
			tail3.next = (new Node(c));
			tail3= tail3.next;
		}
				
		Intersect obj = new Intersect();
		System.out.println(obj.intersectPoint(head1, head2));
		t--;			
         }
    }
}


class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
        int c1 = 1, c2 = 1, d = 0;
        
        Node temp = headA;
        while(temp != null)
        {
            temp = temp.next;
            c1++;
        }
        
        temp = headB;
        while(temp != null)
        {
            temp = temp.next;
            c2++;
        }
        
        Node headBiggerList = null, headSmallList = null;
        
        if(c1 > c2)
        {
            d = c1 - c2; //difference of node counts
            headBiggerList = headA;
            headSmallList = headB;
        }
        else
        {
            d = c2 - c1;
            headBiggerList = headB;
            headSmallList = headA;
        }
        
        //traversing the bigger list till 'd' nodes so that here onwards both the lists have equal number of nodes
        while(--d >= 0)
            headBiggerList = headBiggerList.next;
        
        //traversing both the lists in parallel till we get a common node
        //Note : will get the common node by comparing the address of nodes - trickiest part of the solution
        while(headBiggerList != null && headSmallList != null)
        {
            if(headBiggerList == headSmallList) //will be comparing the address of nodes as there might be some common elements before the intersection point
                return headSmallList.data;
            
            headBiggerList = headBiggerList.next;
            headSmallList = headSmallList.next;
        }
        
        return -1;
	}
}











