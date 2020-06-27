/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list N and next line contains N 
integers as data of linked list.

Output:
For each test case output will be 1 if the linked list is a palindrome else 0.

User Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is 
palindrome or not respectively.

Constraints:
1 <= T <= 103
1 <= N <= 50

Example:
Input:
2
3
1 2 1
4
1 2 3 4
Output:
1
0

Explanation:
Testcase 1: The given linked list is 1 2 1 , which is a pallindrome and Hence, the output is 1.
Testcase 2: The given linked list is 1 2 3 4 , which is not a pallindrome and Hence, the output is 0.

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

class Is_LinkedList_Palindrom
{
        Node head;  
        Node tail;
	    	    	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        	{
			int n = sc.nextInt();
									
			int a1=sc.nextInt();
			Node head= new Node(a1);
            		Node tail = head;

            		for (int i = 1; i < n; i++) 
			{
			    int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Palindrome g = new Palindrome();

			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    	else
			    System.out.println(0);
			t--;
		}
		
	}
}


class Palindrome
{
    //function to check if linked list is palindrome - time complexity : O(n), space complxity : O(1)
    boolean isPalindrome(Node head)
    {
        Node mid = head, temp = head, headSecondHalf = null;
        
        //to find the middle element and divide the list into 2 sublists
        while(temp != null && temp.next != null)
        {
            temp = temp.next.next;
            mid = mid.next;
        }
        
        /*
        temp would become NOT NULL if there are odd number of elements 
        and become null if there're even number of elements, by checking this 
        initializing the head of second half of the list
        */
        if(temp != null) //if odd number of elements are there, next of the mid element will be the head of the second half 
            headSecondHalf = mid.next;   
            
        else //if even number of elements are there, mid element will be the head of the second half 
            headSecondHalf = mid;
            
        headSecondHalf = reverse(headSecondHalf);
        
        return (compare(head, mid, headSecondHalf));
    }
    
    //to reverse the second half of the main list
    Node reverse(Node head)
    {
        Node prev = null, current = head, next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    //function to compare first half of the main list with reverse of second half 
    boolean compare(Node headFirst, Node endFirst, Node headSecond)
    {
        while(headFirst != endFirst && headSecond != null)
        {
            if(headFirst.data != headSecond.data)
                return false;
             
            headFirst = headFirst.next;
            headSecond = headSecond.next;
        }
        
        return true;
    }
    
    
    //Another way to solve the same problem, time complexity - O(n) but it takes extra space of O(n)
    boolean isPalindrome2(Node head) 
    {
        boolean isPalin = true;
        
        Stack<Integer> s = new Stack<Integer>();
        
        Node temp = head;
        
        //pushing all data into a stack
        while(temp != null)
        {
            s.push(temp.data);
            temp = temp.next;
        }
        
        //popping data from stack and comparing with the main list - it takes extra space of O(n)
        while(head != null)
        {
            if(head.data != s.pop())
                isPalin = false;
            
            head = head.next;
        }
        
        return isPalin;
    }    
}








