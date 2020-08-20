/*
Given a Binary Tree, the task is to extract all leaves of it in a Doubly Linked List (DLL). Note that the DLL needs to be created in-place. Assume that 
the node structure of DLL and Binary Tree is the same, only the meaning of left and right pointers are different. In DLL, left means previous pointer 
and right means next pointer. Head of DLL should point to the leftmost leaf and then in inorder traversal and so on.

Input:
The first line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing 
the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:


For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each testcase, there will be three lines. First-line contains inorder traversal of the tree(after extracting leaves). The second and third line 
contains the nodes of DLL, first in order of inorder traversal of tree and next in reverse order.

User Task:
The task is to complete the function convertToDLL() which takes the root of the given binary tree as input and returns the head of the doubly link list. 
This function should extract the leaf nodes into a doubly link list and modify the original binary tree by excluding the leaf nodes. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= Data on Node <= 104

Example:
Input:

2
1 2 3
1 2 3 4

Output:

1
2 3
3 2
2 1
4 3
3 4

Explanation:
Testcase 2: After extracting leaves, 3 and 4 from the tree, the inorder traversal of the remaining binary tree produces 2, 1 and we have doubly linked 
list as 4 <-> 3.

***********************************************************************Solution************************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG 
{    
    static Node buildTree(String str)
    {        
        if(str.length()==0 || str.charAt(0)=='N')
	{
            return null;
        }
        
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue        
        Queue<Node> queue = new LinkedList<>();         
        queue.add(root);

        // Starting from the second element        
        int i = 1;

        while(queue.size()>0 && i < ip.length) 
	{            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;

            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) 
	    {                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }


    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException
    {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
    
            while(t-- > 0)
	    {
                String s = br.readLine();
                Node root = buildTree(s);
                Tree g = new Tree();
                Node head = g.convertToDLL(root);
                printInorder(root);
                System.out.println();
                Node curr = head;
                Node last = head;

                while(curr!=null)
		{
                    System.out.print(curr.data+" ");
                    last = curr;
                    curr = curr.right;
                }

                System.out.println();
                curr = last;

                while(curr!=null)
		{
                    System.out.print(curr.data+" ");
                    curr = curr.left;
                }
                System.out.println();    
            }
    }
}


// return the head of the DLL and remove those node from the tree as well.
class Tree
{
    Node head = null;
    Node prev = null;
    int leaf = 0;
    
    public Node convertToDLL(Node root)
    {
        if(root == null)
            return null;
        
        Node left = convertToDLL(root.left);
        
        //this is to remove leaf node at left subtree
        if(leaf == 1)
        {
            root.left = null;
            leaf = 0;
        }
        
        Node right = convertToDLL(root.right);
        
        //this is to remove leaf node at right subtree
        if(leaf == 1)
        {
            root.right = null;
            leaf = 0;
        }
        
        if(left == null && right == null)
        {
            leaf = 1;
            if(head == null)
                head = root;
            else
            {
                prev.right = root;
                root.left = prev;
            }
            
            prev = root;
        }
        
        return head;
    }
}








