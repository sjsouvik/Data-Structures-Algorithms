/*
Given a Binary Tree and a target key you need to find the level of target key in the given Binary Tree.

           3
         /   \
        2     5
      /   \
     1     4
Key: 4
Level: 3  

Note: if no such key exists then return 0.

Input :
The first line of input contains the number of test cases T. For each test case, there will two lines. The first line of input is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

The second line of the test case is a target value

Output:
For each test return the level of the target value from the binary tree.

Your Task:
This is a function problem. You don't have to take input. Just complete the function getLevel() that takes a node and a target as parameters and returns 
the level of the target value. The new line is automatically appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <=T<= 30
1 <= Number of nodes<= 105
1 <= Data of a node<= 105
1 <= Target <= 105

Example:
Input:
2
1 2 3
4
3 2 5 1 4
4
Output:
0
3

*********************************************************************Solution***************************************************************************/

import java.io.*;
import java.util.*;

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
            Node root = buildTree(s);
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.getLevel(root,target));
            t--;
        }
    }
}


class Solution
{
    int level = 0;
    
    int getLevel(Node node, int data)  
    { 
        level(node, data, 1);
        return level;
    }
    
    
    void level(Node node, int data, int level)
    {
        if(node == null)
            return;
        
        if(node.data == data)
        {
            this.level = level;
            return;
        }
        
        level(node.left, data, level + 1);
        level(node.right, data, level + 1);
    }
}






