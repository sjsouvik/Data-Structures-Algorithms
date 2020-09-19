/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].

Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].

Your Task:
You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the 
number of sorted arrays. The function should return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList<Integer> 
in java, and list in python)

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)

Note: This space is required for returning the resulted sorted array, other work should be done in O(K) Auxiliary Space.

Constraints:
1 <= K <= 100

*********************************************************************Solution***************************************************************************/

import java.util.*;
import java.io.*;

class GFG
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    	System.out.println();
		    
		    	t--;
		}
	}
}


/*
    The time complexity of heap based solution is O(Nk Log k).
    
    The algorithm for the solution is as following:
    
    1. Create an output array.
    2. Create a min heap of size k and insert 1st element (with position of the array in the 2D array, position of the value in the array) of all the arrays into the heap
    3. Repeat following steps while priority queue is not empty.
       a) Remove minimum element from heap (minimum is always at root) and store it in output array.
       b) Insert next element from the array from which the element is extracted. If the array doesn’t have any more elements, then do nothing.

*/

//we'll be storing objects of this class in the min heap
class Triplet implements Comparable<Triplet>
{
    int value, positionOfArray, positionOfValueInTheArray;
    
    Triplet(int i, int j, int k)
    {
        value = i; //array element
        positionOfArray = j; //position of the array in the 2D array
        positionOfValueInTheArray = k; //position of the value in the array
    }
    
    public int compareTo(Triplet t)
    {
        if(value < t.value)
            return -1;
        return 1;    
    }
}

class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] a, int k) 
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        Queue<Triplet> minHeap = new PriorityQueue<Triplet>();
        
        //this is to insert 1st element (with position of the array in the 2D array, position of the value in the array) of all the arrays into the heap
        for(int i = 0; i < k; i++)
        {
            minHeap.add(new Triplet(a[i][0], i, 0));
        }
        
        while(!minHeap.isEmpty())
        {
            Triplet removed = minHeap.poll();
        
            res.add(removed.value);
            
            int arrayPosition = removed.positionOfArray, valuePosition = removed.positionOfValueInTheArray;
            
            //this is to insert next element from the array from which the element is extracted. If the array doesn’t have any more elements, then do nothing.
            if(valuePosition + 1 < k) //a[arrayPosition].length == k
                minHeap.add(new Triplet(a[arrayPosition][valuePosition + 1], arrayPosition, valuePosition + 1));    
        }
        
        return res;
    }
}




