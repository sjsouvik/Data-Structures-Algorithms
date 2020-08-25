/*
Given a Binary Tree having positive and negative nodes. Find the maximum sum of a level in the given Binary Tree.

Example 1:

Input :               
             4
          /    \
         2     -5
        / \    / \
      -1   3  -2  6

Output: 6

Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 2'th level is 6
Hence maximum sum is 6


Example 2:

Input :          
            1
          /   \
         2     3
        / \     \
       4   5     8
                / \
               6   7  

Output :  17

Explanation: Maximum sum is at level 2.


Your Task:  
You dont need to read input or print anything. Complete the function maxLevelSum() which takes root node as input parameter and returns the maximum sum 
of any horizontal level in the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 104

***********************************************************************Solution****************************************************************************/

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
        left = null;
        right = null;
    }
}

class Main 
{
    static Node buildTree(String str) 
    {
        if (str.length() == 0 || str.charAt(0) == 'N') 
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

        while (queue.size() > 0 && i < ip.length) 
	{
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) 
	    {
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) 
		break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) 
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

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) 
	{
            String s = br.readLine().trim();
            Node root = buildTree(s);

            GfG g = new GfG();
            System.out.println(g.maxLevelSum(root));
        }
    }
}


class GfG 
{
    public int maxLevelSum(Node root) 
    {
        Queue<Node> q = new LinkedList<Node>();
        int maxSum = Integer.MIN_VALUE;
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int sum = 0;
            
            for(int i = 0; i < size; i++)
            {
                Node removed = q.poll();
                sum += removed.data;
                
                if(removed.left != null)
                    q.add(removed.left);
                    
                if(removed.right != null)
                    q.add(removed.right);
            }
            
            maxSum = Integer.max(sum, maxSum);
        }
        
        return maxSum;
    }
}








