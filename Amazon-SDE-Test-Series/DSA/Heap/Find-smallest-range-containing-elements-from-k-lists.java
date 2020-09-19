/*
Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists. If more than one 
such range's are found, find the first such range found.

Example 1:

Input:
N = 5, K = 3
KSortedArray[][] = {{1 3 5 7 9},
                    {0 2 4 6 8},
                    {2 3 5 7 11}}
Output: 1 2
Explanation: K = 3
A:[1 3 5 7 9]
B:[0 2 4 6 8]
C:[2 3 5 7 11]
Smallest range is formed by number 1
present in first list and 2 is present
in both 2nd and 3rd list.

Example 2:

Input:
N = 4, K = 3
KSortedArray[][] = {{1 2 3 4},
                    {5 6 7 8},
                    {9 10 11 12}}
Output: 4 9

Your Task :

Complete the function findSmallestRange() that receives array , array size n and k as parameters and returns the output range (as a pair<int,int> in 
cpp and array of size 2 in java and python)

Expected Time Complexity : O(n * k *log k)
Expected Auxilliary Space  : O(k)

Constraints:
1 <= K,N <= 500

*********************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new smallestRangeFromKLists().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

/*
    The time complexity of heap based solution is O(Nk Log k).
    
    The algorithm for the solution is as following:
    
    1. Create a min heap of size k and insert first elements of all k lists into the heap.
    2. Maintain two variables min and max to store minimum and maximum values present in the heap at any point. Note min will always contain value of the root of the heap.
    3. Repeat following steps
        i) Get the minimum element from the heap (minimum is always at root) and compute the range.
        ii) Replace heap root with next element of the list from which the min element is extracted. After replacing the root, heapify the tree. Update max if next element is greater. If the list doesn’t have any more elements, break the loop.

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


class smallestRangeFromKLists
{
	static int[] findSmallestRange(int[][] a, int n, int k)
	{
	    int res[] = new int[2];
	    
	    int max = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
	    
	    Queue<Triplet> minHeap = new PriorityQueue<Triplet>();
	    
	    //this is to insert 1st element (with position of the array in the 2D array, position of the value in the array) of all the arrays into the heap
	    for(int i = 0; i < k; i++)
	    {
	        minHeap.add(new Triplet(a[i][0], i, 0));
	        max = Integer.max(max, a[i][0]); //this is to store max element in the heap at any point
	    }    
	    
	    while(true)
	    {
	        //At every pop operation, we compute range (max - removed.value) and return the minimum range or difference found 
	        Triplet removed = minHeap.poll();
	        
	        if(max - removed.value < diff) //if current range or difference is less than the previous calculated range then store the current range or differnce with min and max value of the range
	        {
	            diff = max - removed.value;
	            res[0] = removed.value; //stores the min value of the range
	            res[1] = max; //stores the max value of the range
	        }
	        
	        int arrayPosition = removed.positionOfArray, valuePosition = removed.positionOfValueInTheArray;
	        
	        if(valuePosition + 1 == n) //if there's no more element in the list from which the element is extracted in the current pop operation then break the loop and return the result array
	            break;
	            
	        else //else, insert the next element from the same list as popped element 
	        {
	            minHeap.add(new Triplet(a[arrayPosition][valuePosition + 1], arrayPosition, valuePosition + 1));    
	            max = Integer.max(max, a[arrayPosition][valuePosition + 1]);
	        }
	    }
	    
	    return res;
	}
}








