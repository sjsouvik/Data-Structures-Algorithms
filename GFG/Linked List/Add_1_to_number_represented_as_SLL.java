/*
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Input:
The First line contains the number of test cases, and for each test case a single line of input denotes an big number N.

Output:
For each test case, print the resulting number in a new line.

User Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked 
list. The driver code prints the number and adds a new line.

Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 101000

Example:
Input:
4
456
123
999
1879
Output:
457 
124 
1000 
1880
Explanation:
456 + 1 = 457
123 + 1 = 124
999 + 1 = 1000
1879 + 1 = 1880

*********************************************************************Solution*******************************************************************************/

import java.io.*;
import java.util.*;

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

class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 

    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Sol obj = new Sol();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}


class Sol
{
    public static Node addOne(Node head) 
    { 
        if(head == null)
            return head;
        
        head = reverse(head);
        
        int sum, carry = 1; //carry is initialized as 1 as 1 is the element that needs to be added with the number represented as list
        
        Node prev = null, temp = head;
        
        while(temp != null)
        {
            sum = temp.data + carry;
            
            carry = (sum >= 10 ? 1 : 0);
            
            temp.data =  sum % 10;
            
            prev = temp;
            temp = temp.next;
        }
        
        if(carry > 0)
            prev.next = new Node(carry);
        
        head = reverse(head);
        
        return head;
    }
    
    //Another way to solve the problem
    public static Node addOne2(Node head) 
    { 
        if(head == null)
            return head;
        
        head = reverse(head);
        
        int sum, carry = 1; //carry is initialized as 1 as 1 is the element that needs to be added with the number represented as list
        
        Node temp = head;
        
        while(carry > 0)
        {
            sum = temp.data + carry;
            
            carry = (sum >= 10 ? 1 : 0);
            
            temp.data =  sum % 10;
            
            if(temp.next == null)
                break;
            
            temp = temp.next;
        }
        
        if(carry > 0)
            temp.next = new Node(carry);
        
        head = reverse(head);
        
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
        
        return prev;
    }
    
}





