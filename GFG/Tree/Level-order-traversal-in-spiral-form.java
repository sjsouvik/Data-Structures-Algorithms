/*
Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 

Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically 
appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105

********************************************************************Solution**************************************************************************/

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


    void inOrder(Node node) 
    {
        if (node == null) 
	{
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0)
		{
	            String s = br.readLine();
    	    	    Node root = buildTree(s);
                    Spiral g = new Spiral();

                    g.printSpiral(root);

		    System.out.println();    	        
	        }
	}
}


class Spiral
{
    void printSpiral(Node node) 
    {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
          
        if(node != null)
            s1.push(node);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node popped = s1.pop();
                System.out.print(popped.data + " ");
                
                if(popped.right != null)
                    s2.push(popped.right);    
                
                if(popped.left != null)
                    s2.push(popped.left);
            }
            
            while(!s2.isEmpty())
            {
                Node popped = s2.pop();
                System.out.print(popped.data + " ");
                
                if(popped.left != null)
                    s1.push(popped.left);    
                
                if(popped.right != null)
                    s1.push(popped.right);
            }
        }
    }
    
    //Another way to solve this problem where doing normal level order traversal and using stack to reverse the order of items wherever it's required to make it spiral
    void printSpiral1(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        boolean reverse = true;
        
        if(node != null)
            q.add(node);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node removed = q.poll();
                
                if(reverse)
                    s.push(removed);
                else
                    System.out.print(removed.data + " ");
                
                if(removed.left != null)
                    q.add(removed.left);
                
                if(removed.right != null)
                    q.add(removed.right);
            }
            
            reverse = !reverse;
            
            while(!s.isEmpty())
                System.out.print(s.pop().data + " ");
        }
    }
}









