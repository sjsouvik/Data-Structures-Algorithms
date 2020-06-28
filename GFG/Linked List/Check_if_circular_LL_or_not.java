/*
Given a singly linked list, find if the linked list is circular or not. A linked list is called circular if it not NULL terminated and all nodes are 
connected in the form of a cycle. An empty linked list is considered as circular.

Input:
First line of input contains number of testcases T. For each testcase, first line consists of number of nodes in the linked list and an integer 
representing if the list is circular list.

Output:
The function should return true if the given linked list is circular, else false.

User Task:
The task is to complete the function isCircular() which checks if the given linked list is circular or not. It should return true or false accordingly.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <=T<= 50
1 <=N<= 100
1 <=value<= 1000

Example:
Input:
2
5 1      
1 2 3 4 5
6 0
2 4 6 7 5 1

Output:
1
0

Explanation:
Testcase 1: k is 1, therefore output is 1.

**********************************************************************Solution******************************************************************************/

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

class Is_LinklIst_Circular
{
	Node head;
	
	
	public static void main(String args[])
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int l = sc.nextInt();
			
			sc.nextLine().trim().split(" ");
			String str[]= sc.nextLine().trim().split(" ");
            		Node head = null, tail = null;
	                head = new Node(Integer.parseInt(str[0]));
            		tail = head;
            		for(int i = 1; i < n ; i++)
            		{
                		tail.next = new Node(Integer.parseInt(str[i]));
                		tail = tail.next;
            		}
                
			
			if(l==1 && n>=1)
			{
				Node temp = head;
				while(temp.next != null)
				{
					temp = temp.next; 
				}
				temp.next = head;
			}
			
			GfG g = new GfG();
			boolean b = g.isCircular(head);
			if(b==true)
			System.out.println(1);
			else 
			System.out.println(0);
			t--;
		}
	}
}


class GfG
{
    boolean isCircular(Node head)
    {
        Node temp = head;
        
    	while(temp.next != null && temp.next != head)
    	    temp = temp.next;
	    
	    return temp.next == null ? false : true;
    }
}


