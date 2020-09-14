/*
Given an array arr[] of N positive integers and a number K. The task is to find the kth largest element in the array.

Example 1:

Input:
5 3
3 5 4 2 9

Output: 
4

Explanation: 
Third largest element
in the array is 4.

Example 2:

Input:
5 5
4 3 7 6 5 

Output: 
3

Explanation: 
Fifth largest element
in the array is 3.

Your Task:
You are required to complete the method KthLargest() which takes 3 arguments and returns the Kth Largest element.

Constraints:
1 <= N <= 106
1 <= arr[i] <= 106
1 <= K <= N

Expected Time Complexity : O(NlogK)
Expected Auxilliary Space : O(K)

********************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg 
{
    public static void main(String args[]) 
    {        
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking count of testcases
        int t = sc.nextInt();

        while (t-- > 0) 
	{            
            //taking count of elements
            int n = sc.nextInt();
            
            //taking the value of k
            int k = sc.nextInt();

            //Creating an array of size n
            int arr[] = new int[n];

            //adding all the elements to arr
            for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

            //calling the method KthLargest of class solve
            //and printing the result
            System.out.println(new solve().KthLargest(arr, n, k));
        }
    }
}


class solve 
{
    //Solution using Min Heap --- time complexity - O(k + (n - k)logk) --- optimized one
    /* The idea is to construct Min Heap of size 'k' by inserting 1st 'k' elements of the array into the heap. 
    Then, for each of the remaining items of the array, if the item is more than the root of the heap, we replace the root of the heap with the current element. 
    Thus, we'll have k-largest elements of the array in the min heap and the k-th largest element will reside at the root of the min heap */
    public static int KthLargest1(int a[], int n, int k) 
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        //O(k) times to build heap of 1st 'k' items
        for(int i = 0; i < k; i++)
            minHeap.add(a[i]);
        
        //O((n - k)logk) times to compare and replace the root of the heap since in this case insert and extractMin() both are log(k) operation 
        for(int i = k; i < n; i++)
        {
            if(a[i] > minHeap.peek())
            {
                minHeap.poll();
                minHeap.add(a[i]);
            }
        }
        
        return minHeap.poll();
    }
    
    //Solution using Max Heap --- this will have more time complexity O(n + klogn)
    /* The idea is to build Max Heap of 'n' items of the array. Then, we pop 1st 'k - 1' items from Max Heap. Now, the k-th largest will reside at root of the heap */
    public static int KthLargest(int a[], int n, int k) 
    {
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //O(n) times to build heap of 'n' items
        for(int i = 0; i < n; i++)
            maxHeap.add(a[i]);
        
        //O(klogn) times to extractMax() for 'k' times
        while(k-- > 1)
            maxHeap.poll();
        
        return maxHeap.poll();     
    }
}







