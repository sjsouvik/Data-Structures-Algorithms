/*
Given a Binary Search Tree (BST), you need to find if a particular node(data) is present in the BST or not. 
Note: The BST does not insert duplicates.

Example 1:

Input:
         2
          \
          81
        /    \
      42      87
    /   \       \
   45   66      90
x = 87
Output: 1
Explanation: As 87 is present in the
given nodes , so the output will be
1.

Example 2:

Input:
      6
       \
        7
       / \
      8   9
x = 11
Output: 0
Explanation: As 11 is not present in 
he given nodes , so the output will
be 0.

Your Task:
This is a function problem. you don't have to read any input. Your task is to complete the function search() which returns true if the node with 
value x is present in the BST else returns false. The printing is done by the driver's code.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).

Constraints:
1 <= Number of nodes <= 100

***********************************************************************Solution**************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node left;
	Node right;
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class Is_Node__Present_In_BST
{
	void insert(Node root, int key)
	{
		
		if(key < root.data)
		{
			if(root.left!=null)
				insert(root.left,key);
			else
				root.left = new Node(key);
		}
		else if(key > root.data)
		{
			if(root.right != null)
				insert(root.right, key);
			else
				root.right = new Node(key);
		}
		
	}

	public static void main(String args[])
	{		
		Scanner sc = new Scanner(System.in);
		
		int t  =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Is_Node__Present_In_BST obj = new Is_Node__Present_In_BST();
			int a1 = sc.nextInt();
			Node root = new Node(a1);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				obj.insert(root,a);
			}
			
			int s = sc.nextInt();
			BST g = new BST();
			if(g.search(root,s)== true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;
		}
		
	}	
}


class BST
{
    //both recursive and iterative solution takes O(h) times to solve but recursive solution also takes O(h) extra space for recursive function call stack, where h = height of BST
    //recursive solution to search a node in BST
    boolean search1(Node root, int x)
    {
	    if(root == null)
	        return false;
	        
	    if(root.data == x)
	        return true;
	        
	    if(root.data > x)
	        return search(root.left, x);  
	    else//if (root.key < x)
	        return search(root.right, x);      
    }
    
    //iterative solution to search a node in BST
    boolean search(Node root, int x)
    {
        Node curr = root;
        
        while(curr != null)
        {
            if(curr.data == x)
                return true;
                
            if(curr.data > x)
                curr = curr.left;
            else //if(curr.data < x)
                curr = curr.right;
        }
        
        return false;
    }
}







