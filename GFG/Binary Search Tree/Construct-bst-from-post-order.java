/*
Given postorder traversal of a Binary Search Tree, you need to complete the function constructTree() which will create a BST. The output will be the 
inorder of the constructed BST.

Input:
The constructTree() method consist of two arguments as input, the array consisting of the post order traversal and the size of the array.

Output:
Print the Inorder traversal of the constructed BST.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 7 5 50 40 10
9
216 823 476 429 850 93 18 975 862

Output:
1 5 7 10 40 50
18 93 216 429 476 823 850 862 975

Explanation:
Testcase 1: The BST for the given post order traversal is:

Thus the inorder traversal of BST is: 1 5 7 10 40 50.

**********************************************************************Solution***************************************************************************/

import java.util.Scanner;
import java.lang.Math;
import java.io.*;

class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}

class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG(n);
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

class GFG
{
    static int n;
    
    GFG(int n)
    {
        this.n = n;
    }
    
    /* The idea is to use the BST property to construct the tree. Start with root node by setting range of root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and then recursively setting range of other nodes. Range of left node would be [min range of its root node, data of root node] and range of right node would be [data of root node, max range of its root node] */
    public static Node constructTree(int post[], int n)
    {
        return construct(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static Node construct(int a[], int l, int h)
    {
        if(n == 0 || a[n - 1] < l || a[n - 1] > h) //return null if all the elements are processed or the next element of postorder traversal from the end is not in valid range to follow the BST property
            return null;
            
        Node root = new Node(a[n - 1]);    
        n--;
        
        /* Need to build right subtree before left subtree since the values are being read from the end of the postorder sequence */
        root.right = construct(a, root.data, h);
        root.left = construct(a, l, root.data);
        
        return root;
    }
}




