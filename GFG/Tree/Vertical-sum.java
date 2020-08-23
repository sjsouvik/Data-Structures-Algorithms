/*
Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines starting from 
left-most vertical line to right-most vertical line.

Example 1:

Input:
       1
    /   \
  2      3
 / \    / \
4   5  6   7
Output: 
Explanation:
The tree has 5 vertical lines
Vertical-Line-1 has only one node
4 => vertical sum is 4
Vertical-Line-2: has only one node
2=> vertical sum is 2
Vertical-Line-3: has three nodes:
1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3
=> vertical sum is 3
Vertical-Line-5: has only one node 7
=> vertical sum is 7

Your Task:
You don't need to take input. Just complete the function verticalSum() that takes root node of the tree as parameter and returns an array containing 
the vertical sum of tree from left to right.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of nodes<=1000

**********************************************************************Solution***************************************************************************/

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
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
        	    Tree g = new Tree();
			
		    ArrayList <Integer> res = g.verticalSum(root);
		    for (Integer num : res) System.out.print (num + " ");
		    System.out.println();
                    t--;
            
        	}
    	}  
}


class Tree
{
    //to store value in TreeMap requires O(logn) times, here we are storing value with horizontal distance as key, so if there're 'hd' number of unique horizontal distances and 'n' number of nodes then this program takes O(nloghd) times to store all the sum values into TreeMap
    public ArrayList <Integer> verticalSum(Node root) 
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        
        vSum(root, 0, tm);
        
        for(Map.Entry<Integer, Integer> m : tm.entrySet())
            a.add(m.getValue());
        
        return a;
    }
    
    //Note : Concept of horizontal distance has been used here to understand the nodes in the same vertical line, nodes are having same horizontal distance means they are in the same vertical line. 
    /* The idea is to start traversing from root with horizontal distance as 0, then if we traverse the left node then horizontal distance will be (root's horizontal distance - 1) and for right node it will be (root's horizontal distance + 1). 
       We will be storing data of nodes with its horizontal distance as key in a TreeMap, nodes with same horizontal distance are in same vertical line and we are using TreeMap so that we can get the output in key sorted order since it's required as per the problem statement */
    void vSum(Node root, int hd, TreeMap<Integer, Integer> tm)
    {
        if(root == null)
            return;
        
        int sum = (tm.containsKey(hd) == false) ? 0 : tm.get(hd);
        tm.put(hd, sum + root.data);
        
        vSum(root.left, hd - 1, tm);
        vSum(root.right, hd + 1, tm);
    }
}









