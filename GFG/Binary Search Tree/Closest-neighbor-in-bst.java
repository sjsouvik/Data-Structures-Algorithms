/*
Given a binary search tree and a number N. Your task is to complete the function findMaxforKey(), that find's the greatest number in the binary search 
tree that is less than or equal to N. Print the value of the element if it exists otherwise print -1.

Input : N = 24
Output :result = 21
(searching for 24 will be like-5->12->21)

Input  : N = 4
Output : result = 3
(searching for 4 will be like-5->2->3)

Input:
The function takes two argument as input, the reference pointer to the root of the binary search tree and integer value N.
There will be T, test cases and for each test case the function will be called separately.

Output:
For each test case print the greatest number in the binary search tree that is less than or equal to N

Constraints:
1<=T<=100
1<=N<=103

Example:
Input:
2
5
5 1 3 7 9
8
9
5 2 1 3 12 9 21 19 25
4
Output:
7
3

*********************************************************************Solution*****************************************************************************/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
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

class BST
{
    public static Node insert(Node node, int data)
    {
        if (node == null)
        {
            return (new Node(data));
        } 
        else 
        {             
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data)
            {
                node.left = insert(node.left, data);
            } else 
            {
                node.right = insert(node.right, data);
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }    
    }
    
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
                
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
                        
            while(n-- > 0)
            {
               int data = sc.nextInt();
               root = insert(root, data);
            }
            
            int N = sc.nextInt();
            
            GfG gfg = new GfG();
            System.out.println(gfg.findMaxforKey(root, N, n));
        }                
    }
}

class GfG
{
    public static int findMaxforKey(Node node, int val, int size)
    {
        Node curr = node;
        int prev = -1;
        
        while(curr != null)
        {
            if(val < curr.data)
                curr = curr.left;
            else if(val > curr.data)
            {
                prev = curr.data;
                curr = curr.right;
            }
            else
                return curr.data;
        }
        
        return prev;
    }
}










