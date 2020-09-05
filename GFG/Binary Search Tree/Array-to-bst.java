/*
Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements. If there are N elements in array, then floor(n/2)'th 
element should be chosen as root and same should be followed recursively.

Input:
The first line of input contains an integer T, denoting the number of test cases. The first line of each test case is N(size of array). The second line of 
each test case contains N input A[].

Output:
Print the preorder traversal of constructed BST.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
1 ≤ A[i] ≤ 10000

Example:
Input:
1
7
1 2 3 4 5 6 7

Output:
4 2 1 3 6 5 7 

**********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args) throws IOException
    {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     Node root = constructBST(a, 0, n - 1);   
    	     System.out.println();
    	 }
    }
	 
	 static Node constructBST(int a[], int l, int h)
	 {
	     if(l > h)
	        return null;
	        
	     int mid = l + ((h - l) / 2);
	     Node root = new Node(a[mid]);
	     
	     System.out.print(root.data + " ");
	     
	     root.left = constructBST(a, l, mid - 1);
	     root.right = constructBST(a, mid + 1, h);
	     
	     return root;
	 }
}



