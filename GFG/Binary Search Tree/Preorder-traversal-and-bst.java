/*
Given an array arr of size n, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input.
The first line of each test case is n, denoting the size of array.
The second line of each test case contains n elements of the array.

Output:
For each testcase, in a new line, print 1 if the array represents preorder traversal else print 0.

Constraints:
1 <= T<= 100
1 <= n <= 103
1 <= arr[i] <= 103

Example:
Input:
3
5
40 30 35 80 100
8
40 30 32 35 80 90 100 120
8
7  9 6 1 4 2 3 40

Output:
1
1
0

***********************************************************************Solution***************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    Node left, right;
    int data;
    
    Node(int d)
    {
        data = d;
        left = right = null;
    }
}

/* The idea is to construct BST from the given preorder sequence and then check whether the entire given preorder sequence is traversed or not while constructing the BST from the given preorder sequence */
//if the given preorder sequence doesn't represent BST then we won't be able to construct the entire BST from it
class GFG
 {
     static int index;
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
    	     
    	     index = 0;
    	     Node root = constructTree(a, Integer.MIN_VALUE, Integer.MAX_VALUE);   
    	     System.out.println(index == a.length ? 1 : 0); //this is to check whether the whole given preorder sequence is traversed or not while constructing BST from the given preorder sequence
    	 }
    }
	 
	 //this is to construct BST from the given preorder sequence
	 static Node constructTree(int a[], int l, int h)
	 {
	     if(index == a.length || a[index] < l || a[index] > h)
	        return null;
	     
	     Node root = new Node(a[index]);   
	     index++;
	     
	     root.left = constructTree(a, l, root.data);
	     root.right = constructTree(a, root.data, h);
	     
	     return root;
	 }
}




