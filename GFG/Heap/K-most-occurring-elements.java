/*
Given an array arr[] of N integers in which elements may be repeating several times. Also, a positive number K is given and the task is to find sum 
of total frequencies of K most occurring elements

Note: The value of K is guaranteed to be less than or equal to the number of distinct elements in arr.

Example 1:

Input:
N = 8
arr[] = {3,1,4,4,5,2,6,1}
K = 2
Output: 4
Explanation: Since, 4 and 1 are 2 most
occurring elements in the array with
their frequencies as 2, 2. So total
frequency is 2 + 2 = 4.

Example 2:

Input:
N = 8
arr[] = {3,3,3,4,1,1,6,1}
K = 2
Output: 6
Explanation: Since, 3 and 1 are most
occurring elements in the array with
frequencies 3, 3 respectively. So,
total frequency is 6.

Your Task:
Complete the function kMostFrequent() whic returns the frequencies of K most occuring elements.

Constraints:
1 <= N <= 107
1 <= K <= N
1 <= arr[i] <= 106

Expected Time Complexity : O(N)
Expected Auxilliary Space: O(N)

***********************************************************************Solution****************************************************************************/

import java.io.*;
import java.util.*;
import java.lang.*;

class GfG 
{        
    public static void main (String[] args) throws IOException  
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    inputLine = br.readLine().trim().split(" ");
		    int[] arr = new int[n];

		    for(int i=0; i<n; i++)
		    {
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    int k = Integer.parseInt(br.readLine().trim());
		    new solve().kMostFrequent(arr, n, k);
		}
	}
}

class solve
{
    void kMostFrequent(int a[], int n, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
	//using HashMap to store frequency of array items
        for(int i = 0; i < n; i++)
            m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        
	//adding frequency of items into Min Heap to get K-most frequent items
        for(Map.Entry mapItem : m.entrySet())
        {
            minHeap.add((int)mapItem.getValue());
            
	    //if size of min heap goes beyond given value of 'k' then we need to remove items from heap to maintain the size 'k' since the last 'k' items in the heap will give 'k' most frequent items
            if(minHeap.size() > k) 
                minHeap.poll();
        }
        
        int sum = 0;
        
        while(!minHeap.isEmpty())
            sum += minHeap.poll();
        
        System.out.println(sum);    
    }
}



