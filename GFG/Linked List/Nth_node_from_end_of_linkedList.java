/*
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Input:
The first line of input contains the number of testcase T. For each testcase, the first line of input contains the number of nodes in the linked list 
and the number N. The next line contains N nodes of the linked list.

Output:
For each testcase, output the data of node which is at Nth distance from the end or -1 in case node doesn't exist.

User Task:
The task is to complete the function getNthFromLast() which takes two arguments: reference to head and N and you need to return Nth from the end.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 200
1 <= L <= 103
1 <= N <= 103

Example:
Input:
2
9 2
1 2 3 4 5 6 7 8 9
4 5
10 5 100 5
Output:
8
-1

Explanation:
Testcase 1: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end. 2nd node from end os 8.  
Testcase 2: In the second example, there are 4 nodes in the linked list and we need to find 5th from the end. Since 'n' is more than the number of nodes 
in the linked list, the output is -1.

**********************************************************************Solution*****************************************************************************/

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
	

	
public class LinkedList_Element_From_Last
{
    Node head;  
    Node tail;
      
    public void addToTheLast(Node node) 
    {

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	  
     
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
	 while(t>0)
         {
            int n = sc.nextInt();
	    int k = sc.nextInt();

	    LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
			
	    int a1=sc.nextInt();
	    Node head= new Node(a1);

            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
	    {
		int a = sc.nextInt(); 
		llist.addToTheLast(new Node(a));
       	    }
          		
            GfG g = new GfG(); 
		
	    System.out.println(g.getNthFromLast(llist.head,k));
		
	    t--;
	}
   }
}


class GfG
{    
    int getNthFromLast(Node head, int n)
    {    	
    	Node temp = head;
    	
    	int len = 0;
    	
    	while(temp != null)
    	{
    	    len++;
    	    temp = temp.next;
    	}
    	
    	if(n > len)
    	    return -1;
    	
    	int c = len - n + 1;
    	
    	temp = head;

    	while(c-- > 1)
    	    temp = temp.next;
    	
    	return temp.data;    
    }
}




