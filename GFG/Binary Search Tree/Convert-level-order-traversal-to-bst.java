/*
Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), that construct the BST 
(Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.

Example 2:

Input:
N = 6
BST[] = {1,3,4,6,7,8}
Output: 1 3 4 6 7 8
Explanation: After constructing BST, the
preorder traversal of BST is 1 3 4 6 7 8.

Your Task:
Your task is to complete the function constructBst() which has two arguments, first as the array containing level order traversal of BST and next 
argument as the length of array which return the root of the newly constructed BST. The preorder traversal of the tree is printed by the driver's code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103

*********************************************************************Solution*******************************************************************************/

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node left, right;
    
    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class Main 
{    
	public static void main (String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
            while(t-- > 0)
	    {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for(int i=0; i<n; i++)
		{
                    arr[i] = sc.nextInt();
                }
                GFG obj = new GFG();
                Node tree = obj.constructBST(arr);
                preorder(tree);
                System.out.println();
            }
	}
	
	public static void preorder(Node root)
	{
            if(root == null)
	    {
                return;
            }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
       }
}


/* The idea is to use the BST property to construct the tree. Start with root node by setting range of root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and then recursively setting range of other nodes. Range of left node would be [min range of its root node, data of root node] and range of right node would be [data of root node, max range of its root node] */
class nodeDetails
{
    Node node;
    int min, max;
    
    nodeDetails(Node node, int min, int max)
    {
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

class GFG 
{
    public Node constructBST(int[] a)
    {
        Node root = new Node(a[0]);
        nodeDetails r = new nodeDetails(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Queue<nodeDetails> q = new LinkedList<nodeDetails>();
        
        q.add(r);
        
        int i = 1;
        while(i < a.length)
        {
            nodeDetails removed = q.poll();
            Node removedNode = removed.node;
            int min = removed.min;
            int max = removed.max;
            
            if(a[i] > min && a[i] < removedNode.data)
            {
                removedNode.left = new Node(a[i++]);
                q.add(new nodeDetails(removedNode.left, min, removedNode.data));
            }
            
            if(i == a.length)
                break;
                
            if(a[i] > removedNode.data && a[i] < max)
            {
                removedNode.right = new Node(a[i++]);
                q.add(new nodeDetails(removedNode.right, removedNode.data, max));
            }
        }
        
        return root;
    }
}






