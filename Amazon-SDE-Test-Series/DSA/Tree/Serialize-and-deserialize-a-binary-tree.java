/*
Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to 
complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to tree and returns it.
Note: The structure of tree must be maintained.

Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3

Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30

Your Task:
The task is to complete two function serialize which takes the root node of the tree as input andstores the tree into an array and deSerialize which 
deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000

************************************************************************Solution****************************************************************************/

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
    
	public static void main (String[] args) throws IOException 
	{
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0)
		{
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}


class Tree 
{
        //Serialize means conversion of tree into array, here we are using -1 to denote 'null' 
	public void serialize(Node root, ArrayList<Integer> a) 
	{
	    if(root == null)
	    {
	        a.add(-1);
	        return;
	    }    
	    
	    a.add(root.data);
	    serialize(root.left, a);
	    serialize(root.right, a);
	}
	
    //DeSerialize means conversion of array (that we got after serializing the tree) to tree
    int index = 0;
    public Node deSerialize(ArrayList<Integer> a)
    {
        if(index == a.size())
            return null;
        
        int data = a.get(index++);
        
        if(data == -1)
            return null;
        
        Node root = new Node(data);
        root.left = deSerialize(a);
        root.right = deSerialize(a);
        
        return root;
    }
}








