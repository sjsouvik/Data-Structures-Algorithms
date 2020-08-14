/*
Given the binary Tree of and two-node values. Check whether the two-node values are cousins of each other or not.

Input:
The first line of input contains the number of test cases T. For each test case, there will be two lines of input, First input is a string representing the 
tree as described below and the second line contains two space-separated integers denoting node values: 

    The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

    For example:

    For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Single line output, print "1" if they are cousins else "0".
Your Task:
You don't need to read input or print anything. Your task is to complete the function isCousins() that takes the root node of the tree (having all nodes 
distinct), and two integers 'a' and 'b' as inputs. It returns true if the nodes with given values 'a' and 'b' are Cousins of each other and returns false 
otherwise. 

Two nodes value are cousins of each other if they are at the same level and have different parents.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=T<=1000
1<=N<=1000

Example:
Input:
2
1 2 3
2 3
1 2 3 5 N N 4
4 5
Output:
0
1

Explanation:
Test Case 1: The given Tree is:
    1
   /   \ 
 2     3
Here, nodes 2 and 3 have the same parent node. Thus, they are not cousins of each other.
Test Case 2: The given Tree is:
       1
     /    \ 
   2      3
  /           \
5             4 
Here, nodes 5 and 4 are at the same level and have different parent nodes. Hence, they both are cousins.

*******************************************************************Solution***************************************************************************/

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

class GfG 
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
    
	public static void main (String[] args) throws Exception
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            
	        while(t > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");

        	    int x , y;
	            x = Integer.parseInt(arr[0]);
		    y = Integer.parseInt(arr[1]);
		    
		    if(g.isCousins(root,x,y))
		        System.out.println(1);
		    else
			System.out.println(0);
                    t--;            
        	}
    	}  
}


class Solution 
{
    public boolean isCousins(Node root, int a, int b) 
    {
        Queue<Node> q = new LinkedList<Node>();
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            int c1 = 0, c2 = 0;
            
            while(size-- > 0)
            {
                if(c1 == 1)
                {
                    c2++;
                    
                    if(c2 == 2)
                        return true;
                        
                    c1 = 0;
                }
                
                Node popped = q.poll();
                
                if(popped.left != null)
                {
                    if(popped.left.data == a || popped.left.data == b)
                        c1++;
                        
                    q.add(popped.left);
                }
                
                if(popped.right != null)
                {
                    if(popped.right.data == a || popped.right.data == b)
                        c1++;
                        
                    q.add(popped.right); 
                }
                
                if(c1 == 2)
                    return false;
            }
            
            if(c1 == 1)
            {
                c2++;
                
                if(c2 == 2)
                    return true;
            } 
        }
        
        return false;
    }
}






