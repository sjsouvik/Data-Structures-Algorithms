/*
Given a complete binary tree, reverse the nodes present at alternate levels.

Example 1:

Input:
             1
          /   \
        3      2

Output:

             1
          /   \
        2      3

Explanation: Nodes at level 2 are reversed.

Example 2:

Input:
              1
          /      \
         2        3
       /  \      /  \
     42   51   63   72

Output:
             1
          /      \
         3        2
       /  \      /  \
     42   51   63   72

Explanation:
Nodes at level 2 are reversed.
Level 1 and 3 remain as it is.


Your Task:  
You dont need to read input or print anything. Complete the function reverseAlternate() which takes root node as input parameter and modifies the given tree in-place.

Note: If you click on Compile and Test the output will be the in-order traversal of the modified tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 

Constraints:
1 ≤ N ≤ 10^4

******************************************************************************Solution*****************************************************************************************************************/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
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
        	    Tree g = new Tree();
	            g.reverseAlternate(root);
	            printInorder(root);
	            System.out.println();
                t--;
            
        }
    }
  
}

class Tree
{
	static void reverseAlternate(Node root)  
    {  
        if(root == null)
            return;
            
        reverseAlternate(root.left, root.right, true);
    }  
    
    static void reverseAlternate(Node root1, Node root2, boolean level)
    {
        //if any of the root nodes are null then return since it's a perfect binary tree and we have reached at the end of the tree
        if(root1 == null || root2 == null)
            return;
        
        //Swapping the data part of both the nodes in alternate levels
        if(level)
        {
            int temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;
        }
        
        reverseAlternate(root1.left, root2.right, !level);
        reverseAlternate(root1.right, root2.left, !level);
    }
}