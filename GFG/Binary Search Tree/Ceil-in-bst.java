/*
Given a BST and a number X. The task it to find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

Example 1:

Input:
      5
    /   \
   1     7
    \
     2 
      \
       3
X = 3
Output: 3
Explanation: We find 3 in BST, so ceil
of 3 is 3.

Example 2:

Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8
X = 6
Output: 7
Explanation: We find 7 in BST, so ceil
of 6 is 7.

Your task:
Just complete the function findCeil() to implement ceil in BST which return the ceil of X in the given BST.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 105
1 <= Value of nodes<= 105

***********************************************************************Solution**************************************************************************/

import java.io.*;
import java.lang.*;
import java.util.*;

class Node 
{
    int data;
    Node left, right;
    Node(int key)
    {
        this.data = key;
        this.left = this.right = null;
    }
}

class ceilInBST 
{ 
    static Node insertInBST(Node root, int key) 
    { 
        if (root == null) 
	    return new Node(key); 
	if (key < root.data) 
	    root.left = insertInBST(root.left, key); 
	else 
	    root.right = insertInBST(root.right, key); 
	return root; 
    }
    
    public static void main (String[] args) throws IOException  
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    Node root = null;
		    inputLine = br.readLine().trim().split(" ");
		    root = insertInBST(root, Integer.parseInt(inputLine[0]));
		    for(int i=1; i<n; i++)
		    {
		        insertInBST(root, Integer.parseInt(inputLine[i]));
		    }
		    int k = Integer.parseInt(br.readLine().trim());
		    GfG g = new GfG();
		    System.out.println(g.findCeil(root, k));
		}
     }
}


class GfG 
{
    /* Time Complexity : O(h), h = height of the BST, Aux space : O(1) to find the number that is equal to x or immediately greater than x */
    int findCeil(Node root, int key) 
    { 
        int ceil = -1;
        
        Node curr = root;
        
        while(curr != null)
        {
            if(key > curr.data)
                curr = curr.right;
            else if(key < curr.data)
            {
                ceil = curr.data;
                curr = curr.left; 
            }
            else
                return curr.data;
        }
        
        return ceil;
    } 
}






