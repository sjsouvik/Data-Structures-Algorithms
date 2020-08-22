/*
Given a binary tree and an integer S, check whether there is root to leaf path wiht its sum as S.

Example 1:

Input:
Tree = 
            1
          /   \
        2      3
S = 2

Output: 0

Explanation:
There is no root to leaf path with sum 2.

Example 2:

Input:
Tree = 
            1
          /   \
        2      3
S = 4

Output: 1

Explanation:
The sum of path from leaf node 3 to root 1 is 4.


Your Task:  
You dont need to read input or print anything. Complete the function hasPathSum() which takes root node and target sum S as input parameter and 
returns true if path exists otherwise it returns false.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 10^4
1 ≤ S ≤ 10^6

***********************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;

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

class GfG 
{
    public static Node buildTree(String str) 
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
            String s = br.readLine();
            Node root = buildTree(s);
            int sum = Integer.parseInt(br.readLine().trim());
            Tree tr = new Tree();
            if (tr.hasPathSum(root, sum)) 
	    {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}


class Tree 
{
    boolean hasPathSum(Node node, int sum) 
    {
        /* if sum becomes less than 0 while checking recursively that means root to leaf path sum is more than the given sum
           Or, if we find a null node that means root to leaf path sum is less than the given sum */
        if(node == null || sum < 0)
            return false;
        
        //if data of any node matches with the sum then sum is found but we also need to check the node is leaf node or not
        if(node.data == sum && node.left == null && node.right == null)
            return true;
            
        boolean left = hasPathSum(node.left, sum - node.data);
        boolean right = hasPathSum(node.right, sum - node.data);
        
        return left || right;
    }
}


