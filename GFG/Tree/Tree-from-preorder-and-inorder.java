/*
Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Input:
First-line consists of T test cases. The first line of every test case consists of N, denoting the number of elements in the array. The second and third 
line of every test case consists of Inorder and preorder traversal of a tree.

Output:
For each test case, print the postorder traversal in a new line.

User Task:
Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and 
returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically.

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(N).

Constraints:
1<=T<=500
1<=N<=1000

Example:
Input:
2
4
1 6 8 7
1 6 7 8
6
3 1 4 0 5 2
0 1 3 4 2 5

Output:
8 7 6 1
3 4 1 5 2 0

Explanation:
Test Case 2: Tree constructed from given traversals will be:
                                                                      0
                                                                   /      \
                                                                 1         2
                                                               /     \      /
                                                             3       4   5

*************************************************************************Solution*******************************************************************************/

import java.util.*;
import java.io.*;

class Node
{
    int data; 
    Node left, right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}


class Solution
{
    static int preIndex;
    static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        preIndex = 0;
        
        for(int i = 0; i < n; i++)
        {
            m.put(inorder[i], i);
        }
        
        return tree1(inorder, preorder, 0, n - 1);
    }
    
    /* this solution takes O(n * n) time complexity since it requires to search each node in inorder array to find its position and to find its left and right subtree. O(n) extra space is needed for recursion function call stack */
    static Node tree(int in[], int pre[], int start, int end)
    {
        if(start > end)
            return null;
        
        Node root = new Node(pre[preIndex++]);
        
        int inIndex = -1;
        
        //this part of the code takes O(n) to search each node in inorder array
        for(int i = start; i <= end; i++)
        {
            if(in[i] == root.data)
            {
                inIndex = i;
                break;
            }        
        }
        
        root.left = tree(in, pre, start, inIndex - 1);
        root.right = tree(in, pre, inIndex + 1, end);
        
        return root;
    }
    
    /* this solution takes O(n) time complexity since it requires O(1) time to search each node in map to find its position. But it requires O(n) extra space to store the inorder array in a map, also O(n) extra space is needed for recursion function call stack */
    static Node tree1(int in[], int pre[], int start, int end)
    {
        if(start > end)
            return null;
        
        Node root = new Node(pre[preIndex++]);
        
        int inIndex = m.get(root.data);
        
        root.left = tree(in, pre, start, inIndex - 1);
        root.right = tree(in, pre, inIndex + 1, end);
        
        return root;
    }    
}





