/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

Example 1:

Input:
N = 5
arr[]  = {40,30,35,80,100}
Output: 35 30 100 80 40
Explanation: PreOrder: 40 30 35 80 100
InOrder: 30 35 40 80 100
Therefore, the BST will be:
              40
           /      \
         30       80
           \        \   
           35      100
Hence, the postOrder traversal will
be: 35 30 100 80 40

Example 2:

Input:
N = 8
arr[]  = {40,30,32,35,80,90,100,120}
Output: 35 32 30 120 100 90 80 40

Your Task:
You need to complete the given function and return the root of the tree. The driver code will then use this root to print the post order traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
1 <= arr[i] <= 104

**********************************************************************Solution***************************************************************************/

import java.util.*;
import java.io.*;

class Node 
{ 
    int data; 
    Node left, right; 
    Node(int d) 
    { 
	data = d; 
	left = right = null; 
    } 
} 

class GFG 
{	
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine().trim());
	while(t-- > 0)
	{
	    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
	    {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = constructTree(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    

/* The idea is to use the BST property to construct the tree. Start with root node by setting range of root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and then recursively setting range of other nodes. Range of left node would be [min range of its root node, data of root node] and range of right node would be [data of root node, max range of its root node] */
static int i;
public static Node constructTree(int pre[], int size) 
{
    i = 0;
    return construct(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
} 

static Node construct(int a[], int l, int h)
{
    if(i == a.length)
        return null;
    
    Node root = null;
    
    if(a[i] > l && a[i] < h)
    {
        root = new Node(a[i]);
        i++;
    }
    else
        return null; 
    
    /* Need to build left subtree before right subtree since the values are being read from the beginning of the preorder sequence */
    root.left = construct(a, l, root.data);
    root.right = construct(a, root.data, h);
    return root;
}

public static void printInorder(Node node) 
{ 
    if (node == null) 
    { 
	return; 
    } 
    printInorder(node.left); 
    System.out.print(node.data + " "); 
    printInorder(node.right); 
} 
	
public static void printPostorder(Node node) 
{ 
    if (node == null) 
    { 
	return; 
    } 
    printPostorder(node.left); 
    printPostorder(node.right);
    System.out.print(node.data + " "); 
} 
	
public static void printPreorder(Node node) 
{ 
    if (node == null) 
    { 
	return; 
    } 
    System.out.print(node.data + " "); 
    printPreorder(node.left); 
    printPreorder(node.right);
} 

}  






