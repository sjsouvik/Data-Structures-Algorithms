/*
Given an array of size N that represents a Tree in such a way that array indexes are values in tree nodes and array values give the parent node of that 
particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked 
representation of Binary Tree from this array representation.

Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation:For the array parent[] = {-1,
0, 0, 1, 1, 3, 5}; the tree generated
will have a sturcture like 
         0
       /   \
      1     2
     / \
    3   4
   /
  5
/
6

Example 2:

Input:
N = 5
parent[] = {-1,0,0,2,2}
Output: 0 1 2 3 4
Explanation: For the array parent[] =
{-1 0 0 2 2}; the tree generated will
have a sturcture like
                 0
              /      \
             1        2
          /      \
        3        4

Your Task:
The task is to complete the function createTree() which takes 2 arguments(tree array and N) and returns the root node of the tree constructed.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103

**********************************************************************Solution****************************************************************************/

import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class CreateTree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            GfG gfg = new GfG();
            Node root = gfg.createTree(arr, n);
            
            printLevelOrder(root);
            System.out.println();
        }
    }
    
    public static void printList(Node root)
    {
        while(root != null)
        {
            System.out.print(root.data + " ");
        }
    }
    
    public static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
        {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for(int j=0;j<result.size();j++)
                System.out.print(result.get(j) + " ");
        }
    }
    
    public static int height(Node root)
    {
        if(root == null)
          return 0;          
        else
        {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return(lheight+1);
            else 
		return(rheight+1);
        }
    }
    
    public static void printGivenLevel(Node node, int level)
    {
        if (node == null)
            return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1)
        {
            printGivenLevel(node.left, level-1);
            printGivenLevel(node.right, level-1);
        }
    }
}


class GfG
{
    public static Node createTree(int a[], int n)
    {
        Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < n; i++)
        {
            if(m.containsKey(a[i]))
                m.get(a[i]).add(i);
            else
            {
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                m.put(a[i], al);
            }
        }
        
        Node root = new Node(m.get(-1).get(0));    
        
        Queue<Node> q = new LinkedList<Node>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node removed = q.poll();
            
            if(m.get(removed.data) == null)
                continue;
            
            ArrayList<Integer> l = m.get(removed.data);
            
            if(l.size() == 2)
            {
                removed.left = new Node(l.get(0));
                q.add(removed.left);
                removed.right = new Node(l.get(1));
                q.add(removed.right);
            }
            else
            {
                removed.left = new Node(l.get(0));
                q.add(removed.left);
            }
        }
        
        return root;
    }    
}









