/*
Given a binary tree, print preorder traversal of it.
For example: preorder traversal of below tree is "1 10 5 39"

        1
     /     \
   10     39
  /
5

Input:
The first line of input contains the number of test cases T. For every test case, the first line of input contains two space-separated integers, denoting 
node values for which we want to find LCA,  and the second line will contain a string representing the tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

     
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should print preorder traversal.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function preorder() that takes the root node of the 
tree as input and returns an array containing the preorder traversal of the tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 200
1 <= Number of nodes <= 104
1 <= Data of a node <= 105

Example:
Input:
2
1 4 N 4 2 
6 3 2 N 1 2 
Output:
1 4 4 2
6 3 1 2 2 

Explanation:
Testcase 1: There are 4 nodes in the tree. it looks like:

                                      1
                                     /      
                                  4
                                /    \
                             4       2
 Its Preorder is 1 4 4 2 
Testcase 2: In the similar way for the given input its preorder traversal will be 6 3 1 2 2 .

**********************************************************************Solution*****************************************************************************/

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
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
            if(!currVal.equals("N")) {
                    
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                ArrayList<Integer> res = BinaryTree.preorder(root);
                for (Integer num : res)
                    System.out.print(num + " ");
                System.out.println();
                t--;
            
        }
    }
   
}


class BinaryTree
{
    //recursive solution to do preorder traversal
    static ArrayList<Integer> preorder1(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        res = preOrder(root, res);
        
        return res;
    }
    
    static ArrayList<Integer> preOrder(Node root, ArrayList<Integer> res)
    {
        if(root != null)
        {
            res.add(root.data);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
        
        return res;
    }
    
    //iterative solution to do preorder traversal - it takes O(n) auxiliary space where n = no of nodes
    static ArrayList<Integer> preorder2(Node root)
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        
        //will push the root node 1st into stack
        if(root != null)
            s.push(root);
        
        /* then, pop the root node from stack and push right and left node respectively for each subtree, 
        will be pushing right node 1st and then left node to keep left node at peek */
        while(!s.isEmpty())
        {
            Node curr = s.pop();
            l.add(curr.data);
            
            if(curr.right != null)
                s.push(curr.right);
                
            if(curr.left != null)
                s.push(curr.left);
        }
        
        return l;
    }
    
    //more optimized iterative solution to do preorder traversal - it takes O(h) auxiliary space where h = height of binary tree
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        
        Node curr = root;
        
        /* for each node will follow 3 steps : i) print the data, ii) push the right node if present, iii) move to left node if present and follow these 3 stpes until there's no left node. 
        Once there's no left node, will pop nodes from stack which all will be right nodes and will follow all steps from beginning for all these popped nodes */
        while(curr != null || !s.isEmpty())
        {
            while(curr != null)
            {
                al.add(curr.data);
                
                if(curr.right != null)
                    s.push(curr.right);
                
                curr = curr.left;    
            }
            
            if(!s.isEmpty())
                curr = s.pop();
        }
        
        return al;
    }
    
}






