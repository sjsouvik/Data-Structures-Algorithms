/*
Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively. The task is to construct the binary tree from these 
traversals.

For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}  respectively, then your function should 
construct below tree.

          1
       /      \
     2        3
   /    \     /   \
  4     5   6    7
    \
      8

Example 1:

Input:
N = 8
in[] = 4 8 2 5 1 6 3 7
post[] =8 4 5 2 6 7 3 1
Output: 1 2 4 8 5 3 6 7
Explanation: For the given postorder and
inorder traversal of tree the  resultant
binary tree will be
          1
       /    \
     2       3
   /  \    /   \
  4    5  6    7
   \
     8

Example 2:

Input:
N = 5
in[] = 9 5 2 3 4
post[] = 5 9 3 4 2
Output: 2 9 5 4 3
Explanation:  For the given postorder and
inorder traversal of tree the  resultant
binary tree will be
             2
         /      \
       9        5
     /   \
    4      3

 

Your Task:
Complete the function buildTree() which takes the inorder, postorder traversals and the number of nodes in the tree as inputs and returns the root node 
of the newly constructed Binary Tree. The pre order traversal of the returned node is printed by the driver's code.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
1 <= in[i], post[i] <= 103

***********************************************************************Solution*************************************************************************/

import java.util.*;

class Node 
{
    int data;
    Node left;
    Node right;

    Node(int value) 
    {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree 
{
    public void preOrder(Node root) 
    {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();

        while (T > 0) 
	{
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}


class GfG 
{
    int postIndex; 
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    
    Node buildTree(int in[], int post[], int n) 
    {
        postIndex = n - 1;
        
        for(int i = 0; i < n; i++)
            m.put(in[i], i);
        
        return tree1(in, post, 0, n - 1);
    }
    
    /* this solution takes O(n * n) time complexity since it requires to search each node in inorder array to find its position and to find its left and right subtree. O(n) extra space is needed for recursion function call stack */
    Node tree(int in[], int post[], int start, int end)
    {
        if(start > end)
            return null;
        
        Node root = new Node(post[postIndex--]);
        
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
        
        root.right = tree(in, post, inIndex + 1, end);
        root.left = tree(in, post, start, inIndex - 1);
        
        return root;
    }
    
    /* this solution takes O(n) time complexity since it requires O(1) time to search each node in map to find its position. But it requires O(n) extra space to store the inorder array in a map, also O(n) extra space is needed for recursion function call stack */
    Node tree1(int in[], int post[], int start, int end)
    {
        if(start > end)
            return null;
        
        Node root = new Node(post[postIndex--]);
        
        int inIndex = m.get(root.data);
        
        root.right = tree(in, post, inIndex + 1, end);
        root.left = tree(in, post, start, inIndex - 1);
        
        return root;
    }    
}






