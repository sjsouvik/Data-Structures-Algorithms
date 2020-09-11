/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

    The values smaller than root go to the left side
    The values greater and equal to the root go to the right side

Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range

Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.

Your Task:
This is a function problem. You don't have to take input. You are required to complete the function getCountOfNode() that takes root, l ,h as parameters 
and returns the count.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100
1 <= l < h < 103

*****************************************************************Solution*******************************************************************************/

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
        this.left = this.right = null;
    }
}

class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    Node root=null;
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		   
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        root=Geeks.newNode(root,arr[i]);
		    }
		    int l,h;
		    l=sc.nextInt();
		    h=sc.nextInt();
		    System.out.println(Geeks.getCountOfNode(root,l,h));
		
		}
	}
}


class Geeks
{
    public static Node createNewNode(int value)
    {
        Node temp=new Node(value);
        
        return temp;
    }
    static public Node newNode(Node root,int data)
    {
        if(root==null)
        root=createNewNode(data);
        else if(data<root.data)
        root.left=newNode(root.left,data);
        else
        root.right=newNode(root.right,data);
        
        return root;
    }  

    /* This approach requires extra space to store the nodes within the given range. Also, extra space of O(h) for recursion function call stack. However, it takes less time complexity of O(k) where, k = no of nodes within the given range. */
    public static int getCountOfNode1(Node root,int l, int h)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        print(root, l, h, al);
        return al.size();
    }
    
    static void print(Node root, int l, int h, ArrayList<Integer> a)
    {
        if(root == null)
            return;
            
        if(root.data < l)
        {
            print(root.right, l, h, a);
            return;
        }
        if(root.data > h)
        {
            print(root.left, l, h, a);
            return;
        }
        
        print(root.left, l, h, a);
        a.add(root.data);
        print(root.right, l, h, a);
    }
    
    //Another way of solving the same problem. Here, space complexity is optimized, had used ArrayList to store the data of nodex that lie in the given range. 
    static int count;
    public static int getCountOfNode(Node root,int l, int h)
    {
        count = 0; //need to initialize here, so that it doesn't hold the count of nodes that lie in the given range for the last testcase. if we don't initialize then it would hold the count of nodes for the previous testcase and as a result will get wrong answer for other testcases
        return countOfNodes(root, l, h);
    }
    
    static int countOfNodes(Node root,int l, int h)
    {
        if(root == null)
            return 0;
        
        if(root.data < l)
        {
            return countOfNodes(root.right, l, h);
        }
        if(root.data > h)
        {
            return countOfNodes(root.left, l, h);
        }
        
        int left = countOfNodes(root.left, l, h);
        count++;
        int right = countOfNodes(root.right, l, h);
        
        return count;
    }    
}
  




