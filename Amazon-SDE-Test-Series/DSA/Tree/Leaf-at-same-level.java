/*
Given a Binary Tree, check if all leaves are at same level or not.

          12
        /    \
      5       7       
    /          \ 
   3            1
  Leaves are at same level

          12
        /    \
      5       7       
    /          
   3          
   Leaves are Not at same level


          12
        /    
      5             
    /   \        
   3     9
  /      /
 1      2
 Leaves are at same level

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the 
tree as described below: 

    The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes 
NULL child.

    For example:
      
    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Output for each test case will be 0 if all leaves are not at same level else it will 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function check() which takes the root node as input and returns true/false 
depending upon whether all the leaf nodes are at the same level or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <=T<= 1000
1 <= Number of nodes<= 1000
1 <= Data of a node<= 10000

Example(To be used only for expected output):
Input
2
2
1 2 3
4
10 20 30 10 15
Output
1
0
 
*********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Is_Leaves_At_Same_Level
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

    
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
        
            GfG g = new GfG();
	    boolean b = g.check(root);

	    if(b == true)
	        System.out.println(1);
	    else
		System.out.println(0);
            t--;
        }
    }
}


class GfG
{
    int leafLevel = 0;
    
    boolean check(Node root)
    {
    	return leafAtSameLevel(root, 1) == -1 ? false : true;	
    }
    
    int leafAtSameLevel(Node root, int level)
    {
        if(root == null)
            return 0;
        
        int left = leafAtSameLevel(root.left, level + 1);
        int right = leafAtSameLevel(root.right, level + 1);
        
        if(left == -1 || right == -1)
            return -1;
        
        if(left == 0 && right == 0)
        {
            if(leafLevel == 0)
                leafLevel = level - 1;
            
            if(leafLevel != 0 && leafLevel == level - 1)
                return 1;
            
            return -1;    
        }
        
        return 1;
    }
}










