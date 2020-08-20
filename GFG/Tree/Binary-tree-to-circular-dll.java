/*
Given a Binary Tree of N edges. The task is to convert this to a Circular Doubly Linked List(CDLL) in-place. The left and right pointers in nodes are to 
be used as previous and next pointers respectively in converted CDLL. The order of nodes in CDLL must be same as Inorder of the given Binary Tree. The 
first node of Inorder traversal (left most node in BT) must be head node of the CDLL.

Example 1:

Input:
      1
    /   \
   3     2
Output:
3 1 2 
2 1 3
Explanation: After converting tree to CDLL
when CDLL is is traversed from head to
tail and then tail to head, elements
are displayed as in the output.

Example 2:

Input:
     10
   /    \
  20    30
 /  \
40  60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:After converting tree to CDLL,
when CDLL is is traversed from head to
tail and then tail to head, elements
are displayed as in the output.

Your Task:
You don't have to take input. Complete the function bTreeToCList() that takes root as a parameter and returns the head of the list. The printing is done 
by the driver code.

Constraints:
1 <= N <= 103
1 <= Data of a node <= 104

Expected time complexity: O(N)

Expected auxiliary space: O(h) , where h = height of tree

*********************************************************************Solution*****************************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG 
{    
    static Node buildTree(String str)
    {        
        if(str.length()==0 || str.charAt(0)=='N')
	{
            return null;
        }
        
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue        
        Queue<Node> queue = new LinkedList<>();         
        queue.add(root);

        // Starting from the second element        
        int i = 1;

        while(queue.size()>0 && i < ip.length) 
	{                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;

            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }

            i++;
        }
        
        return root;
    }

    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }

    static void displayCList(Node head)
    {
        Node itr = head;

        do
        {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head!=itr);

        System.out.println();
    	itr=itr.left;

    	do
	{
    	    System.out.print(itr.data + " ");
            itr=itr.left;
    	}while(head!=itr);

    	System.out.println(itr.data + " ");
    }
    
	public static void main (String[] args) throws IOException 
	{
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());

	        while(t-- > 0)
		{
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree boj = new Tree();
	            Node head = boj.bTreeToClist(root);
	            displayCList(head);	            
	        }	    
	}
}


class Tree
{ 
    Node head = null;
    Node prev = null;
    
    Node bTreeToClist(Node root)
    {
        if(root == null)
            return null;
        
        Node left = bTreeToClist(root.left);
        
        if(head == null)
            head = root;
        else
        {
            prev.right = root;
            root.left = prev;
        }
        
        prev = root;
   
        Node right = bTreeToClist(root.right);
     
        //in circular DLL previous reference of head stores the reference of last node in the list and next reference of last node in the list stores the reference of head node
        if(right == null)
        {
            head.left = root;
            root.right = head;
        }
        
        return head;
    }    
}
    








