/*
Given two Binary Search Trees(without duplicates). Find need to print the common nodes in them. In other words, find intersection of two BSTs

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3

Your Task:
You don't need to read input or print anything. Your task is to complete the function printCommon() that takes roots of both the BSTs as input and 
returns an array containing the intersection of the 2 BSTs in a sorted order. 

Expected Time Complexity: O(N1 + N2) where N1 and N2 are the sizes of the 2 BSTs.
Expected Auxiliary Space: O(H1 + H2) where H1 and H2 are the Heights of the 2 BSTs.

Constraints:
1 <= N <= 103

**********************************************************************Solution****************************************************************************/

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;

        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException 
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t > 0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            BST g=new BST();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.printCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}


class BST
{
    public static ArrayList<Integer> printCommon(Node root1,Node root2)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Set<Integer> s = new HashSet<Integer>();
        
        inOrder1(root1, s); //this traversal is required to insert all nodes of one tree into HashSet
        inOrder2(root2, s, al); //this traversal of other tree is required to check common nodes
        
        return al;
    }
    
    static void inOrder1(Node root, Set<Integer> s)
    {
        if(root == null)
            return;
            
        inOrder1(root.left, s);    
        s.add(root.data);
        inOrder1(root.right, s);    
    }
    
    static void inOrder2(Node root, Set<Integer> s, ArrayList<Integer> a)
    {
        if(root == null)
            return;
        
        inOrder2(root.left, s, a);
        
        if(s.contains(root.data))
            a.add(root.data);
        
        inOrder2(root.right, s, a);
    }
}






