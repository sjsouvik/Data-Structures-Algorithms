/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is 
viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3

Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100

Your Task:
Since this is a function problem. You don't have to take input. Just complete the function printTopView() that takes root node as parameter and prints 
the top view. The newline is automatically appended by the driver code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= Node Data <= 105

**************************************************************************Solution**************************************************************************/

import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data=d;
        left=right=null;
    }
}


class GfG
{    
    public static void main(String[] args)throws IOException
    {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
        {
            Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;

            while(n > 0)
	    {
                int a1 = Integer.parseInt(input[j]);
                int a2 = Integer.parseInt(input[j+1]);
                char lr = input[j+2].charAt(0);
                j+=3;
            
                if(root == null)
                {
                    root = new Node(a1);
                    q.add(root);
                }
            
                Node pick = q.peek();
            
                q.remove();
            
                if(lr=='L')
		{
                    pick.left = new Node(a2);
                    q.add(pick.left);
                }

                a1 = Integer.parseInt(input[j]);
                a2 = Integer.parseInt(input[j+1]);
                lr = input[j+2].charAt(0);
                j += 3;
            
                if(lr=='R')
		{
                    pick.right = new Node(a2);
                    q.add(pick.right);
                }
            
                n-=2;
            }

            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}


class pair
{
    Node node;
    int hd;
    
    pair(Node n, int d)
    {
        node = n;
        hd = d;
    }
}

//Note : Concept of horizontal distance with level order traversal has been used here to understand the nodes in the same vertical line, nodes are having same horizontal distance means they are in the same vertical line. horizontal distance of any node = if the node is left node then (horizontal distance of root node - 1), else if the node is right node then (horizontal distance of root node + 1), it starts from root with horizontal distance as 0
/* The solution is very much similar like vertical traversal of binary tree, in case of vertical traversal, we use ArrayList to store data of all nodes having same horizontal distance (same horizontal distance means they are in same vertical line) but in this problem, we need to store only the data of single node having the unique horizontal distance which comes 1st in the level order traversal */
class View
{
    static void topView(Node root)
    {
        Queue<pair> q = new LinkedList<pair>();
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        
        if(root != null)
            q.add(new pair(root, 0));
        
        while(!q.isEmpty())
        {
            pair removedPair = q.poll();
            Node removedNode = removedPair.node;
            int hd = removedPair.hd;
            
            if(!tm.containsKey(hd))
                tm.put(hd, removedNode.data);
                
            if(removedNode.left != null)
                q.add(new pair(removedNode.left, hd - 1));
            
            if(removedNode.right != null)
                q.add(new pair(removedNode.right, hd + 1));    
        }
        
        for(Map.Entry<Integer, Integer> m : tm.entrySet())
            System.out.print(m.getValue() + " ");
    }
}








