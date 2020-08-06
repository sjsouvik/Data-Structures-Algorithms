/*
Given a Binary Tree of size N. The task is to complete the function sumLeaf(), that should return the sum of all the leaf nodes of the given binary tree.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines, first of which containing the number of edges (between 
two nodes) in the tree. Next line contains N pairs (considering a and b) with a 'L' (means node b on left of a) or 'R' (means node b on right of a) after 
a and b.

Output:
For each testcase, there will be a single line containing the sum of all leaf nodes in the tree.

User Task:
The task is to complete the function sumLeaf() which takes root reference as argument and returns the sum of all leaf nodes.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
2
1 2 L 1 3 R
5
10 20 L 10 30 R 20 40 L 20 60 R 30 90 L

Output:
5
190

Explanation:
Testcase 1: Leaf nodes in the tree are 2 and 3, and their sum is 5.

************************************************************************Solution*************************************************************************/

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

class LeafNodes
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while(n-- > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
	        char lr= sc.next().charAt(0);
				                
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }
            
            GfG gfg = new GfG();
            System.out.println(gfg.SumofLeafNodes(root));
        }
    }
}


class GfG
{
    public int SumofLeafNodes(Node root)
    {
        if(root == null)
            return 0;
        
        //this will return leaf node's data
        if(root.left == null && root.right == null)
            return root.data;
        
        int left = SumofLeafNodes(root.left); //this will give sum of leaf nodes at left subtree
        int right = SumofLeafNodes(root.right); //this will give sum of leaf nodes at right subtree
        
        return left + right; //this will return sum of all leaf nodes
    }
}











