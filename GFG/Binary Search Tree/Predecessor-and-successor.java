/*
There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, if the 
either of predecessor or successor is not found print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting the number 
of edges of the BST. The next line contains the edges of the BST. The last line contains the key.

Output:
Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.

Constraints:
1<=T<=100
1<=n<=100
1<=data of node<=100
1<=key<=100

Example:
Input:
2
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
65
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
100

Output:
60 70
80 -1

*********************************************************************Solution*****************************************************************************/

import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Res
{
    Node pre = null;
    Node succ = null;
}

class PreSucc
{   
     public static void insert(Node root,int a,int a1,char lr)
     {
        if(root==null)
	{
            return;
        }

        if(root.data==a)
	{
            switch(lr)
	    {
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }

        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
      public static void main (String[] args) 
      {
          Scanner sc=new Scanner(System.in);
          int t = sc.nextInt();
          
          while(t-->0)
	  {
              int n = sc.nextInt();
              if(n==0)
              {
                  System.out.println(0);
                  continue;
              }
              Node root = null;
              Res p = new Res();
              Res s = new Res();
              for(int i=0;i<n;i++)
	      {                
                  int a=sc.nextInt();
                  int a1=sc.nextInt();
                
                  char lr=sc.next().charAt(0);
                
                  if(i==0)
		  {                    
                      root=new Node(a);
                    
                      switch(lr)
                      {                        
                          case 'L':root.left=new Node(a1);
                          break;
                          case 'R':root.right=new Node(a1);
                          break;
                      }
                  }
                  else
		  {
                      insert(root,a,a1,lr);
                  }
              }
            
              int key = sc.nextInt();
              GfG g=new GfG();
              g.findPreSuc(root, p, s, key);
            
              if(p.pre != null)
                  System.out.print(p.pre.data + " ");
              else
                  System.out.print("-1" + " ");
              
              if(s.succ != null)
                  System.out.println(s.succ.data);
              else
                  System.out.println("-1");                        
        }
    }
}


class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        if(root == null)
            return;
            
        findPreSuc(root.left, p, s, key);
        
        if(s.succ != null)
            return;
            
        if(root.data < key)
            p.pre = root;
        else if(s.succ == null && root.data > key)
        {
            s.succ = root;
            return;
        }    
        
        findPreSuc(root.right, p, s, key);
    }
}






