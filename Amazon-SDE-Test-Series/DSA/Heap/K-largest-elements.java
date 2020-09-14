/*
Given an array of N positive integers, print k largest elements from the array. 

Example 1:

Input:
N = 5, k = 2
arr[] = {12,5,787,1,23}
Output: 787 23
Explanation: First largest element in
the array is 787 and the second largest
is 23.

Example 2:

Input:
N = 7, k = 3
arr[] = {1,23,12,9,30,2,50}
Output: 50 30 23
Explanation: Three Largest element in
the array are 50, 30 and 23.

Your Task:
Complete the function kLargest() that takes the array, N and K as input parameters and returns a list of k largest element in descending order. 

Expected Time Complexity: O(N log K)
Expected Auxiliary Space: O(K)

Constraints:
1 ≤ N ≤ 104
K ≤ N
1 ≤ array[i] ≤ 105

*********************************************************************Solution**************************************************************************/

import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution T = new Solution();
            ArrayList<Integer> list = T.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}


class Solution
{
    //Solution using Min Heap --- time complexity - O(k + (n - k)logk) --- optimized one
    /* The idea is to construct Min Heap of size 'k' by inserting 1st 'k' elements of the array into the heap. 
    Then, for each of the remaining items of the array, if the item is more than the root of the heap, we replace the root of the heap with the current element. 
    Thus, we'll have k-largest elements of the array in the min heap and the k-th largest element will reside at the root of the min heap */
    public static ArrayList<Integer> kLargest1(int a[], int n, int k)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
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
        
        //O(k) times to add the 'k' largest items into ArrayList
        while(!minHeap.isEmpty())
        {
            al.add(minHeap.poll());
        }
        
        Collections.reverse(al); //this is to get the k-largest elements in descending order
        
        return al;
    }
    
    //Solution using Max Heap --- this will have more time complexity O(n + klogn)
    /* The idea is to build Max Heap of 'n' items of the array. Then, we pop 1st 'k' items from Max Heap */
    public static ArrayList<Integer> kLargest(int a[], int n, int k)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //O(n) times to build heap of 'n' items
        for(int i = 0; i < n; i++)
            maxHeap.add(a[i]);
        
        //O(klogn) times to extractMax() for 'k' times
        while(k-- > 0)
            al.add(maxHeap.poll());
        
        return al;
    }
}




