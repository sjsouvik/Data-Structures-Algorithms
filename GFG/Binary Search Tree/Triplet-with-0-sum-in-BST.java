/*
Given a Binary Search Tree (BST), write a function isTripletPresent() that returns true if there is a triplet in given BST with sum equals to 0, 
otherwise returns false.

Input:
First line consists of T test case. First line of every test case consists of N, denoting the number of nodes in bst. Second line of every test case 
consists of nodes.

Output:
Single line output, return true if triplet found else false.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
5
5 -8 -2 10 11
4
1 3 -2 0 5
Output:
1
0

*********************************************************************Solution*****************************************************************************/

import java.util.*;

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

class Triplet
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            
            GfG gfg = new GfG();
            boolean res = gfg.isTriplet(root);
            
            if(res == true)
              System.out.println(1);
            else
              System.out.println(0);
        }
    }
    
      public static Node insert(Node root, int x)
      {
          if(root == null)
          {
              return (new Node(x));
          }
          
          if(x < root.data)
          {
              root.left = insert(root.left, x);
          }
          else if(x > root.data)
          {
              root.right = insert(root.right, x);
          }
          
          return root;
      }
}

class GfG
{
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int sum = 0;
    
    public static boolean isTriplet(Node root)
    {
        list = new ArrayList<>();
        inorder(root);
        return isTripletUtil(root, sum);
    }
    
    public static void inorder(Node root)
    {   
        if(root == null)
            return;
            
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    
    public static boolean isTripletUtil(Node root, int sum)
    {
        for(int i = 0; i < list.size() - 1; i++)
        {
            Set<Integer> set = new HashSet<Integer>();
            int rem = sum - list.get(i);
            
            for(int j = i+1; j < list.size(); j++)
            {
                if(set.contains(rem - list.get(j)))
                    return true; 
                    //System.out.println(list.get(i)+" "+list.get(j)+" "+(rem - list.get(j)));
                 
                set.add(list.get(j));
            }
        }
        
        return false;
    }
}



