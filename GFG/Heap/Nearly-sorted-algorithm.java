/*
Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k 
positions away from its target position respectively. Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N

Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56

**********************************************************************Solution****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
     public static void main (String[] args) throws IOException
     {
         Scanner sc = new Scanner(System.in);
    	 
    	 int t, n, k;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     k = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     nearlySorted(a, n, k); 
    	     System.out.println();
    	 }
     }
	 
	 /* The idea is to construct a min heap of size (K + 1) elements. Then, we remove min from heap and insert next element from the array into the heap and continue the process till both array and heap is exhausted */
	static void nearlySorted(int a[], int n, int k)
	{
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
            //O(k + 1) times to build heap of 1st 'k' items
            for(int i = 0; i <= k; i++)
                minHeap.add(a[i]);
        
            //O((n - k - 1)logk) times to do the work in the loop since in this case insert and extractMin() both are log(k) operation 
            for(int i = k + 1; i < n; i++)
            {
                System.out.print(minHeap.poll() + " ");
                minHeap.add(a[i]);
            }
        
            //O(k + 1) times to print the items from Min Heap
            while(!minHeap.isEmpty())
                System.out.print(minHeap.poll() + " ");
	}
}



